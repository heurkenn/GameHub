package fr.gamehub.gamehub.repository;

import java.util.Optional;
import fr.gamehub.gamehub.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long>{
    Optional<Tournament> findByJeu(Game jeu); 
    Optional<Tournament> findByCategorie(Category categorie); 

    @Query("SELECT e FROM Tournament e WHERE e.name LIKE :prefixName%")
    List<Tournament> findByPrefix(@Param("prefixName") String prefixName);

    
}




