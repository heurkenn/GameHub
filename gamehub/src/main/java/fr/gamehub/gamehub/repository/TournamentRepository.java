package fr.gamehub.gamehub.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import fr.gamehub.gamehub.model.*;

public interface TournamentRepository extends JpaRepository<Tournament, Long>{
    Optional<Tournament> findByJeu(Game jeu); 
    Optional<Tournament> findByCategorie(Category categorie); 

    @Query("SELECT e FROM Tournament e WHERE e.name LIKE :prefixName%")
    List<Tournament> findByPrefix(@Param("prefixName") String prefixName);

    @Query("SELECT e FROM Tournament e WHERE e.is_private = :is_private")
    List<Tournament> findByPrivacy(@Param("is_private") boolean is_private);
}




