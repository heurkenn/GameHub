package fr.gamehub.gamehub.service;

import java.util.Optional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.Category;
import fr.gamehub.gamehub.model.Tournament;
import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.repository.TournamentRepository;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public List<Tournament> getAllTournamentsInProgress() {
        List<Tournament> tournaments = tournamentRepository.findAll();
        List<Tournament> tournamentsInProgress = new ArrayList<>();
        LocalDateTime curLocalDateTime = LocalDateTime.now();
        for (Tournament tournament : tournaments){
            if((tournament.getDateStart().isBefore(curLocalDateTime))&&(tournament.getDateEnd().isAfter(curLocalDateTime))){
                tournamentsInProgress.add(tournament);
            }
        }
        return tournamentsInProgress;
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }
    public Optional<Tournament> findByCategorie(Category categorie) {
        return tournamentRepository.findByCategorie(categorie);
    }

     // Ajoute aussi une méthode pour enregistrer ou mettre à jour un tournoi
     public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    //ajoute un user à un tournoi 
    public static void addParticipant(Tournament tournament,User user){
        tournament.getParticipants().add(user);
    }

    //Supprimer un tournoi par exemple s'il est fini
    public void deleteTournament(Long tournamentId) {
        // check if the tournoi exists before deletion
        if (tournamentRepository.existsById(tournamentId)) {
            tournamentRepository.deleteById(tournamentId);
        } else {
            // Handle the case where the tournament does not exist
            System.out.println("Tournoi with ID " + tournamentId + " does not exist.");
        }
    }
    public void deleteTournamentById(Long id) {
        tournamentRepository.deleteById(id);
    }
    public List<Tournament> searchTournamentNameStartBy(String prefixName){
        return tournamentRepository.findByPrefix(prefixName);
    }
    public List<Tournament> searchTournamentByPrivacy(boolean is_private){
        return tournamentRepository.findByPrivacy(is_private);
    }
}
