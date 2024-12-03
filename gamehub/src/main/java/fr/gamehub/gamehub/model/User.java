package fr.gamehub.gamehub.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity @Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom d'utilisateur ne peut pas être vide")
    @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit être compris entre 3 et 50 caractères")
    private String username;

    @NotBlank(message = "L'email ne peut pas être vide")
    @Email(message = "Veuillez fournir un email valide")
    private String email;

    @NotBlank(message = "Le mot de passe ne peut pas être vide")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    private String password;

    @Transient
    // @ManyToMany
    // @JoinTable(
    //         name = "user_games",
    //         joinColumns = @JoinColumn(name = "user_id"),
    //         inverseJoinColumns = @JoinColumn(name = "game_id")
    // )
    private Set<Game> games = new HashSet<>();

    @Transient
    // @ManyToMany(mappedBy = "participants") // Indique que la relation est gérée par la classe Tournoi
    private Set<Tournament> tournaments = new HashSet<>();

    // Lombok génère automatiquement les getters, setters, et le constructeur sans argument
}
