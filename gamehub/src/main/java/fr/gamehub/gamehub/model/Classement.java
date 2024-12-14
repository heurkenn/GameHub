package fr.gamehub.gamehub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classement")
@Getter
@Setter
@NoArgsConstructor
public class Classement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec le tournoi
    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    // Premier joueur
    @ManyToOne
    @JoinColumn(name = "premier_id", nullable = true)
    private User premier;

    // Deuxième joueur
    @ManyToOne
    @JoinColumn(name = "deuxieme_id", nullable = true)
    private User deuxieme;

    // Troisième joueur
    @ManyToOne
    @JoinColumn(name = "troisieme_id", nullable = true)
    private User troisieme;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Classement other) {
            return this.id != null && this.id.equals(other.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }
}
