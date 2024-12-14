package fr.gamehub.gamehub.model;




import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;
import fr.gamehub.gamehub.validator.*;

@Entity
@Table(name = "Tournament") 
@Getter
@Setter
@NoArgsConstructor
@ValidateDate
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le nom est obligatoire")
    @NotEmpty
    @NotBlank(message = "Le nom du jeu ne peut pas être vide")
    @Size(min = 3, max = 50, message = "Le nom du jeu doit être compris entre 3 et 50 caractères")
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank(message = "La date de création ne doit pas être vide")
    private LocalDateTime datecreation = LocalDateTime.now();

    @NotNull
    @NotEmpty
    @NotBlank(message = "La date de debut ne doit pas être vide")
    private LocalDateTime dateStart;

    @NotNull
    @NotEmpty
    @NotBlank(message = "La date de fin ne doit pas être vide")
    private LocalDateTime dateEnd;

    
    @NotNull
    @NotEmpty
    @NotBlank(message = "La date de fin des inscriptions ne doit pas être vide")
    private LocalDateTime dateEndInscription;

    @NotNull
    @NotEmpty
    @NotBlank(message = "La date de début des inscriptions ne doit pas être vide")
    private LocalDateTime dateStartInscription;

    @NotNull
    @NotEmpty
    @NotBlank(message = "La categorie ne peut être vide")
    private Category categorie;

    @NotBlank(message = "Le jeu ne peut pas être vide")
    @ManyToOne
    @JoinColumn(name="game_id", nullable=false)
    private Game jeu;

    @NotBlank(message = "Le tournoi est soit privé, soit public")
    @NotEmpty
    @NotNull
    private boolean isPrivate;

    @NotBlank(message = "Le nombre de joueur limite ne doit pas être vide ")
    @NotEmpty
    @NotNull
    private int nbJoueurLimite;

    
    private int nbJoueur =0;

    // 1VS1
    @OneToMany(mappedBy = "tournament")
    private Set<Fight> combats; 

    @ManyToMany
    @JoinTable(
        name = "tournament_user", // Nom de la table de jointure
        joinColumns = @JoinColumn(name = "tournament_id"), // Clé étrangère vers Tournoi
        inverseJoinColumns = @JoinColumn(name = "user_id") // Clé étrangère vers User
    )
    private Set<User> participants = new HashSet<>();
}

