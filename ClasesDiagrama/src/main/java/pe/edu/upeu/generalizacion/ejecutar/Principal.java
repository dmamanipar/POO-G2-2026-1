package pe.edu.upeu.generalizacion.ejecutar;

import pe.edu.upeu.generalizacion.Coche;

public class Principal {
    public static void main(String[] args) {
        Coche mc=new Coche();
        mc.placa="54www5454";
        mc.mover();
        mc.abrirPuertas();
    }
}
