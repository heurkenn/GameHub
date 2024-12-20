package fr.gamehub.gamehub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.Game;
import fr.gamehub.gamehub.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public Optional<Game> findByName(String name) {
        return gameRepository.findByName(name);
    }

    // Méthode pour récupérer des jeux aléatoires
    public List<Game> findRandomGames(int limit) {
        return gameRepository.findRandomGames(limit);
    }
}
