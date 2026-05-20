package pe.edu.upeu.sysventas.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
    private Long idProveedor;
    private String dniruc;
    private String nombresRaso;
    private String tipoDoc;
    private String celular;
    private String email;
    private String direccion;
}
