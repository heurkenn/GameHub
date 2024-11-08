package fr.gamehub.gamehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.gamehub.gamehub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
