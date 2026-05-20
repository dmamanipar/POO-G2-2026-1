package pe.edu.upeu.sysventas.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    private Long idUsuario;
    private String usuario;
    private String clave;
    private Perfil idPerfil;
    private String estado;
}