package fr.gamehub.gamehub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.gamehub.gamehub.model.*;
public interface CommentaryRepository extends JpaRepository<Commentary, Long>{
    Optional<Tournament> findByUser(User user);
}
