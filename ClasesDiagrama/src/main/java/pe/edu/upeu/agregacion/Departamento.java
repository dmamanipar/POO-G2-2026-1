package pe.edu.upeu.agregacion;

import java.util.ArrayList;

public class Departamento {

    private ArrayList<Profesor> profesors;

    Departamento(){
        profesors=new ArrayList<>();
    }

    void agregarProfesor(Profesor profesor){
        profesors.add(profesor);
    }

    void listarProfesores(ArrayList<Profesor> integrantes){
        for (Profesor p:integrantes){
            System.out.println(p.nombre);
        }
    }

    public static void main(String[] args) {
        Departamento matematica=new Departamento();
        matematica.agregarProfesor(new Profesor("Pedro"));
        matematica.agregarProfesor(new Profesor("Raul"));
        matematica.agregarProfesor(new Profesor("Juan"));
        matematica.listarProfesores(matematica.profesors);
    }
}
