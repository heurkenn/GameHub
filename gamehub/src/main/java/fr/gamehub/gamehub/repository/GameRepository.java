package fr.gamehub.gamehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gamehub.gamehub.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    // Tu peux ajouter ici des méthodes de recherche personnalisées, par exemple pour chercher un jeu par nom
    Game findByName(String name);
}
