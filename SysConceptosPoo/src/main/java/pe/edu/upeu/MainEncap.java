package pe.edu.upeu;

import pe.edu.upeu.encapsulamiento.Persona;
import pe.edu.upeu.encapsulamiento.PersonaX;

public class MainEncap {
    public static void main(String[] args) {
        Persona pObj=new Persona();
        pObj.setNombre("Dario");
        pObj.setEdad(40);
        System.out.println(pObj.getNombre()+"\t"+pObj.getEdad());

        PersonaX pObjX=new PersonaX();
        pObjX.setNombre("David");
        pObjX.setEdad(54);
        System.out.println(pObjX.getNombre()+"\t"+pObjX.getEdad());

    }
}
