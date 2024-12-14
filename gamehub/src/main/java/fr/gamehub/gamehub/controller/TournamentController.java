package fr.gamehub.gamehub.controller;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import fr.gamehub.gamehub.repository.*;
import jakarta.validation.Valid;
import fr.gamehub.gamehub.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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


}
