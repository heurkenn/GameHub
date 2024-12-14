package fr.gamehub.gamehub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.gamehub.gamehub.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    // Tu peux ajouter ici des méthodes de recherche personnalisées si nécessaire
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
