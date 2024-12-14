package fr.gamehub.gamehub.repository;

import java.util.Optional;
import fr.gamehub.gamehub.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long>{
    Optional<Tournament> findByJeu(Game jeu); 
    Optional<Tournament> findByCategory(Category category);    
}




