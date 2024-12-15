package fr.gamehub.gamehub.controller;

import java.util.LinkedList;
import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
		l.add(service.searchTournamentNameStartBy(""));
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
	
	// Full fait à l'aveugle à tout moment rien ne fonctionne
	/**
	@PostMapping(value = "/submitJoinTournament")
	public String submitJoinTournament(Model mode ){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
			
		}

		return "JoinTournament";
	}
	*/


	// Fonction qui servira à prendre seulement les tournois qui valide toute les conditions posé dans les filtres
	private static List<Tournament> intersectionTournaments(List<List <Tournament>> lTournament ){
		List <Tournament> tournaments = lTournament.get(0);
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("idhzauhduizagfduiazhoiduzahofiazhoifhaziohfioazhfoiazhifhzaoihfaziohfioazh");
		System.out.println(ldt.getHour());
		System.out.println(ldt.toString());
		List <Tournament> lTournamentsTmp = new LinkedList<>();
		for (List<Tournament> lt : lTournament){
			for (Tournament tournament : tournaments){
				if (!tournament.getDateStartInscription().isBefore(ldt) || !tournament.getDateEndInscription().isAfter(ldt) || !lt.contains(tournament)) {
					System.out.println(tournament.getName()+ " :");
					System.out.println(tournament.getDateStartInscription().isBefore(ldt));
					System.out.println(tournament.getDateEndInscription().isAfter(ldt));
					lTournamentsTmp.add(tournament);
				}
			}
			for (Tournament t : lTournamentsTmp) tournaments.remove(t);
			lTournamentsTmp.clear();
		}
		System.out.println(tournaments);
		return tournaments;
	}
	

}
