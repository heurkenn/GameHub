package fr.gamehub.gamehub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.service.UserService;

@Controller
@SessionAttributes("loggedInUser")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Afficher la page de connexion
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user",new User());
        return "login";
    }

    // Vérifier les identifiants fournis par l'utilisateur
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        System.out.println("Tentative de connexion pour l'email : " + email);
        Optional<User> user = userService.findByEmail(email);

        if (user.isPresent()) {
            System.out.println("Utilisateur trouvé : " + user.get());
            if (passwordEncoder.matches(password, user.get().getPassword())) {
                System.out.println("Mot de passe correct.");
                model.addAttribute("user", user.get());
                return "redirect:/";
            } else {
                System.out.println("Mot de passe incorrect.");
            }
        } else {
            System.out.println("Utilisateur non trouvé.");
            return "redirect:/login";
        }

        model.addAttribute("error", "Email ou mot de passe incorrect.");
        return "login";
    }


    // Gérer la déconnexion
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login?logout=true";
    }
}
