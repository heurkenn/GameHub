package fr.gamehub.gamehub.controller;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gamehub.gamehub.model.Category;
import fr.gamehub.gamehub.model.Classement;
import fr.gamehub.gamehub.model.Fight;
import fr.gamehub.gamehub.model.Game;
import fr.gamehub.gamehub.model.Tournament;
import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.repository.ClassementRepository;
import fr.gamehub.gamehub.repository.GameRepository;
import fr.gamehub.gamehub.repository.TournamentRepository;
import fr.gamehub.gamehub.repository.UserRepository;
import fr.gamehub.gamehub.service.GameService;
import fr.gamehub.gamehub.service.TournamentService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller


public class TournamentController {
    

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private ClassementRepository classementRepository;

    @Autowired
    private GameService gameService;

    
    

    @Transactional
    @PostMapping("/tournaments/join/{id}")
    public String joinTournament(@PathVariable Long id) {
        // Récupérer l'utilisateur connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        User currentUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        // Récupérer le tournoi
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tournoi introuvable avec ID: " + id));

        // Vérifier si le tournoi n'est pas déjà complet
        if (tournament.getNbJoueur() >= tournament.getNbJoueurLimite()) {
            // Rediriger avec un message d'erreur, par exemple
            return "redirect:/tournaments/" + id + "?error=full";
        }

        // Vérifier si l'utilisateur n'est pas déjà participant
        if (tournament.getParticipants().contains(currentUser)) {
            // Rediriger avec un message indiquant que l'utilisateur est déjà inscrit
            return "redirect:/tournaments/" + id + "?info=already_joined";
        }

        // Ajouter l'utilisateur au tournoi
        tournament.getParticipants().add(currentUser);
        tournament.setNbJoueur(tournament.getNbJoueur() + 1);

        // Sauvegarder le tournoi
        tournamentRepository.save(tournament);

        // Rediriger vers la page du tournoi avec un message de succès
        return "redirect:/tournaments/" + id + "?success=joined";
    }

    //fonction horloge dynamique pour le début de tournoi
    public String horlogeDynamique(long tournament_id){  
        // Récupère l'heure actuelle
    LocalDateTime crtTime = LocalDateTime.now();
    
    // Récupère le tournoi par son ID
    Tournament trnt = tournamentService.getTournamentById(tournament_id)
        .orElseThrow(() -> new RuntimeException("Tournoi introuvable avec ID: " + tournament_id));
    
    // Récupère la date de début du tournoi
    LocalDateTime dtStart = trnt.getDateStart();

    // Calculer la différence entre les deux dates
    Duration duration = Duration.between(crtTime, dtStart);
    
    // Extraire les composants de la durée
    long days = duration.toDays();
    long hours = duration.toHours() % 24; // Heure restante après avoir calculé les jours
    long minutes = duration.toMinutes() % 60; // Minute restante après avoir calculé les heures
    long seconds = duration.getSeconds() % 60; // Seconde restante après avoir calculé les minutes
    
    // Retourne la différence sous forme d'une chaîne lisible
    return String.format("%d jours, %d heures, %d minutes, %d secondes", days, hours, minutes, seconds);
    }



    @GetMapping("/tournaments")
    public String showTournaments(Model model) { // à l'affichage de la page, renvoi une liste de tournoi en paramètre
    List<Tournament> tournaments = tournamentRepository.findAll();
    List<Tournament> ongoingTournaments = new ArrayList<>();
    List<Tournament> upcommingTournaments = new ArrayList<>();
    List<Tournament> pastTournaments = new ArrayList<>();
    LocalDateTime crtTime = LocalDateTime.now();
    for (Tournament t : tournamentService.getAllTournaments()){
        if (t.getDateStart().isBefore(crtTime) && t.getDateEnd().isAfter(crtTime)){//regarde si la date actuelle est après la date du debut du tournoi et avant celle de la fin
            ongoingTournaments.add(t);
        }else if(t.getDateStart().isAfter(crtTime)){//regarde si la date actuelle est avant la date du debut du tournoi
            upcommingTournaments.add(t);
        }else{
            pastTournaments.add(t);
        }
    }
    model.addAttribute("pastTournaments", pastTournaments);//renvoie un parametre qui est la liste des tournois passé
    model.addAttribute("ongoingTournaments", ongoingTournaments); //renvoie un parametre qui est la liste des tournois en cours
    model.addAttribute("upcomingTournaments", upcommingTournaments);// renvoie la liste des tournois qui vont venir 
    model.addAttribute("tournaments", tournaments);//renvoie la lsite de tout les tournois
    return "tournaments";
    }


