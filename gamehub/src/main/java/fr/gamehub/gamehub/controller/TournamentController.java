package fr.gamehub.gamehub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import fr.gamehub.gamehub.repository.*;
@Controller
public class TournamentController {


    @Autowired
    TournamentRepository tournamentrepository;

    @GetMapping("/tournament")
    public void JoinTournament(@ModelAttribute("user") User user, Model model){
        if 
    }

}
