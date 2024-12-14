package fr.gamehub.gamehub.controller;

import java.util.LinkedList;
import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import fr.gamehub.gamehub.service.TournamentService;
import fr.gamehub.gamehub.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


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
		List<List< Tournament>> l = new LinkedList<>();
		l.add(service.getAllTournaments());
		System.out.println("uhfehfuiheufeziufguiezgfez");
		System.out.println(service.getAllTournaments());
		System.out.println("uhfehfuiheufeziufguiezgfez");
		model.addAttribute("tournamentFilter", intersectionTournaments(l));
		return "JoinTournament";
	}

	@PostMapping(value = "/submitFilter")
	public String submitFilter(@RequestParam(value = "prefixName", required = false, defaultValue = "") String prefixName,@RequestParam(value = "is_private", required = false, defaultValue = "false") Boolean isPrivate,Model model) {
    	List<List<Tournament>> llTournament = new LinkedList<>();

    	List<Tournament> tournamentsName = service.searchTournamentNameStartBy(prefixName);
    	llTournament.add(tournamentsName);

    	List<Tournament> tournamentsPrivate = service.searchTournamentByPrivacy(isPrivate);
    	llTournament.add(tournamentsPrivate);
		
  		List<Tournament> tournamentFiltered = intersectionTournaments(llTournament);
		model.addAttribute("tournamentFilter", tournamentFiltered);
		
    	return "JoinTournament"; // Retourner la même page pour afficher le filtre appliqué
}


	// Fonction qui servira à prendre seulement les tournois qui valide toute les conditions posé dans les filtres
	private static List<Tournament> intersectionTournaments(List<List <Tournament>> lTournament ){
		List <Tournament> tournaments = lTournament.get(0);
		LocalDateTime ldt = LocalDateTime.now();
		
		List <Tournament> lTournamentsTmp = new LinkedList<>();
		for (List<Tournament> lt : lTournament){
			for (Tournament tournament : tournaments){
				if (!tournament.getDateStartInscription().isBefore(ldt) || !tournament.getDateEndInscription().isAfter(ldt) || !lt.contains(tournament)) {
					
					lTournamentsTmp.add(tournament);
				}
			}
			for (Tournament t : lTournamentsTmp) tournaments.remove(t);
			lTournamentsTmp.clear();
		}
		
		return tournaments;
	}
	

}
