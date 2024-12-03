package fr.gamehub.gamehub.service;

import java.util.Optional;
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

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }
    public Optional<Tournament> findByCategory(Category category) {
        return tournamentRepository.findByCategory(category);
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


       
}
