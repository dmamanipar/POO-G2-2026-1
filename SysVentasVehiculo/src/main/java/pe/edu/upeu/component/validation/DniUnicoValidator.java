package pe.edu.upeu.component.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pe.edu.upeu.service.ClienteService;

public class DniUnicoValidator implements
        ConstraintValidator<DniUnic,String> {
    private ClienteService cs;

    public void initialize(ClienteService cs){
        this.cs=cs;
    }

    @Override
    public boolean isValid(String dni, ConstraintValidatorContext cvc) {
        if(cs==null || dni==null || dni.isBlank()) return true;
        return !cs.existById(dni);
    }
}
