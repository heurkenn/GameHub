package fr.gamehub.gamehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", "Bienvenue sur GameHub !");
        return "welcome"; // Retourne la vue 'welcome.html'
    }
}
