package fr.gamehub.gamehub.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Tournament") 
@Getter
@Setter
@NoArgsConstructor
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Le nom du jeu ne peut pas être vide")
    @Size(min = 3, max = 50, message = "Le nom du jeu doit être compris entre 3 et 50 caractères")
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank(message = "La date de création ne doit pas être vide")
    private Date datecréation;

    @NotNull
    @NotEmpty
    @NotBlank(message = "La date de debut ne doit pas être vide")
    private Date dateStart;

    
    private Date dateEnd;

    
    @NotNull
    @NotEmpty
    @NotBlank(message = "La date de fin des inscirptions ne doit pas être vide")
    private Date dateEndInscription;

    @NotNull
    @NotEmpty
    @NotBlank(message = "La date de début des inscriptions ne doit pas être vide")
    private Date dateStartInscription;

    @NotNull
    @NotEmpty
    @NotBlank(message = "La categorie ne peut être vide")
    private Category categorie;

    @NotBlank(message = "Le jeu ne peut pas être vide")
    @ManyToOne
    @JoinColumn(name="game_id", nullable=false)
    private Game jeu;

    @NotBlank(message = "Le tournoi est soi privé, soi public")
    @NotEmpty
    @NotNull
    private boolean privé;

    @NotBlank(message = "Le nombre de joueur limite ne doit pas être vide ")
    @NotEmpty
    @NotNull
    private int nbJoueurLimite;

    
    @NotBlank(message = "Le nombre de joueur ne doit pas être vide ")
    @NotEmpty
    @NotNull
    private int nbJoueur;

    @OneToMany(mappedBy = "tournament")
    private Set<Fight> combats; 

}

