package fr.gamehub.gamehub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gamehub.gamehub.model.Game;
import fr.gamehub.gamehub.service.GameService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    // Affiche tous les jeux
    @GetMapping
    public String getAllGames(Model model) {
        model.addAttribute("allGames", gameService.getAllGames());
        return "games"; // Vue : games.html
    }

    // Afficher les détails d'un jeu par son nom
    @GetMapping("/{name}")
    public String getGameByName(@PathVariable("name") String name, Model model) {
        Optional<Game> game = gameService.findByName(name);
        if (game.isEmpty()) {
            return "error/404"; // Affiche une page 404 si le jeu est introuvable
        }
        model.addAttribute("game", game.get());
        return "game"; // Vue : game.html
    }

    // Afficher le formulaire de création d'un jeu
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("game", new Game());
        return "game_form"; // Vue : game_form.html
    }

    // Soumettre le formulaire de création d'un jeu
    @PostMapping("/create")
    public String createGame(@Valid Game game, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Erreur lors de l'ajout du jeu.");
            return "game_form"; // Renvoyer à la même vue avec les erreurs
        }
        gameService.saveGame(game);
        return "redirect:/games"; // Redirige vers la liste des jeux
    }

    // Afficher le formulaire d'édition pour un jeu existant
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Game> game = gameService.getGameById(id);
        if (game.isEmpty()) {
            return "error/404"; // Affiche une page 404 si le jeu est introuvable
        }
        model.addAttribute("game", game.get());
        return "game_form"; // Réutiliser la même vue que pour la création
    }

    // Soumettre le formulaire pour modifier un jeu existant
    @PostMapping("/edit/{id}")
    public String updateGame(@PathVariable("id") Long id, @Valid Game updatedGame, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Erreur lors de la modification du jeu.");
            return "game_form";
        }
        updatedGame.setId(id); // Met à jour l'ID pour modifier l'existant
        gameService.saveGame(updatedGame);
        return "redirect:/games";
    }

    // Supprimer un jeu
    @PostMapping("/delete")
    public String deleteGame(@RequestParam Long gameId) {
        gameService.deleteGame(gameId);
        return "redirect:/games";
    }
}
