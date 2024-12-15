package fr.gamehub.gamehub.repository;

import fr.gamehub.gamehub.model.Classement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassementRepository extends JpaRepository<Classement, Long> {

    // Trouver un classement par tournoi
    Optional<Classement> findByTournamentId(Long tournamentId);

}
