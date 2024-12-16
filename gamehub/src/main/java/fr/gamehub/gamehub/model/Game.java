package fr.gamehub.gamehub.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "game")
@Getter
@Setter
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du jeu ne peut pas être vide")
    private String name;

    @Column(name = "release_year") // Ajoutez cette annotation pour mapper correctement à la colonne
    private int releaseYear;

    
    @Column(name = "developer_studio") // Mappage explicite pour éviter les erreurs
    @NotBlank(message = "Le studio de développement ne peut pas être vide")
    private String developerStudio;

    @NotBlank(message = "Le genre ne peut pas être vide")
    private String genre;

    private String image_url;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "game_platforms",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private Set<Platform> platforms = new HashSet<>();
}
