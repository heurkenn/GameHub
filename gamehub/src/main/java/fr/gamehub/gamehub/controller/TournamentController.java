package fr.gamehub.gamehub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import fr.gamehub.gamehub.repository.*;
import jakarta.validation.Valid;
import fr.gamehub.gamehub.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping("/tournament")
public class TournamentController {


    @Autowired
    private TournamentRepository tournamentrepository;

    @GetMapping("/creation")
    public String Tournament(Model model){
        model.addAttribute("tournament", new Tournament());
        model.addAttribute("categorie", Category.values());
        return "creationTournament";
    }
    @PostMapping(value = "/submitFormTournament")
    public String submitFormTournament(@Valid @ModelAttribute("tournament") Tournament tournament, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()){
            return "creation";
        }
        tournamentrepository.save(tournament);
        return "redirect:/";
    }

}
