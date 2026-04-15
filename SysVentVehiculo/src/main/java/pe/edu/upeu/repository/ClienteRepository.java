package pe.edu.upeu.repository;

import pe.edu.upeu.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    public static ClienteRepository instace=new ClienteRepository();

    public static ClienteRepository getInstace(){
        if(instace==null){
            instace=new ClienteRepository();
        }
        return instace;
    }
    List<Cliente> clientes=new ArrayList<>();
    //Create
    public void save(Cliente cliente){
        clientes.add(cliente);
    }
    //Report
    public List<Cliente> finAll(){
        return clientes;
    }
    //Update
    public void  update(Cliente c, int index){
        clientes.set(index, c);
    }
    //Delete
    public void delete(int index){
        clientes.remove(index);
    }

    public void cargarDatos(){
        clientes.add(new Cliente("43631817", "Raul Gomez", "951782511", "raul@gmail.com"));
        clientes.add(new Cliente("43631818", "Pedro Apaza", "951782512", "pedrito@gmail.com"));
    }

}
