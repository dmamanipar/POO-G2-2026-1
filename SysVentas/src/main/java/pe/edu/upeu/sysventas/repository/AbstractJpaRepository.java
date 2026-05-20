package pe.edu.upeu.sysventas.repository;

import pe.edu.upeu.sysventas.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AbstractJpaRepository<T,ID> extends SqlHelper<T> implements ICrudGenericoRepository<T,ID>{

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.empty();
    }

    @Override
    public List<T> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    protected T mapRow(ResultSet rs) throws SQLException {
        return null;
    }
}
