package fr.gamehub.gamehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")  // Change le mapping pour éviter le conflit avec "/"
    public String welcome(Model model) {
        model.addAttribute("message", "Bienvenue sur GameHub !");
        return "welcome";  // Assure-toi d'avoir un fichier "welcome.html" dans le dossier "templates"
    }
}
