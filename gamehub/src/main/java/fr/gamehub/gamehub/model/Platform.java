package fr.gamehub.gamehub.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la plateforme ne peut pas être vide")
    private String name;

    @PastOrPresent(message = "La date de lancement ne peut pas être dans le futur")
    private LocalDate launchDate;

    @NotBlank(message = "Le studio de développement ne peut pas être vide")
    private String developerStudio;

    // Lombok génère automatiquement les getters, setters, et le constructeur sans argument
}
