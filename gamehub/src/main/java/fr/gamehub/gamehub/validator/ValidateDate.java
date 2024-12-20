package fr.gamehub.gamehub.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateDate {
    String message() default "DateDebut doit être inférieure à DateFin.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
