package fr.gamehub.gamehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gamehub.gamehub.model.Admin;
import fr.gamehub.gamehub.model.Game;
import fr.gamehub.gamehub.model.Tournament;
import fr.gamehub.gamehub.service.AdminService;
import fr.gamehub.gamehub.service.GameService;
import fr.gamehub.gamehub.service.TournamentService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin-dashboard")
public class AdminController {

    @Autowired
    private GameService gameService;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private AdminService adminService;

    /**
     * Affiche la page d'administration avec les listes des entités.
     */
    @GetMapping
    public String adminDashboard(Model model) {
        model.addAttribute("games", gameService.getAllGames());
        model.addAttribute("tournaments", tournamentService.getAllTournaments());
        model.addAttribute("admins", adminService.getAllAdmins());
        model.addAttribute("newGame", new Game());
        model.addAttribute("newTournament", new Tournament());
        model.addAttribute("newAdmin", new Admin());
        return "admin-dashboard";
    }

    /**
     * Ajouter un nouveau jeu.
     */
    @PostMapping("/admin-dashboard")
    public String addGame(
            @Valid @ModelAttribute("newGame") Game game,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "redirect:/admin-dashboard?error=game";
        }
        gameService.saveGame(game);
        return "redirect:/admin-dashboard";
    }

    /**
     * Supprimer un jeu.
     */
    @PostMapping("/games/delete")
    public String deleteGame(@RequestParam Long gameId) {
        gameService.deleteGame(gameId);
        return "redirect:/admin-dashboard";
    }

    /**
     * Ajouter un tournoi.
     */
    @PostMapping("/tournaments")
    public String addTournament(
            @Valid @ModelAttribute("newTournament") Tournament tournament,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "redirect:/admin-dashboard?error=tournament";
        }
        tournamentService.saveTournament(tournament);
        return "redirect:/admin-dashboard";
    }

    /**
     * Supprimer un tournoi.
     */
    @PostMapping("/tournaments/delete")
    public String deleteTournament(@RequestParam Long tournamentId) {
        tournamentService.deleteTournamentById(tournamentId);
        return "redirect:/admin-dashboard";
    }

    /**
     * Ajouter un administrateur.
     */
    @PostMapping("/admins")
    public String addAdmin(
            @Valid @ModelAttribute("newAdmin") Admin admin,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "redirect:/admin-dashboard?error=admin";
        }
        adminService.saveAdmin(admin);
        return "redirect:/admin-dashboard";
    }

    /**
     * Supprimer un administrateur.
     */
    @PostMapping("/admins/delete")
    public String deleteAdmin(@RequestParam Long adminId) {
        adminService.deleteAdminById(adminId);
        return "redirect:/admin-dashboard";
    }
}
