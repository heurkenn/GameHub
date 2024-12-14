package fr.gamehub.gamehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gamehub.gamehub.model.Tournament;
import fr.gamehub.gamehub.service.TournamentService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    // Afficher tous les tournois
    @GetMapping
    public String getAllTournaments(Model model) {
        model.addAttribute("allTournaments", tournamentService.getAllTournaments());
        return "tournaments"; // Vue : tournaments.html
    }

    // Afficher le formulaire de création d'un tournoi
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tournament", new Tournament());
        return "tournament_form"; // Vue : tournament_form.html
    }

    // Soumettre un formulaire pour créer un tournoi
    @PostMapping("/create")
    public String createTournament(@Valid Tournament tournament, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Erreur lors de l'ajout du tournoi.");
            return "tournament_form";
        }
        tournamentService.saveTournament(tournament);
        return "redirect:/tournaments";
    }

    // Supprimer un tournoi
    @PostMapping("/delete")
    public String deleteTournament(@RequestParam Long tournamentId) {
        tournamentService.deleteTournamentById(tournamentId);
        return "redirect:/tournaments";
    }
}
