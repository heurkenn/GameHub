package fr.gamehub.gamehub.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Stratégie par défaut
@DiscriminatorColumn(name = "dtype") // Colonne discriminante
@Table(name = "app_user")  // Pour éviter le conflit avec le mot réservé "user"
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le prénom ne peut pas être vide")
    @Size(min = 2, max = 50, message = "Le prénom doit être compris entre 2 et 50 caractères")
    private String name;

    @NotBlank(message = "Le nom de famille ne peut pas être vide")
    @Size(min = 2, max = 50, message = "Le nom doit être compris entre 2 et 50 caractères")
    private String surname;

    @NotBlank(message = "Le nom d'utilisateur ne peut pas être vide")
    @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit être compris entre 3 et 50 caractères")
    private String username;

    @NotBlank(message = "L'email ne peut pas être vide")
    @Email(message = "Veuillez fournir un email valide")
    private String email;

    @NotBlank(message = "Le mot de passe ne peut pas être vide")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    private String password;
 
    @ManyToMany
    @JoinTable(
            name = "user_games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Set<Game> games = new HashSet<>();
    @ManyToMany(mappedBy = "participants")
    private Set<Tournament> tournois = new HashSet<>();
    // Lombok génère automatiquement les getters, setters, et le constructeur sans argument
}
