package fr.gamehub.gamehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.gamehub.gamehub.service.UserService;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    // Méthode pour la page d'accueil
    @GetMapping("/")
    public String index() {
        return "index"; // Retourne la vue 'index.html' située dans 'src/main/resources/templates'
    }

    // Méthode pour afficher la liste des utilisateurs
    @GetMapping("/users")
    public String listUsers(Model model) {
        // Ajouter la liste des utilisateurs au modèle
        model.addAttribute("users", userService.findAllUsers());
        return "users"; // Nom du fichier HTML pour afficher les utilisateurs
    }
}
