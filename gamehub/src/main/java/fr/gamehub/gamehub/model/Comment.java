package fr.gamehub.gamehub.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content; // Contenu du commentaire

    private LocalDateTime timestamp; // Horodatage du commentaire

    @ManyToOne
    private User user; // Auteur du commentaire

    @ManyToOne
    private Community community; // La communauté à laquelle le commentaire est associé
}
