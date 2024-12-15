package fr.gamehub.gamehub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gamehub.gamehub.model.Category;
import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.service.GameService;
import fr.gamehub.gamehub.service.PlatformService;
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


    /**
     * Affiche la page d'administration avec la liste des utilisateurs ayant un rôle spécifique.
     * Affiche la page d'administration avec la liste des utilisateurs ayant un rôle spécifique.
     */
    @GetMapping
    public String adminDashboard(Model model) {
        model.addAttribute("games", gameService.getAllGames());
        model.addAttribute("categories", Category.values());
        model.addAttribute("platforms", platformService.findAllPlatforms()); // Ajoute les plateformes à la vue
        model.addAttribute("admins", userService.findAllUsersWithRole("ROLE_ADMIN")); // Liste des administrateurs
        return "admin-dashboard"; // Vue : admin-dashboard.html
    }

    /**
     * Attribuer le rôle ADMIN à un utilisateur existant.
     * Attribuer le rôle ADMIN à un utilisateur existant.
     */
    @PostMapping("/admins/assign")
    public String assignAdminRole(@RequestParam Long userId, Model model) {
        Optional<User> optionalUser = userService.getUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.getRoles().add("ROLE_ADMIN"); // Ajoute le rôle ADMIN
            userService.saveUser(user); // Sauvegarde les modifications
        } else {
            model.addAttribute("errorMessage", "Utilisateur introuvable.");
        }
        return "redirect:/admin-dashboard";
    }

    /**
     * Révoquer le rôle ADMIN d'un utilisateur existant.
     * Révoquer le rôle ADMIN d'un utilisateur existant.
     */
    @PostMapping("/admins/revoke")
    public String revokeAdminRole(@RequestParam Long userId, Model model) {
        Optional<User> optionalUser = userService.getUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.getRoles().remove("ROLE_ADMIN"); // Retire le rôle ADMIN
            userService.saveUser(user); // Sauvegarde les modifications
        } else {
            model.addAttribute("errorMessage", "Utilisateur introuvable.");
        }
    return "redirect:/admin-dashboard";
    }
}
