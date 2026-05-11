package pe.edu.upeu.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
@Entity(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cliente {
    @Id
    @Column(name = "dni")
    @NotBlank(message = "El dni es obligatorio")
    @Size(min = 8, max = 8, message = "El dni debe tener como minimo y maximo 8 digitos")
    private String idDni;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String telefono;

    @Email(message = "El email no tiene un formato valido")
    private String email;
}
