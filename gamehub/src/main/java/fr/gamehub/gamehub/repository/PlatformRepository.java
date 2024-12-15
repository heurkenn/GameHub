package fr.gamehub.gamehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gamehub.gamehub.model.Platform;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
    List<Platform> findByNameIn(List<String> names); // Rechercher les plateformes par noms
}

