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
        return commentRepository.save(comment);
    }
}
