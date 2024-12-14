package fr.gamehub.gamehub.controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String viewProfile(Model model) {
        // Récupérer l'utilisateur connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            // Ajouter les informations de l'utilisateur au modèle
            model.addAttribute("username", userDetails.getUsername());
            // Ajoutez d'autres informations si nécessaire, comme l'email
            // Exemple : model.addAttribute("email", "user@example.com");
        }

        return "profile"; // Renvoie à profile.html
    }
}
