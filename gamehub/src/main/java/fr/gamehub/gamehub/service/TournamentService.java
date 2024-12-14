package fr.gamehub.gamehub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.Tournament;
import fr.gamehub.gamehub.repository.TournamentRepository;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
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
