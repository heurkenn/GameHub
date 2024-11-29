package fr.gamehub.gamehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.service.UserService;
import jakarta.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Affiche la page d'inscription avec un objet utilisateur vide.
     */
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "inscription";
    }

    /**
     * Gère la soumission du formulaire d'inscription.
     */
    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("user") User user, // Validation de l'objet User
            BindingResult result, // Pour capturer les erreurs de validation
            Model model
    ) {
        // Vérifier s'il y a des erreurs de validation
        if (result.hasErrors()) {
            return "inscription"; // Retourne au formulaire avec les erreurs affichées
        }

        // Vérifier si l'adresse e-mail est déjà utilisée
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "L'adresse e-mail est déjà utilisée");
            return "inscription";
        }

        // Vérifier si l'username est déjà utilisée
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "L'username est déjà utilisée");
            return "inscription";
        }

        // Chiffrer le mot de passe avec BCrypt
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Sauvegarder l'utilisateur
        userService.saveUser(user);

        // Rediriger vers une page de succès ou la page d'accueil
        return "redirect:/login"; 
    }
}
