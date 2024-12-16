package fr.gamehub.gamehub.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.service.UserService;
import jakarta.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Affiche la page d'inscription avec un objet utilisateur vide.
     */
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "inscription";
    }

    /**
     * Gère la soumission du formulaire d'inscription.
     */
    @PostMapping("/register")
        public ResponseEntity<?> register(
                @Valid @ModelAttribute("user") User user,
                BindingResult result
        ) {
            Map<String, String> errors = new HashMap<>();

            if (result.hasErrors()) {
                result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(errors);
            }

            if (userService.findByEmail(user.getEmail()).isPresent()) {
                errors.put("email", "Adresse email déjà utilisée.");
            }

            if (userService.findByUsername(user.getUsername()).isPresent()) {
                errors.put("username", "Nom d'utilisateur déjà utilisé.");
            }

            if (!isPasswordStrong(user.getPassword())) {
                errors.put("password", "Le mot de passe doit contenir au moins 8 caractères, une majuscule, une minuscule et un chiffre.");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.badRequest().body(errors);
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.addRole("ROLE_USER");
            userService.saveUser(user);

            return ResponseEntity.ok().build();
        }

        private boolean isPasswordStrong(String password) {
            return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*");
        }

}
