package pe.edu.upeu.sysventas.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marca {

    private Long idMarca;
    private String nombre;
}