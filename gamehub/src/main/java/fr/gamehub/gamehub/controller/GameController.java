package fr.gamehub.gamehub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.gamehub.gamehub.model.Game;
import fr.gamehub.gamehub.service.GameService;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    // Afficher les détails d'un jeu par son nom
    @GetMapping("/game/{name}")
    public String getGameByName(@PathVariable("name") String name, Model model) {
        Optional<Game> game = gameService.findByName(name);
        if (game.isEmpty()) { // Vérifie si le jeu n'est pas présent
            return "error/404"; // Page 404 ou message d'erreur personnalisé
        }
        model.addAttribute("game", game.get()); // Passe le jeu trouvé au modèle
        return "game";
    }

    @GetMapping("/games")
    public String getAllames(Model model) {
        // Ajouter trois jeux aléatoires au modèle
        model.addAttribute("allGames", gameService.getAllGames());
        return "games"; 
    }

}
