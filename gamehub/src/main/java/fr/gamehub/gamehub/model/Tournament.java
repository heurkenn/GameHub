package fr.gamehub.gamehub.model;




import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import fr.gamehub.gamehub.validator.ValidateDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private boolean is_private;

    @NotBlank(message = "Le nombre de joueur limite ne doit pas être vide ")
    @NotEmpty
    @NotNull
    private int nbJoueurLimite;

    
    private int nbJoueur =0;

    @Override
    public boolean equals(Object o){
        if (o instanceof Tournament){
            return ((Tournament)o).getId() ==this.getId();
        }
        return false;
    }

    // 1VS1
    @OneToMany(mappedBy = "tournament")
    private Set<Fight> combats; 

    public void setCombats(Set<Fight> combats){
        this.combats = combats;
    }

    public Set<Fight> getCombats(){
        return this.combats;
    }

    @ManyToMany
    @JoinTable(
        name = "tournament_user", // Nom de la table de jointure
        joinColumns = @JoinColumn(name = "tournament_id"), // Clé étrangère vers Tournoi
        inverseJoinColumns = @JoinColumn(name = "user_id") // Clé étrangère vers User
    )
    private Set<User> participants = new HashSet<>();

    public Set<User> getParticipants(){
        return this.participants;
    }

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Classement> classements = new HashSet<>();

    public void setClassement(Classement classement) {
        this.classements.clear();
        this.classements.add(classement);
    }

    public Classement getClassement() {
        return classements.isEmpty() ? null : classements.iterator().next();
    }

}

