package pe.edu.upeu.service;

import pe.edu.upeu.model.Cliente;

import java.util.List;

public interface ClienteService {
    void save(Cliente c);
    List<Cliente> finAll();
    void update(Cliente c, int index);
    void delete(int index);

}
