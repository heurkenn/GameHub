package fr.gamehub.gamehub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gamehub.gamehub.model.Community;

public interface CommunityRepository extends JpaRepository<Community, Long> {
    /**
     * Rechercher une communauté par son nom.
     *
     * @param name Le nom de la communauté.
     * @return Un Optional contenant la communauté si elle existe, ou vide sinon.
     */
    Optional<Community> findByName(String name);
}
