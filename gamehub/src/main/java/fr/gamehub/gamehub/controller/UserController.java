package fr.gamehub.gamehub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.repository.UserRepository;
import fr.gamehub.gamehub.service.UserService;
import jakarta.validation.Valid;;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 

	@Autowired
	private UserService userService; 

	@GetMapping("/inscription")
	public String showForm (Model model){
		model.addAttribute("user",new User());
		return "inscription";
	}

	@RequestMapping(value = "/submitFormUser", method = RequestMethod.POST)
	public String submitForm(Model model,@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
		
		if (bindingResult.hasErrors()){
			// peut etre mettre un truc dans le model
			return "inscription";
		}
		userRepository.save(user);
		return "redirect:/";  // Redirige vers la page d'acceuil
	}

	 /**
     * Met à jour un utilisateur en fonction des données envoyées dans le formulaire.
     */
    @PostMapping("/user/edit/{id}")
    public String updateUser(@PathVariable Long id, 
                             @Valid @ModelAttribute("user") User userForm, 
                             BindingResult result, 
                             Model model) {
        // Vérifiez si l'utilisateur existe
        Optional<User> optionalUser = userService.getUserById(id);
		if (optionalUser.isEmpty()) {
			model.addAttribute("errorMessage", "Utilisateur introuvable.");
			return "error"; // Page d'erreur
		}

		// Si l'utilisateur existe, récupérez-le
		User existingUser = optionalUser.get();

        if (result.hasErrors()) {
            // En cas d'erreur dans le formulaire, retourner à la liste avec les erreurs
            model.addAttribute("errorMessage", "Erreur dans les champs du formulaire.");
            model.addAttribute("users", userService.findAllUsers());
            return "userList";
        }

        // Mettre à jour les informations de l'utilisateur
        existingUser.setName(userForm.getName());
        existingUser.setSurname(userForm.getSurname());
        existingUser.setUsername(userForm.getUsername());
        existingUser.setEmail(userForm.getEmail());

        // Sauvegarde
        userService.saveUser(existingUser);

        // Redirige vers la liste des utilisateurs
        return "redirect:/admin-dashboard";
    }
}
