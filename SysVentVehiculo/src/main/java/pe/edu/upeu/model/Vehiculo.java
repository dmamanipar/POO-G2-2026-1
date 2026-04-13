package pe.edu.upeu.model;

import lombok.Data;
import pe.edu.upeu.enums.TipoVehiculo;

@Data
public class Vehiculo {
    private String id;
    private String marca;
    private String modelo;
    private int anho;
    private double precioBase;
    private  boolean disponible;
    private TipoVehiculo tipo;

    public Vehiculo(String id, String marca, String modelo,
                    int anho, double precioBase, TipoVehiculo tipo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anho = anho;
        this.precioBase = precioBase;
        this.tipo = tipo;
        this.disponible=true;
    }
}
