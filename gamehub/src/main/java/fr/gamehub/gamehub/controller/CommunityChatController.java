package fr.gamehub.gamehub.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gamehub.gamehub.model.Comment;
import fr.gamehub.gamehub.service.CommentService;
import fr.gamehub.gamehub.service.CommunityService;
import fr.gamehub.gamehub.service.UserService;

@RestController
@RequestMapping("/games/{name}/chat")
public class CommunityChatController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommunityService communityService;

    @Autowired
    private UserService userService;

    // Récupérer les commentaires d'une communauté
    @GetMapping("/{communityId}/comments")
    public List<Comment> getComments(@PathVariable Long communityId) {
        return commentService.getCommentsByCommunityId(communityId);
    }

    // Ajouter un commentaire
    @PostMapping("/{communityId}/comments")
    public Comment postComment(
            @PathVariable Long communityId,
            @RequestBody Comment comment,
            @RequestParam Long userId
    ) {
        comment.setTimestamp(LocalDateTime.now());
        comment.setCommunity(communityService.getCommunityById(communityId));
        comment.setUser(userService.getUserById(userId));
        return commentService.saveComment(comment);
    }
}
