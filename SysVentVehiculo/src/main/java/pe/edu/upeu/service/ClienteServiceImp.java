package pe.edu.upeu.service;

import pe.edu.upeu.model.Cliente;
import pe.edu.upeu.repository.ClienteRepository;

import java.util.List;

public class ClienteServiceImp extends ClienteRepository implements ClienteService{

    @Override
    public void save(Cliente c) {
        super.save(c);
    }

    @Override
    public List<Cliente> finAll() {
        return  super.finAll();
    }

    @Override
    public void update(Cliente c, int index) {
        super.update(c, index);
    }

    @Override
    public void delete(int index) {
        super.delete(index);
    }

}
