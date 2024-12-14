package fr.gamehub.gamehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gamehub.gamehub.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCommunityId(Long communityId);
}
