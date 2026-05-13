package pe.edu.upeu.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import pe.edu.upeu.component.validation.DniUnic;

@Entity(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cliente {
    @Id
    @DniUnic(message = "El DNI ya esta registrado")
    @Column(name = "dni")
    @NotBlank(message = "El dni es obligatorio")
    @Size(min = 8, max = 8, message = "El dni debe tener como minimo y maximo 8 digitos")
    private String idDni;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Pattern(regexp = "^9\\d{8}$", message = "el numero de telefono no tiene el formato valido")
    @NotBlank(message = "El nombre es obligatorio")
    private String telefono;

    @NotBlank(message = "El nombre es obligatorio")
    @Email(message = "El email no tiene un formato valido")
    private String email;
}
