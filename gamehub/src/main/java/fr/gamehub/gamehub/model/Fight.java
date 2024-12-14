package fr.gamehub.gamehub.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fight") 
@Getter
@Setter
@NoArgsConstructor
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="tournament_id", nullable=false)
    private Tournament tournament;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User joueur1;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User joueur2;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User winner = null;
}
