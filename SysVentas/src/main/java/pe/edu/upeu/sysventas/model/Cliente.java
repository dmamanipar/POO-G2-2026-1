package pe.edu.upeu.sysventas.model;

import lombok.*;
import pe.edu.upeu.sysventas.enums.TipoDocumento;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    private String dniruc;
    private String nombres;
    private TipoDocumento tipoDocumento;
    private String repLegal;
}