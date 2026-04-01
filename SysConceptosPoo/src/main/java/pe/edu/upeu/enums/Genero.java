package pe.edu.upeu.enums;

public enum Genero {

    MASCULINO("M"), FEMENINO("F");

    String descripcion;
    Genero(String descripcion){
        this.descripcion=descripcion;
    }
}
