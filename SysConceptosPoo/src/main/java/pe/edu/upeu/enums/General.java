package pe.edu.upeu.enums;

public class General {
    public static void main(String[] args) {
        System.out.println(Mes.Enero);
        for (Mes a:Mes.values()){
            System.out.println(a);
        }

        for (Genero g: Genero.values()){
            System.out.println(g.descripcion+"\t"+g.name());
        }

    }
}
