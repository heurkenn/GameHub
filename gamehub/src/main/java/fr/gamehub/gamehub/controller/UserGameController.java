package fr.gamehub.gamehub.controller;

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
        User user = userService.getUserById(userId);
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("games", gameService.getAllGames());
        }
        return "user_games";  // Assure-toi d'avoir un template "user_games.html" dans "templates"
    }

    @PostMapping("/user-games/add")
    public String addGameToUser(@RequestParam Long userId, @RequestParam Long gameId) {
        User user = userService.getUserById(userId);
        Game game = gameService.getGameById(gameId);
        if (user != null && game != null) {
            user.getGames().add(game);  // Cette méthode devrait être disponible si l'entité User est correctement configurée
            userService.saveUser(user);
        }
        return "redirect:/user-games?userId=" + userId;
    }
}
