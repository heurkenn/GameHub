package fr.gamehub.gamehub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.service.UserService;

@Controller
public class ProfileController {

    @Value("${admin.superAdminPassword}")
    private String superAdminPassword; // Mot de passe défini dans application.properties

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public ProfileController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/profile/update-password")
    public String updatePassword(@RequestParam("currentPassword") String currentPassword,
                                @RequestParam("newPassword") String newPassword,
                                @RequestParam("confirmPassword") String confirmPassword,
                                Model model) {
        // Récupérer l'utilisateur connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        
        Optional<User> optionalUser = userService.findByUsername(currentUsername);
        if (optionalUser.isEmpty()) {
            model.addAttribute("errorMessage", "Utilisateur introuvable.");
            return "profile";
        }

        User currentUser = optionalUser.get();

        // Vérification du mot de passe actuel
        if (!passwordEncoder.matches(currentPassword, currentUser.getPassword())) {
            model.addAttribute("errorMessage", "Le mot de passe actuel est incorrect.");
            return "profile";
        }

        // Vérification que le nouveau mot de passe et la confirmation correspondent
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("errorMessage", "Les deux mots de passe ne correspondent pas.");
            return "profile";
        }

        // Mettre à jour le mot de passe
        currentUser.setPassword(passwordEncoder.encode(newPassword));
        userService.saveUser(currentUser);

        model.addAttribute("successMessage", "Mot de passe modifié avec succès !");
        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("roles", currentUser.getRoles());

        return "profile";
    }

    @PostMapping("/profile/update-username")
    public String updateUsername(@RequestParam("newUsername") String newUsername, Model model) {
        // Récupérer l'utilisateur connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        Optional<User> optionalUser = userService.findByUsername(currentUsername);
        if (optionalUser.isEmpty()) {
            model.addAttribute("errorMessage", "Utilisateur introuvable.");
            return "profile";
        }

        User currentUser = optionalUser.get();

        // Vérifier si le nouveau nom d'utilisateur n'est pas déjà pris (optionnel, selon votre logique métier)
        Optional<User> userWithSameUsername = userService.findByUsername(newUsername);
        if (userWithSameUsername.isPresent()) {
            model.addAttribute("errorMessage", "Ce nom d'utilisateur est déjà utilisé.");
            model.addAttribute("username", currentUser.getUsername());
            model.addAttribute("roles", currentUser.getRoles());
            return "profile";
        }

        // Mettre à jour le nom d'utilisateur
        currentUser.setUsername(newUsername);
        userService.saveUser(currentUser);

        model.addAttribute("successMessage", "Nom d'utilisateur mis à jour avec succès !");
        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("roles", currentUser.getRoles());

        return "profile";
    }


    @GetMapping("/profile")
    public String viewProfile(Model model) {
        // Récupérer l'utilisateur connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        // Utiliser Optional pour gérer les utilisateurs
        Optional<User> optionalUser = userService.findByUsername(currentUsername);
        if (optionalUser.isPresent()) {
            User currentUser = optionalUser.get();
            model.addAttribute("username", currentUser.getUsername());
            model.addAttribute("roles", currentUser.getRoles());
        } else {
            model.addAttribute("errorMessage", "Utilisateur introuvable.");
        }

        return "profile"; // Renvoie à profile.html
    }

    @PostMapping("/profile")
    public String becomeSuperAdmin(@RequestParam("superAdminPassword") String password, Model model) {
        // Récupérer l'utilisateur connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        Optional<User> optionalUser = userService.findByUsername(currentUsername);
        if (optionalUser.isEmpty()) {
            model.addAttribute("errorMessage", "Utilisateur introuvable.");
            return "profile";
        }

        User currentUser = optionalUser.get();

        // Vérifier si le mot de passe correspond
        if (password.equals(superAdminPassword)) {
            // Ajouter le rôle SUPER_ADMIN
            currentUser.getRoles().add("ROLE_SUPER_ADMIN");
            userService.saveUser(currentUser); // Sauvegarder les changements

            model.addAttribute("successMessage", "Félicitations, vous êtes maintenant Super Admin !");
        } else {
            model.addAttribute("errorMessage", "Mot de passe incorrect.");
        }

        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("roles", currentUser.getRoles());
        return "profile";
    }
}
