package pe.edu.upeu.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Venta {

    private String idVenta;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double monto;
    private LocalDate fecha;

    public Venta(String idVenta, Cliente cliente,
                 Vehiculo vehiculo) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.monto=vehiculo.getPrecioBase();
        this.fecha=LocalDate.now();
        vehiculo.setDisponible(false);
    }
}
