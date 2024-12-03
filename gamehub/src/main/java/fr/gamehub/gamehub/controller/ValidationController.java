package fr.gamehub.gamehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gamehub.gamehub.service.UserService;

@RestController
public class ValidationController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/validate/username")
    public boolean validateUsername(@RequestParam String username) {
        return userService.findByUsername(username).isPresent();
    }

    @GetMapping("/api/validate/email")
    public boolean validateEmail(@RequestParam String email) {
        return userService.findByEmail(email).isPresent();
    }
}
