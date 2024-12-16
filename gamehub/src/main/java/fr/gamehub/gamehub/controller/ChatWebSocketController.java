package fr.gamehub.gamehub.controller;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import fr.gamehub.gamehub.dto.CommentDTO;
import fr.gamehub.gamehub.model.Comment;
import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.service.CommentService;
import fr.gamehub.gamehub.service.UserService;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@Controller
public class ChatWebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(ChatWebSocketController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @MessageMapping("/chat/{communityId}")
    @SendTo("/topic/comments/{communityId}")
    @Transactional
    public CommentDTO sendMessage(Comment comment) {
        comment.setTimestamp(LocalDateTime.now());

        // Chargez l'utilisateur depuis la base
        User user = userService.getUserById(comment.getUser().getId())
                            .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        // Associez l'utilisateur complet au commentaire
        comment.setUser(user);

        // Sauvegardez le commentaire
        Comment savedComment = commentService.saveComment(comment);

        // Assurez-vous que le username est récupéré
        String username = savedComment.getUser().getUsername();
        logger.info("Comment saved by User: ID={}, Username={}", savedComment.getUser().getId(), username);

        // Retournez le DTO
        return new CommentDTO(savedComment.getId(), savedComment.getContent(), savedComment.getTimestamp(), username);

    }
}
