package fr.gamehub.gamehub.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.gamehub.gamehub.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

    // Recherche un jeu par son nom
    Optional<Game> findByName(String name);

    // Recherche des jeux par genre
    List<Game> findByGenre(String genre);

    // Recherche des jeux par développeur
    List<Game> findByDeveloperStudio(String developerStudio);

    // Obtenir un nombre limité de jeux aléatoires
    @Query(value = "SELECT * FROM game ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Game> findRandomGames(@Param("count") int count);

    // Recherche des jeux par mot-clé dans le nom
    @Query("SELECT g FROM Game g WHERE LOWER(g.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Game> searchGamesByNameKeyword(@Param("keyword") String keyword);
}
