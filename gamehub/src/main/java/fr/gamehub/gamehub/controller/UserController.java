package fr.gamehub.gamehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.gamehub.gamehub.model.*;;

@Controller
public class UserController {
	
	@GetMapping("/form")
	public String showForm (Model model){
		model.addAttribute("user",new User());
		return "userForm";
	}

	@PostMapping("/submitFormUser")
	public String submitForm(@ModelAttribute User user, Model model){
		
		model.addAttribute("user", user);
		return "userInfo";
	}
}
