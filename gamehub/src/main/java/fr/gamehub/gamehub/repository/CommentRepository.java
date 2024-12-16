package fr.gamehub.gamehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gamehub.gamehub.model.Comment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCommunityId(Long communityId);

    @Query("SELECT c FROM Comment c JOIN FETCH c.user u WHERE c.id = :commentId")
    Comment findCommentWithUser(@Param("commentId") Long commentId);
}

