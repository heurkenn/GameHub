package fr.gamehub.gamehub.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User {

    @OneToOne
    @JoinColumn(name = "game_id")
    private Game game; // L'admin est responsable d'un jeu spécifique

    private boolean isSuperAdmin; // Indique si l'admin est le super admin

}

