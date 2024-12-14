package fr.gamehub.gamehub.repository;


import fr.gamehub.gamehub.model.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FightRepository extends JpaRepository<Fight, Long>  {
    
}
