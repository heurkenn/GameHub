package fr.gamehub.gamehub.dto;

import java.time.LocalDateTime;

public class CommentDTO {
    private Long id;
    private String content;
    private LocalDateTime timestamp;
    private String username;

    // Constructeur
    public CommentDTO(Long id, String content, LocalDateTime timestamp, String username) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.username = username;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
