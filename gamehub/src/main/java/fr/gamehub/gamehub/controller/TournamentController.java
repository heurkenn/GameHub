package fr.gamehub.gamehub.controller;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import fr.gamehub.gamehub.repository.*;
import jakarta.validation.Valid;
import fr.gamehub.gamehub.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import fr.gamehub.gamehub.service.TournamentService;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/tournament")
public class TournamentController {


    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TournamentService tournamentService;
    
    

    @Transactional
    public void joinTournament(Long tournamentId, Long userId) {
        // Récupérer le tournoi et l'utilisateur
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournoi introuvable avec ID: " + tournamentId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec ID: " + userId));

        // Ajouter l'utilisateur au tournoi (bidirectionnel)
        TournamentService.addParticipant(tournament, user);

        // Sauvegarder les entités mises à jour
        tournamentRepository.save(tournament);
        userRepository.save(user);
    }


    @GetMapping("/tournaments")
    public String showTournaments(Model model) { // à l'affichage de la page, renvoi une liste de tournoi en paramètre
        List<Tournament> tournaments = tournamentRepository.findAll();
        model.addAttribute("tournaments", tournaments);
        return "tournaments";
    }


    @GetMapping("/creation")
    public String Tournament(Model model){
        model.addAttribute("tournament", new Tournament());
        model.addAttribute("categorie", Category.values());
        return "creationTournament";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Tournament> getById(@PathVariable long id) {
        Optional<Tournament> tournament = tournamentService.getTournamentById(id);
        return tournament.map(ResponseEntity::ok)
            .orElseThrow();
    }

    @PostMapping(value = "/submitFormTournament")
    public String submitFormTournament(@Valid @ModelAttribute("tournament") Tournament tournament, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()){
            return "creation";
        }
        tournamentRepository.save(tournament);
        return "redirect:/";
    }

    public static void startTournament(Tournament tournament) {
        Set<Fight> fights = new HashSet<>();
        // Création des combats
        User player1 = null;
        for (User user : tournament.getParticipants()) {
            if (player1 != null){
                User player2 = user;
                Fight fight = new Fight();
                fight.setJoueur1(player1);
                fight.setJoueur2(player2);
                fights.add(fight);
            }
            player1 = user;
        }
        tournament.setCombats(fights);
    }

    public static void nextRound(Tournament tournament){
        Set<Fight> combats = tournament.getCombats();
        int nbJoueurRestant = combats.size();
        Set<User> joueurRestants = new HashSet<>();
        for (Fight combat : combats){
            if (nbJoueurRestant==1){ // S'il n'y avait qu'un combat en cour avant alors on a le gagnant ici
                if (combat.getWinner() != null){ // regarde si le combat a pu être gagné par un des deux joueurs
                    tournament.getClassment().setPremier(combat.getWinner());// dans le cas oui on prend le gagnant et l'autre joueur pour le top 2
                    if (combat.getWinner().equals(combat.getJoueur1())){
                        tournament.getClassment().setDeuxi(combat.getJoueur2());
                    }else{
                        tournament.getClassment().setDeuxi(combat.getJoueur1());
                    }
                }else{ // cas non alors on prends le joueur1 pour le top1 et le joueur 2 pour le top 2
                    tournament.getClassment().setPremier(combat.getJoueur1());
                    tournament.getClassment().setDeuxi(combat.getJoueur2());
                }
            }else{
                if (combat.getWinner() != null){//de même si il y a un gagnant
                    joueurRestants.add(combat.getWinner());
                    if (nbJoueurRestant==2){ // meme procédé et permet d'ajouter un top 3 et 4
                        if (combat.getWinner().equals(combat.getJoueur1())){
                            tournament.getClassment().setTroisi(combat.getJoueur2());
                        }else{
                            tournament.getClassment().setTroisi(combat.getJoueur1());
                        }
                    }
                }else{ // si y'en a pas de gagnant
                    joueurRestants.add(combat.getJoueur1());
                    if (nbJoueurRestant==2){
                        tournament.getClassment().setTroisi(combat.getJoueur2()); // le perdant prend la troisième place
                    }
                }
            }
        }
        Set<Fight> fights = new HashSet<>();
        // Création des combats du prochain round
        if (nbJoueurRestant!=1){ // pas utile si on a deja un vainqueur
            User player1 = null;
            for (User user : joueurRestants) {
                if (player1 != null){
                    User player2 = user;
                    Fight fight = new Fight();
                    fight.setJoueur1(player1);
                    fight.setJoueur2(player2);
                    fights.add(fight);
                }
                player1 = user;
            }
            tournament.setCombats(fights);
        }
    }

    @Scheduled(fixedDelay = 60000)
    public void checkStartTournament(){
        LocalDateTime currentDate = LocalDateTime.now();
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        for (Tournament tournament : tournaments){
            if ( tournament.getDateStart().isBefore(currentDate)){
                startTournament(tournament);
            }
        }
    }

    @Scheduled(fixedDelay = 300000, initialDelay = 300000)
    public void checkNextRound(){
        List<Tournament> tournaments = tournamentService.getAllTournamentsInProgress();
        for(Tournament tournament : tournaments){
            nextRound(tournament);
        }
    }
}
