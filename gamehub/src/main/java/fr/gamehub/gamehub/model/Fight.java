package fr.gamehub.gamehub.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Tournament") 
@Getter
@Setter
@NoArgsConstructor
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="tournament_id", nullable=false)
    private Tournament tournoi;


    private User joueur1;
    private User joueur2;



}
