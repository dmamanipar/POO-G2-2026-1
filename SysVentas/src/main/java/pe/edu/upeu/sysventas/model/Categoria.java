package pe.edu.upeu.sysventas.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    private Long idCategoria;
    private String nombre;
}