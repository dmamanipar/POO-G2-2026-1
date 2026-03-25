package pe.edu.upeu.composicion;

public class Casa {

    protected Habitacion habitacion;

    Casa(){
        this.habitacion=new Habitacion();
    }

    public static void main(String[] args) {
        Casa c=new Casa();
        System.out.println("Habitaciones de "+c.habitacion.tamanho+" m2");
    }

}
