package fr.gamehub.gamehub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gamehub.gamehub.model.Game;
import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.service.GameService;
import fr.gamehub.gamehub.service.UserService;

@Controller
public class UserGameController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @GetMapping("/user-games")
    public String getUserGames(@RequestParam Long userId, Model model) {
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
            model.addAttribute("games", gameService.getAllGames());
        } else {
            model.addAttribute("errorMessage", "Utilisateur introuvable.");
        }
        return "user_games"; // Assure-toi d'avoir un template "user_games.html" dans "templates"
    }

    @PostMapping("/user-games/add")
    public String addGameToUser(@RequestParam Long userId, @RequestParam Long gameId) {
        Optional<User> userOptional = userService.findById(userId);
        Optional<Game> gameOptional = gameService.getGameById(gameId);

        if (userOptional.isPresent() && gameOptional.isPresent()) {
            User user = userOptional.get();
            Game game = gameOptional.get();
            user.getGames().add(game); // Ajoute le jeu à l'utilisateur
            userService.saveUser(user);
        }

        return "redirect:/user-games?userId=" + userId;
    }
}
