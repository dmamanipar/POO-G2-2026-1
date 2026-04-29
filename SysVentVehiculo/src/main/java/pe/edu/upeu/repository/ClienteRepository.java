package pe.edu.upeu.repository;

import pe.edu.upeu.config.ConexionSQLite;
import pe.edu.upeu.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    public static ClienteRepository instace=new ClienteRepository();

    public Connection con=new ConexionSQLite().conectar();
    PreparedStatement ps;
    ResultSet rs;

    public static ClienteRepository getInstace(){
        if(instace==null){
            instace=new ClienteRepository();
        }
        return instace;
    }
    List<Cliente> clientes;
    //Create
    public void save(Cliente cliente){
        clientes.add(cliente);
    }
    //Report
    public List<Cliente> finAll(){
        clientes=new ArrayList<>();
        try {
            ps=con.prepareStatement("select * from cliente");
            rs=ps.executeQuery();
            while (rs.next()){
                Cliente c=new Cliente();
                c.setIdDni(rs.getString("idDni"));
                c.setNombre(rs.getString("nombre"));
                clientes.add(c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
