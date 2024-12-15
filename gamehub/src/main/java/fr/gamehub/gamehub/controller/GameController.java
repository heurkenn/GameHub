package fr.gamehub.gamehub.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import fr.gamehub.gamehub.model.Category;
import fr.gamehub.gamehub.model.Game;
import fr.gamehub.gamehub.model.Platform;
import fr.gamehub.gamehub.service.GameService;
import fr.gamehub.gamehub.service.PlatformService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;

@MultipartConfig
@Controller
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private PlatformService platformService;


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
                            @RequestParam("image_url") MultipartFile imageUrl,
                            @RequestParam("platforms") List<String> platforms, // Plateformes sélectionnées
                            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Erreur lors de l'ajout du jeu.");
            return "admin-dashboard";
        }

        // Vérifier si le genre est valide
        try {
            Category.valueOf(game.getGenre()); // Vérifie si le genre est dans l'enum
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", "Le genre sélectionné est invalide.");
            return "admin-dashboard";
        }

        // Vérifier que le fichier image n'est pas vide
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

        // Récupérer les entités Platform correspondant aux noms sélectionnés
        Set<Platform> selectedPlatforms = new HashSet<>(platformService.findPlatformsByName(platforms));
        game.setPlatforms(selectedPlatforms); // Associer les plateformes au jeu

        // Enregistrer le jeu dans la base
        gameService.saveGame(game);

        

        return "redirect:/admin-dashboard";
    }




    // Soumettre le formulaire pour modifier un jeu existant
    @PostMapping("/edit/{id}")
    public String updateGame(
            @PathVariable("id") Long id,
            @Valid Game updatedGame,
            BindingResult result,
            @RequestParam("newImage") MultipartFile imageFile,
            @RequestParam(value = "platforms", required = false) List<Long> platformIds,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Erreur lors de la modification du jeu.");
            return "admin-dashboard"; // Page à afficher en cas d'erreurs
        }

        // Récupération du jeu existant
        Optional<Game> optionalGame = gameService.getGameById(id);
        if (optionalGame.isEmpty()) {
            model.addAttribute("errorMessage", "Le jeu avec l'ID " + id + " n'existe pas.");
            return "redirect:/admin-dashboard"; // Ou une autre vue appropriée
        }

        Game existingGame = optionalGame.get();


        // Mise à jour des champs de l'objet
        existingGame.setName(updatedGame.getName());
        existingGame.setReleaseYear(updatedGame.getReleaseYear());
        existingGame.setDeveloperStudio(updatedGame.getDeveloperStudio());
        existingGame.setGenre(updatedGame.getGenre());
        existingGame.setDescription(updatedGame.getDescription());

        // Gestion des plateformes
        if (platformIds != null) {
            Set<Platform> platforms = platformService.findAllByIds(platformIds);
            existingGame.setPlatforms(platforms);
        } else {
            existingGame.setPlatforms(new HashSet<>()); // Réinitialiser si aucune sélection
        }

        // Gestion de l'image
        if (!imageFile.isEmpty()) {
            try {
                String fileName = imageFile.getOriginalFilename();
                Path uploadPath = Paths.get("src/main/resources/static/image");
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                existingGame.setImage_url(fileName);
            } catch (IOException e) {
                model.addAttribute("errorMessage", "Erreur lors de l'enregistrement de l'image.");
                return "admin-dashboard";
            }
        }

        // Sauvegarde du jeu
        gameService.saveGame(existingGame);
        return "redirect:/admin-dashboard";
    }



    // Supprimer un jeu
    @PostMapping("/delete/{id}")
    public String deleteGame(@PathVariable("id") Long id) {
        gameService.deleteGame(id);
        return "redirect:/admin-dashboard";
    }

    


}
