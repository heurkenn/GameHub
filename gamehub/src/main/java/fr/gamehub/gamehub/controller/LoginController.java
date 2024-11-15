package fr.gamehub.gamehub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Afficher la page de connexion
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Vérifier les identifiants fournis par l'utilisateur
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<User> user = userService.findByEmail(email);

        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            // Si les identifiants sont corrects, rediriger vers la page d'accueil
            model.addAttribute("user", user.get());
            return "redirect:/dashboard";
        } else {
            // Si les identifiants sont incorrects, afficher un message d'erreur
            model.addAttribute("error", "Email ou mot de passe incorrect");
            return "login";
        }
    }
}
