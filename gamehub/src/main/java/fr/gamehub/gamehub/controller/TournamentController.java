package fr.gamehub.gamehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TournamentController {


    // Méthode pour la page d'accueil
    @GetMapping("/tournament")
    public String tournament(Model model) {
        return "tournaments"; // Retourne la vue 'index.html' située dans 'src/main/resources/templates'
    }
}