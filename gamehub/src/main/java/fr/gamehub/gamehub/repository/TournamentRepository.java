package fr.gamehub.gamehub.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import fr.gamehub.gamehub.model.*;

public interface TournamentRepository extends JpaRepository<Tournament, Long>{
    Optional<Tournament> findByJeu(Game jeu); 
    Optional<Tournament> findByCategorie(Category categorie);    
}




