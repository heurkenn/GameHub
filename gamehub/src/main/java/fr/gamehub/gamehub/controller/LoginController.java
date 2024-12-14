package fr.gamehub.gamehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.gamehub.gamehub.model.User;

@Controller
@SessionAttributes("loggedInUser")
public class LoginController {

    

    // Afficher la page de connexion
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user",new User());
        return "login";
    }

    // Vérifier les identifiants fournis par l'utilisateur
    


    // Gérer la déconnexion
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login?logout=true";
    }
}
