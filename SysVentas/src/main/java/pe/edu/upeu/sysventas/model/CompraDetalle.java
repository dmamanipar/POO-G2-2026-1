package pe.edu.upeu.sysventas.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompraDetalle {

    private Long idCompraDetalle;
    private Double pu;
    private Double cantidad;
    private Double subtotal;
    private Compra idCompra;
    private Producto idProducto;
}