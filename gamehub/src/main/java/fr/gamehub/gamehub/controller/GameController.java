package fr.gamehub.gamehub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "game"; // Vue : game.html
    }

    // Afficher tous les jeux
    @GetMapping("/games")
    public String getAllGames(Model model) {
        model.addAttribute("allGames", gameService.getAllGames());
        return "games"; // Vue : games.html
    }

    // Afficher le formulaire de création d'un jeu
    @GetMapping("/games/create")
    public String showCreateForm(Model model) {
        model.addAttribute("game", new Game()); // Passe un nouvel objet Game au modèle
        return "game_form"; // Vue : game_form.html
    }

    // Soumettre un formulaire pour créer un jeu
    @PostMapping("/games/create")
    public String createGame(Game game) {
        gameService.saveGame(game);
        return "redirect:/games"; // Redirige vers la liste des jeux
    }

    // Afficher le formulaire d'édition pour un jeu existant
    @GetMapping("/games/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Game> game = gameService.getGameById(id);
        if (game.isEmpty()) { // Si le jeu n'existe pas
            return "error/404";
        }
        model.addAttribute("game", game.get());
        return "game_form"; // Réutilise la même vue que pour la création
    }

    // Soumettre un formulaire pour modifier un jeu existant
    @PostMapping("/games/edit/{id}")
    public String updateGame(@PathVariable("id") Long id, Game updatedGame) {
        Optional<Game> existingGame = gameService.getGameById(id);
        if (existingGame.isEmpty()) {
            return "error/404";
        }
        updatedGame.setId(id); // Met à jour l'ID pour modifier le jeu existant
        gameService.saveGame(updatedGame);
        return "redirect:/games";
    }

    // Supprimer un jeu
    @GetMapping("/games/delete/{id}")
    public String deleteGame(@PathVariable("id") Long id) {
        gameService.deleteGame(id);
        return "redirect:/games";
    }
}
