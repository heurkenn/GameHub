package fr.gamehub.gamehub.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du jeu ne peut pas être vide")
    private String name;

    private int year;

    @NotBlank(message = "Le studio de développement ne peut pas être vide")
    private String developerStudio;

    @NotBlank(message = "Le style de jeu ne peut pas être vide")
    private String genre;

    @ElementCollection
    @CollectionTable(name = "game_platforms", joinColumns = @JoinColumn(name = "game_id"))
    @Column(name = "platform")
    private Set<String> platforms = new HashSet<>();

    @ManyToMany(mappedBy = "games")
    private Set<User> users = new HashSet<>();

    // Lombok génère automatiquement les getters, setters, et le constructeur sans argument
}
