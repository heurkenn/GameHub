package fr.gamehub.gamehub.validator;

import fr.gamehub.gamehub.model.Tournament;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidateDate, Tournament> {

    @Override
    public boolean isValid(Tournament tournament, ConstraintValidatorContext context) {
        
        
        if (tournament.getDateEnd() == null || tournament.getDateEndInscription() == null || tournament.getDateStart() ==null || tournament.getDateStartInscription() ==null) {
            return true; // Les annotations @NotNull géreront ces cas
        }
        boolean b =true;
        b= b&& tournament.getDatecreation().isBefore(tournament.getDateStartInscription());
        b= b&& tournament.getDateStartInscription().isBefore(tournament.getDateEndInscription());
        b= b&& tournament.getDateEndInscription().isBefore(tournament.getDateStart());
        b= b&& tournament.getDateStart().isBefore(tournament.getDateEnd());
        return b;
    }
}
