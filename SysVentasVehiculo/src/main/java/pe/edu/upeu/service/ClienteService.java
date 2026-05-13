package pe.edu.upeu.service;
import pe.edu.upeu.model.Cliente;
import java.util.List;
import java.util.Optional;
public interface ClienteService {
    Cliente save(Cliente c);
    Cliente update(Cliente c);
    void delete(String idDni);
    List<Cliente> findAll();
    List<Cliente> buscar(String dato);
    Optional<Cliente> findById(String id);
    boolean existById(String id);
}
