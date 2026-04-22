package pe.edu.upeu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {
    private String idDni;
    private String nombre;
    private String telefono;
    private String email;
}
