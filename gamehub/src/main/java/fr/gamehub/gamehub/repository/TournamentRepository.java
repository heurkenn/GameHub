package fr.gamehub.gamehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gamehub.gamehub.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
