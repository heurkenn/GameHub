package fr.gamehub.gamehub.model;




import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
    private LocalDateTime datecreation = LocalDateTime.now();

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateStart;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateEnd;

    
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateEndInscription;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateStartInscription;

    @Transient
    private String formattedDateStart;

    @Transient
    private String formattedDateEnd;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category categorie;

    @NotNull(message = "Le jeu est obligatoire")
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game jeu;

    @NotNull(message = "Le nombre de joueur limite est obligatoire")
    private int nbJoueurLimite;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int nbJoueur =0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament that = (Tournament) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
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

    public String getFormattedDateStart() {
        return formattedDateStart;
    }

    public void setFormattedDateStart(String formattedDateStart) {
        this.formattedDateStart = formattedDateStart;
    }

    public String getFormattedDateEnd() {
        return formattedDateEnd;
    }

    public void setFormattedDateEnd(String formattedDateEnd) {
        this.formattedDateEnd = formattedDateEnd;
    }

}

