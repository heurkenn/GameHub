package fr.gamehub.gamehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.service.UserService;

@Controller
public class SignInController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Afficher la page d'inscription
    @GetMapping("/sign-in")
    public String signInPage(Model model) {
        model.addAttribute("user", new User());
        return "sign_in";
    }

    // Traiter l'inscription d'un nouvel utilisateur
    @PostMapping("/sign-in")
    public String signIn(@ModelAttribute("user") User user, Model model) {
        // Vérifier si l'email est déjà utilisé
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "L'adresse e-mail est déjà utilisée");
            return "sign_in";
        }

        // Chiffrer le mot de passe avec BCrypt avant de le sauvegarder
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/login"; // Rediriger vers la page de connexion après inscription
    }
}
