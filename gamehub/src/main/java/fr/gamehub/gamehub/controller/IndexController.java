package fr.gamehub.gamehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // Retourne la vue 'index.html' qui se trouve dans le dossier 'templates'
    }
}
