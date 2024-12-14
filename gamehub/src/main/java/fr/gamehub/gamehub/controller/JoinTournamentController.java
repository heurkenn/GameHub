package fr.gamehub.gamehub.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import fr.gamehub.gamehub.repository.*;
import fr.gamehub.gamehub.service.TournamentService;
import jakarta.validation.Valid;
import fr.gamehub.gamehub.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/tournament")
public class JoinTournamentController {

	@Autowired
	private TournamentService service;
	
	public JoinTournamentController( TournamentService service){
		this.service=service;
	}

	@GetMapping("/join")
	public String Join(Model model){
		return "JoinTournament";
	}

	@PostMapping(value = "/submitFilter")
	public String submitFilter(@RequestParam(value = "prefixName", required = false, defaultValue = "") String prefixName,@RequestParam(value = "is_private", required = false, defaultValue = "false") Boolean isPrivate,Model model) {
    	List<List<Tournament>> llTournament = new LinkedList<>();

    	List<Tournament> tournamentsName = service.searchTournamentNameStartBy(prefixName);
    	llTournament.add(tournamentsName);

    	List<Tournament> tournamentsPrivate = service.searchTournamentByPrivacy(isPrivate);
    	llTournament.add(tournamentsPrivate);
		System.out.println(llTournament.size());
  		List<Tournament> tournamentFiltered = intersectionTournaments(llTournament);
    	model.addAttribute("tournament", tournamentFiltered);

    	return "JoinTournament"; // Retourner la même page pour afficher le filtre appliqué
}


	// Fonction qui servira à prendre seulement les tournois qui valide toute les conditions posé dans les filtres
	private static List<Tournament> intersectionTournaments(List<List <Tournament>> lTournament ){
		List <Tournament> tournaments = lTournament.get(0);
		for (List<Tournament> lt : lTournament){
			for (Tournament tournament : tournaments){
				if (!lt.contains(tournament)) tournaments.remove(tournament);
			}
		}
		return tournaments;
	}

}
