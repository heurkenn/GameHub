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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.gamehub.gamehub.model.Category;
import fr.gamehub.gamehub.model.Classement;
import fr.gamehub.gamehub.model.Fight;
import fr.gamehub.gamehub.model.Tournament;
import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.repository.ClassementRepository;
import fr.gamehub.gamehub.repository.TournamentRepository;
import fr.gamehub.gamehub.repository.UserRepository;
import fr.gamehub.gamehub.service.TournamentService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller


public class TournamentController {
    

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private ClassementRepository classementRepository;

    
    

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

    //fonction horloge dynamique pour le début de tournoi

    
    
    @GetMapping("/tournaments")
    public String showTournaments(Model model) { // à l'affichage de la page, renvoi une liste de tournoi en paramètre
        List<Tournament> tournaments = tournamentRepository.findAll();
        model.addAttribute("tournaments", tournaments);
        return "tournaments";
    }

    @GetMapping("/tournaments/creation")
    public String Tournament(Model model){
        model.addAttribute("tournament", new Tournament());
        model.addAttribute("categorie", Category.values());
        return "creationTournament";
    }

    @GetMapping("/tournaments/users/{id}")
    public ResponseEntity<Tournament> getById(@PathVariable long id) {
        Optional<Tournament> tournament = tournamentService.getTournamentById(id);
        return tournament.map(ResponseEntity::ok)
            .orElseThrow();
    }

    @PostMapping(value = "/tournaments/submitFormTournament")
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

    public static void nextRound(Tournament tournament, ClassementRepository classementRepository) {
        Set<Fight> combats = tournament.getCombats();
        int nbJoueurRestant = combats.size();
        Set<User> joueurRestants = new HashSet<>();
        Classement classement = tournament.getClassement();
        if (classement == null) {
            classement = new Classement();
            classement.setTournament(tournament);
        }
        for (Fight combat : combats) {
            if (nbJoueurRestant == 1) { // Dernier combat, détermination des vainqueurs
                if (combat.getWinner() != null) { // Si un gagnant est défini
                    classement.setPremier(combat.getWinner());
                    // Déterminer le deuxième joueur
                    if (combat.getWinner().equals(combat.getJoueur1())) {
                        classement.setDeuxieme(combat.getJoueur2());
                    } else {
                        classement.setDeuxieme(combat.getJoueur1());
                    }
                } else { // Pas de gagnant, prendre les deux joueurs restants
                    classement.setPremier(combat.getJoueur1());
                    classement.setDeuxieme(combat.getJoueur2());
                }
            } else {
                if (combat.getWinner() != null) { // Ajouter les gagnants à la liste des joueurs restants
                    joueurRestants.add(combat.getWinner());

                    // Déterminer le troisième joueur s'il reste deux combats
                    if (nbJoueurRestant == 2) {
                        if (combat.getWinner().equals(combat.getJoueur1())) {
                            classement.setTroisieme(combat.getJoueur2());
                        } else {
                            classement.setTroisieme(combat.getJoueur1());
                        }
                    }
                } else { // Si aucun gagnant, prendre joueur1
                    joueurRestants.add(combat.getJoueur1());

                    // Déterminer le troisième joueur s'il reste deux combats
                    if (nbJoueurRestant == 2) {
                        classement.setTroisieme(combat.getJoueur2());
                    }
                }
            }
        }

        // Sauvegarder le classement mis à jour
        classementRepository.save(classement);

        Set<Fight> fights = new HashSet<>();
        // Création des combats du prochain round si nécessaire
        if (nbJoueurRestant != 1) { // Pas besoin de combats si le tournoi est terminé
            User player1 = null;
            for (User user : joueurRestants) {
                if (player1 != null) {
                    User player2 = user;
                    Fight fight = new Fight();
                    fight.setJoueur1(player1);
                    fight.setJoueur2(player2);
                    fights.add(fight);
                }
                player1 = user;
            }
            if (nbJoueurRestant%2==1){ //si le nombre de joueur est impair il y a donc un nominé d'office pour le prochain round
                Fight fight = new Fight();
                fight.setJoueur1(player1);
                fight.setJoueur2(player1);
                fight.setWinner(player1);
                fights.add(fight);
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
public void checkNextRound() {
    List<Tournament> tournaments = tournamentService.getAllTournamentsInProgress();
    for (Tournament tournament : tournaments) {
        // Appeler nextRound en passant le repository pour gérer le classement
        nextRound(tournament, classementRepository);

        // Sauvegarder les changements du tournoi (combats mis à jour)
        tournamentService.saveTournament(tournament);
    }
}

}
