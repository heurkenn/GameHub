package fr.gamehub.gamehub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le nom est obligatoire")
    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(min = 3, max = 100, message = "Le nom doit comporter entre 3 et 100 caractères")
    private String name;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game; // Le jeu auquel ce tournoi est associé

    @NotNull(message = "Le date est obligatoire")
    @NotBlank(message = "La date de début ne peut pas être vide")
    private String startDate;

    @NotNull(message = "Le date est obligatoire")
    @NotBlank(message = "La date de fin ne peut pas être vide")
    private String endDate;
}

