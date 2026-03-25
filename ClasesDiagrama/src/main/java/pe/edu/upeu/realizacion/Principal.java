package pe.edu.upeu.realizacion;

public class Principal {
    public static void main(String[] args) {
        Volador v=new Pajaro();
        v.volar();
        v=new Avion();
        v.volar();
    }
}
