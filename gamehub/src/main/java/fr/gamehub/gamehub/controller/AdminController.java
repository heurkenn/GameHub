package fr.gamehub.gamehub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gamehub.gamehub.model.Admin;
import fr.gamehub.gamehub.service.AdminService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin-dashboard")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * Affiche la page d'administration avec la liste des administrateurs.
     */
    @GetMapping
    public String adminDashboard(Model model) {
        model.addAttribute("admins", adminService.getAllAdmins());
        model.addAttribute("newAdmin", new Admin()); // Prépare un objet Admin vide pour le formulaire
        return "admin-dashboard"; // Vue : admin-dashboard.html
    }

    /**
     * Ajouter un nouvel administrateur.
     */
    @PostMapping("/admins/create")
    public String addAdmin(
            @Valid @ModelAttribute("newAdmin") Admin admin,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("admins", adminService.getAllAdmins());
            model.addAttribute("errorMessage", "Erreur lors de l'ajout de l'administrateur. Vérifiez les champs.");
            return "admin-dashboard"; // Retourne à la même vue avec les erreurs affichées
        }
        adminService.saveAdmin(admin);
        return "redirect:/admin-dashboard";
    }

    /**
     * Supprimer un administrateur.
     */
    @PostMapping("/admins/delete")
    public String deleteAdmin(@RequestParam Long adminId) {
        adminService.deleteAdminById(adminId);
        return "redirect:/admin-dashboard";
    }

    /**
     * Modifier un administrateur existant.
     */
    @PostMapping("/admins/edit")
    public String editAdmin(
            @RequestParam Long adminId,
            @Valid @ModelAttribute("updatedAdmin") Admin updatedAdmin,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("admins", adminService.getAllAdmins());
            model.addAttribute("errorMessage", "Erreur lors de la modification de l'administrateur.");
            return "admin-dashboard";
        }

        Optional<Admin> optionalAdmin = adminService.getAdminById(adminId);
        if (optionalAdmin.isPresent()) {
            Admin existingAdmin = optionalAdmin.get();
            existingAdmin.setName(updatedAdmin.getName());
            existingAdmin.setEmail(updatedAdmin.getEmail());
            existingAdmin.setGame(updatedAdmin.getGame());
            adminService.saveAdmin(existingAdmin);
        }
        return "redirect:/admin-dashboard";

    }
}
