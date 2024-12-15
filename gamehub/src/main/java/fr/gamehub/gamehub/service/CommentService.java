package fr.gamehub.gamehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.Comment;
import fr.gamehub.gamehub.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByCommunityId(Long communityId) {
        return commentRepository.findByCommunityId(communityId);
    }

    public Comment saveComment(Comment comment) {
        // Sauvegarder le commentaire
        Comment savedComment = commentRepository.save(comment);

        // Charger le commentaire avec l'utilisateur pour forcer le lazy loading
        Comment fullComment = commentRepository.findCommentWithUser(savedComment.getId());
        return fullComment;
    }
}
