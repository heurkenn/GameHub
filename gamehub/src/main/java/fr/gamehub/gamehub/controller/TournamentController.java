package fr.gamehub.gamehub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.gamehub.gamehub.model.Tournament;
import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.repository.*;
import fr.gamehub.gamehub.service.TournamentService;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/tournament")
public class TournamentController {


    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private UserRepository userRepository;

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



}
