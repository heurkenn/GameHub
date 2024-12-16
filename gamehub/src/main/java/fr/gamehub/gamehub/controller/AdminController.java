package fr.gamehub.gamehub.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gamehub.gamehub.model.Category;
import fr.gamehub.gamehub.model.Game;
import fr.gamehub.gamehub.model.Tournament;
import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.service.GameService;
import fr.gamehub.gamehub.service.PlatformService;
import fr.gamehub.gamehub.service.TournamentService;
import fr.gamehub.gamehub.service.UserService;

@Controller
@RequestMapping("/admin-dashboard")
public class AdminController {

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private TournamentService tournamentService;


    /**
     * Affiche la page d'administration avec la liste des utilisateurs ayant un rôle spécifique.
     */
    @GetMapping
    public String adminDashboard(Model model) {
        model.addAttribute("games", gameService.getAllGames());
        model.addAttribute("categories", Category.values());
        model.addAttribute("platforms", platformService.findAllPlatforms()); // Ajoute les plateformes à la vue
        model.addAttribute("admins", userService.findAllUsersWithRole("ROLE_ADMIN")); // Liste des administrateurs
        model.addAttribute("users", userService.findAllUsers());
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        tournaments.forEach(tournament -> {
            if (tournament.getDateStart() != null) {
                tournament.setFormattedDateStart(tournament.getDateStart().format(formatter));
            }
            if (tournament.getDateEnd() != null) {
                tournament.setFormattedDateEnd(tournament.getDateEnd().format(formatter));
            }
        });

        model.addAttribute("tournaments", tournaments);
        model.addAttribute("tournament", new Tournament());
        return "admin-dashboard"; // Vue : admin-dashboard.html
    }

    /**
     * Attribuer le rôle ADMIN à un utilisateur existant.
     */
    @PostMapping("/admins/assign")
    public String assignAdminRole(@RequestParam Long userId, @RequestParam Long gameId, Model model) {
        Optional<User> optionalUser = userService.getUserById(userId);
        Optional<Game> optionalGame = gameService.getGameById(gameId);

        if (optionalUser.isPresent() && optionalGame.isPresent()) {
            User user = optionalUser.get();

            // Vérifier si l'utilisateur possède déjà le rôle ADMIN
            if (!user.getRoles().contains("ROLE_ADMIN")) {
                user.getRoles().add("ROLE_ADMIN"); // Ajouter le rôle ADMIN
                user.setGame(optionalGame.get()); // Associer le jeu
                userService.saveUser(user); // Sauvegarder les modifications
            } else {
                model.addAttribute("errorMessage", "L'utilisateur possède déjà le rôle ADMIN.");
                model.addAttribute("games", gameService.getAllGames());
                model.addAttribute("admins", userService.findAllUsersWithRole("ROLE_ADMIN"));
                return "admin-dashboard"; // Retourner la vue avec le message d'erreur
            }
        } else {
            model.addAttribute("errorMessage", "Utilisateur ou jeu introuvable.");
            model.addAttribute("games", gameService.getAllGames());
            model.addAttribute("admins", userService.findAllUsersWithRole("ROLE_ADMIN"));
            return "admin-dashboard"; // Retourner la vue avec le message d'erreur
        }

        return "redirect:/admin-dashboard"; // Redirection si tout est OK
    }


    @PostMapping("/admins/modify")
    public String editAdminRole(@RequestParam Long userId, @RequestParam Long gameId, Model model) {
        Optional<User> optionalUser = userService.getUserById(userId);
        Optional<Game> optionalGame = gameService.getGameById(gameId);
        if (optionalUser.isPresent() && optionalGame.isPresent()) {
            User user = optionalUser.get();
            user.setGame(optionalGame.get());
            userService.saveUser(user);
        } else {
            model.addAttribute("errorMessage", "Utilisateur ou jeu introuvable.");
        }
        return "redirect:/admin-dashboard";
    }
    
    @PostMapping("/admins/revoke")
    public String revokeAdminRole(@RequestParam Long userId, Model model) {
        Optional<User> optionalUser = userService.getUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.getRoles().remove("ROLE_ADMIN");
            user.setGame(null);
            userService.saveUser(user);
        } else {
            model.addAttribute("errorMessage", "Utilisateur introuvable.");
        }
        return "redirect:/admin-dashboard";
    }
    
}
