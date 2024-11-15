package fr.gamehub.gamehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gamehub.gamehub.model.User;

public interface AppUserRepository extends JpaRepository<User, Long> {
    // Méthodes de recherche personnalisées, si nécessaire
}
