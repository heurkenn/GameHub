package fr.gamehub.gamehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.repository.UserRepository;
import jakarta.validation.Valid;;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 

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
}
