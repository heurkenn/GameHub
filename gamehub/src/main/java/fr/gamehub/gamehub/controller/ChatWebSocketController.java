package fr.gamehub.gamehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import fr.gamehub.gamehub.model.Comment;
import fr.gamehub.gamehub.service.CommentService;

import java.time.LocalDateTime;

@Controller
public class ChatWebSocketController {

    @Autowired
    private CommentService commentService;

    @MessageMapping("/chat/{communityId}")
    @SendTo("/topic/comments/{communityId}")
    public Comment sendMessage(Comment comment) {
        // Ajouter une date au commentaire
        comment.setTimestamp(LocalDateTime.now());
        // Sauvegarder le commentaire dans la base de données
        return commentService.saveComment(comment);
    }
}