    @PostMapping("/tournaments/create")
    public String createTournament(@ModelAttribute("tournament") @Valid Tournament tournament,
                                   BindingResult bindingResult,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            // En cas d'erreur de validation, renvoyer le formulaire avec les listes
            model.addAttribute("categorie", Category.values());
            model.addAttribute("games", gameService.getAllGames());
            return "admin-dashboard";
        }

        // A ce stade, tous les champs obligatoires sont déjà définis dans l'objet 'tournament'
        // (y compris dateStart, dateEnd, dateStartInscription, dateEndInscription, categorie, jeu, etc.)
        
        // Sauvegarder le tournoi
        tournamentService.saveTournament(tournament);

        return "redirect:/admin-dashboard";
    }

    @GetMapping("/tournaments/users/{id}")
    public ResponseEntity<Tournament> getById(@PathVariable long id) {
        Optional<Tournament> tournament = tournamentService.getTournamentById(id);
        return tournament.map(ResponseEntity::ok)
            .orElseThrow();
    }

    
    @GetMapping("/tournaments/{id}")
    public String showTournamentDetails(@PathVariable Long id, Model model) {
        // Récupérer le tournoi par son ID
        Optional<Tournament> tournament = tournamentService.getTournamentById(id);
        if (tournament.isEmpty()) {
            return "error/404"; // Rediriger vers une page 404 si le tournoi n'existe pas
        }

        // Ajouter le tournoi au modèle
        model.addAttribute("tournament", tournament.get());

        // Appeler la méthode horlogeDynamique pour obtenir la durée avant le début du tournoi
        String countdown = horlogeDynamique(id);
        model.addAttribute("countdown", countdown);

        // Retourner la vue tournament.html
        return "tournament";
    }

    @GetMapping("/tournaments/{id}/countdown")
    public ResponseEntity<String> getCountdown(@PathVariable Long id) {
        // Appeler la méthode horlogeDynamique
        String countdown = horlogeDynamique(id);
        return ResponseEntity.ok(countdown);
    }

    
    @PostMapping("/tournaments/edit/{id}")
    public String editTournament(@PathVariable("id") Long id,
                                @RequestParam String name,
                                @RequestParam Long gameId,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateStart,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateEnd,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateStartInscription,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateEndInscription,
                                Model model) {
        Optional<Tournament> optionalTournament = tournamentService.getTournamentById(id);
        Optional<Game> optionalGame = gameService.getGameById(gameId);

        if (optionalTournament.isPresent() && optionalGame.isPresent()) {
            Tournament tournament = optionalTournament.get();

            tournament.setName(name);
            tournament.setJeu(optionalGame.get());
            tournament.setDateStart(dateStart);
            tournament.setDateEnd(dateEnd);
            tournament.setDateStartInscription(dateStartInscription);
            tournament.setDateEndInscription(dateEndInscription);

            tournamentService.saveTournament(tournament);
            return "redirect:/admin-dashboard";
        } else {
            model.addAttribute("errorMessage", "Erreur lors de la mise à jour du tournoi !");
            return "admin-dashboard";
        }
    }


    @PostMapping("/tournaments/delete")
    public String deleteTournament(@RequestParam Long id, Model model) {
        if (tournamentService.getTournamentById(id).isPresent()) {
            tournamentService.deleteTournamentById(id);
            return "redirect:/admin-dashboard"; // Redirection vers le tableau de bord
        } else {
            model.addAttribute("errorMessage", "Tournoi introuvable ou déjà supprimé !");
            return "redirect:/admin-dashboard"; // Retour à la vue en cas d'erreur
        }
    }



    @PostMapping(value = "/tournaments/submitFormTournament")
    public String submitFormTournament(@Valid @ModelAttribute("tournament") Tournament tournament, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()){
            return "creation";
        }
        tournamentRepository.save(tournament);
        return "redirect:/";
    }

    public static void startTournament(Tournament tournament) {
        Set<Fight> fights = new HashSet<>();
        // Création des combats
        User player1 = null;
        for (User user : tournament.getParticipants()) {
            if (player1 != null){
                User player2 = user;
                Fight fight = new Fight();
                fight.setJoueur1(player1);
                fight.setJoueur2(player2);
                fights.add(fight);
            }
            player1 = user;
        }
        tournament.setCombats(fights);
    }

    public static void nextRound(Tournament tournament, ClassementRepository classementRepository) {
        Set<Fight> combats = tournament.getCombats();
        int nbJoueurRestant = combats.size();
        Set<User> joueurRestants = new HashSet<>();
        Classement classement = tournament.getClassement();
        if (classement == null) {
            classement = new Classement();
            classement.setTournament(tournament);
        }
        for (Fight combat : combats) {
            if (nbJoueurRestant == 1) { // Dernier combat, détermination des vainqueurs
                if (combat.getWinner() != null) { // Si un gagnant est défini
                    classement.setPremier(combat.getWinner());
                    // Déterminer le deuxième joueur
                    if (combat.getWinner().equals(combat.getJoueur1())) {
                        classement.setDeuxieme(combat.getJoueur2());
                    } else {
                        classement.setDeuxieme(combat.getJoueur1());
                    }
                } else { // Pas de gagnant, prendre les deux joueurs restants
                    classement.setPremier(combat.getJoueur1());
                    classement.setDeuxieme(combat.getJoueur2());
                }
            } else {
                if (combat.getWinner() != null) { // Ajouter les gagnants à la liste des joueurs restants
                    joueurRestants.add(combat.getWinner());

                    // Déterminer le troisième joueur s'il reste deux combats
                    if (nbJoueurRestant == 2) {
                        if (combat.getWinner().equals(combat.getJoueur1())) {
                            classement.setTroisieme(combat.getJoueur2());
                        } else {
                            classement.setTroisieme(combat.getJoueur1());
                        }
                    }
                } else { // Si aucun gagnant, prendre joueur1
                    joueurRestants.add(combat.getJoueur1());

                    // Déterminer le troisième joueur s'il reste deux combats
                    if (nbJoueurRestant == 2) {
                        classement.setTroisieme(combat.getJoueur2());
                    }
                }
            }
        }

        // Sauvegarder le classement mis à jour
        classementRepository.save(classement);

        Set<Fight> fights = new HashSet<>();
        // Création des combats du prochain round si nécessaire
        if (nbJoueurRestant != 1) { // Pas besoin de combats si le tournoi est terminé
            User player1 = null;
            for (User user : joueurRestants) {
                if (player1 != null) {
                    User player2 = user;
                    Fight fight = new Fight();
                    fight.setJoueur1(player1);
                    fight.setJoueur2(player2);
                    fights.add(fight);
                }
                player1 = user;
            }
            if (nbJoueurRestant%2==1){ //si le nombre de joueur est impair il y a donc un nominé d'office pour le prochain round
                Fight fight = new Fight();
                fight.setJoueur1(player1);
                fight.setJoueur2(player1);
                fight.setWinner(player1);
                fights.add(fight);
            }
            tournament.setCombats(fights);
        }
    }


    @Scheduled(fixedDelay = 60000)
    public void checkStartTournament(){
        LocalDateTime currentDate = LocalDateTime.now();
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        for (Tournament tournament : tournaments){
            if ( tournament.getDateStart().isBefore(currentDate)){
                startTournament(tournament);
            }
        }
    }

    @Scheduled(fixedDelay = 300000, initialDelay = 300000)
public void checkNextRound() {
    List<Tournament> tournaments = tournamentService.getAllTournamentsInProgress();
    for (Tournament tournament : tournaments) {
        // Appeler nextRound en passant le repository pour gérer le classement
        nextRound(tournament, classementRepository);

        // Sauvegarder les changements du tournoi (combats mis à jour)
        tournamentService.saveTournament(tournament);
    }
}

}
