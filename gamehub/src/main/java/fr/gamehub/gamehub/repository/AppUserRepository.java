package fr.gamehub.gamehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.gamehub.gamehub.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
