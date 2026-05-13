package pe.edu.upeu.component.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DniUnicoValidator implements
        ConstraintValidator<DniUnic,String> {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext cvc) {
        return false;
    }
}
