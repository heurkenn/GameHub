package fr.gamehub.gamehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.gamehub.gamehub.service.GameService;

@Controller
public class PageController {


    @Autowired
    private GameService gameService;

    // Méthode pour la page d'accueil
    @GetMapping("/")
    public String index(Model model) {
        // Ajouter trois jeux aléatoires au modèle
        model.addAttribute("randomGames", gameService.findRandomGames(4));
        return "index"; // Retourne la vue 'index.html' située dans 'src/main/resources/templates'
    }

    
    
    
}
