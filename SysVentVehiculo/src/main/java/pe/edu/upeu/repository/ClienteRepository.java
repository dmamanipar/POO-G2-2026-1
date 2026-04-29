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
        String sql="INSERT INTO cliente (idDni, nombre, telefono, email) VALUES(?, ?, ?, ?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, cliente.getIdDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                clientes.add(c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }
    //Update
    public void  update(Cliente c, String dni){
        String sql="UPDATE cliente SET nombre=?, telefono=?, email=? WHERE idDni=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getIdDni());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Delete
    public void delete(String dni){
        String sql="DELETE FROM cliente WHERE idDni=?";
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
