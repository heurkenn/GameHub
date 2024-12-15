package fr.gamehub.gamehub.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

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



    // Soumettre le formulaire pour modifier un jeu existant
    @PostMapping("/edit/{id}")
    public String updateGame(
            @PathVariable("id") Long id,
            @Valid Game updatedGame,
            BindingResult result, // Récupération des plateformes sous forme de chaîne
            @RequestParam("imageUrl") MultipartFile imageFile, // Gestion du fichier image
            Model model) {

        // Gestion des erreurs de validation
        if (result.hasErrors()) {
            System.out.println("Erreurs de validation : " + result.getAllErrors());
            model.addAttribute("errorMessage", "Erreur lors de la modification du jeu.");
            return "game_form"; // Retourner le formulaire en cas d'erreur
        }

        // Mettre à jour les champs de l'objet jeu
        updatedGame.setId(id);

        // Gestion de l'image (si une nouvelle image est uploadée)
        if (!imageFile.isEmpty()) {
            String fileName = imageFile.getOriginalFilename();
            updatedGame.setImage_url(fileName);
            System.out.println("Image uploadée : " + fileName);
            // Vous pouvez ajouter ici la logique pour enregistrer le fichier sur le serveur
        }

        // Sauvegarde du jeu modifié
        gameService.saveGame(updatedGame);
        System.out.println("Jeu mis à jour : " + updatedGame.getName());

        return "redirect:/admin-dashboard";
    }


    // Supprimer un jeu
    @PostMapping("/delete/{id}")
    public String deleteGame(@PathVariable("id") Long id) {
        gameService.deleteGame(id);
        return "redirect:/admin-dashboard";
    }

    


}
