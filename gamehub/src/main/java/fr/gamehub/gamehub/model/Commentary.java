package fr.gamehub.gamehub.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "games") 
@Getter
@Setter
@NoArgsConstructor

public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Le nom du jeu ne peut pas être vide")
    @Size(min = 1, max = 2000, message = "Le nom du jeu doit être compris entre 3 et 50 caractères")
    private String content;


    @NotBlank(message = "la note ne peut pas être vide")
    @Min(value=0)
    @Max(value=5)
    private double rate;
}
