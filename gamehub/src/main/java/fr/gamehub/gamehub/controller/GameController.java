package fr.gamehub.gamehub.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.gamehub.gamehub.model.Game;
import fr.gamehub.gamehub.service.GameService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;

@MultipartConfig
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

    @PostMapping("/create")
    public String createGame(@Valid Game game, BindingResult result,
                            @RequestParam("imageUrl") MultipartFile imageUrl,
                            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Erreur lors de l'ajout du jeu.");
            return "admin-dashboard";
        }

        // Vérifier que le fichier n'est pas vide
        if (imageUrl.isEmpty()) {
            model.addAttribute("errorMessage", "L'image est requise.");
            return "admin-dashboard";
        }

        // Vérifier que le type MIME n'est pas nul et qu'il s'agit bien de JPEG
        String contentType = imageUrl.getContentType();
        if (contentType == null || !contentType.equals("image/jpeg")) {
            model.addAttribute("errorMessage", "Le fichier doit être un JPG.");
            return "admin-dashboard";
        }

        // Vérifier les dimensions de l'image
        BufferedImage img;
        try {
            img = ImageIO.read(imageUrl.getInputStream());
        } catch (IOException e) {
            model.addAttribute("errorMessage", "Impossible de lire l'image.");
            return "admin-dashboard";
        }

        if (img == null || img.getWidth() != 2000 || img.getHeight() != 1000) {
            model.addAttribute("errorMessage", "L'image doit avoir une résolution de 2000x1000.");
            return "admin-dashboard";
        }

        // Générer un nom de fichier à partir du nom du jeu
        String safeName = game.getName().toLowerCase().replaceAll("\\s+", "_");
        String fileName = safeName + ".jpg";

        // Définir le répertoire de stockage (par exemple "images" à la racine du projet)
        Path imagesDir = Paths.get("src/main/resources/static/image");
        if (!Files.exists(imagesDir)) {
            try {
                Files.createDirectories(imagesDir);
            } catch (IOException e) {
                model.addAttribute("errorMessage", "Impossible de créer le répertoire d'images.");
                return "admin-dashboard";
            }
        }

        // Le chemin complet du fichier
        Path filePath = imagesDir.resolve(fileName);
        try {
            // Sauvegarder l'image sur disque
            Files.copy(imageUrl.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            model.addAttribute("errorMessage", "Erreur lors de l'enregistrement de l'image.");
            return "admin-dashboard";
        }

        // Mettre à jour l'attribut image_url du jeu avec le nom de fichier
        game.setImage_url(fileName);

        // Enregistrer le jeu dans la base
        gameService.saveGame(game);

        return "redirect:/admin-dashboard";
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

    @GetMapping("/admin-dashboard")
public String getAdminDashboard(Model model) {
    List<Game> games = gameService.getAllGames();
    games.forEach(game -> System.out.println("Game ID: " + game.getId() + ", Name: " + game.getName())); // Log pour vérifier
    model.addAttribute("games", games);
    return "admin-dashboard";
}


}
