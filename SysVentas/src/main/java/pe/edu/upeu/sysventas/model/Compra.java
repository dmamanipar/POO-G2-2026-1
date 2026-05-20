package pe.edu.upeu.sysventas.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compra {
    private Long idCompra;
    private Double precioBase;
    private Double igv;
    private Double preciototal;
    private Proveedor idProveedor;
    private Usuario idUsuario;
    private String serie;
    private String numDoc;
    private LocalDate fechaComp;
    private String tipoDoc;
    private LocalDate fechaReg;

    List<CompraDetalle> compraDetalle;
}
