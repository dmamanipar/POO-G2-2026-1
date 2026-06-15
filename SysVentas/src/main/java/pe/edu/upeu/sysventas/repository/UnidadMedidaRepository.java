package pe.edu.upeu.sysventas.repository;


import pe.edu.upeu.sysventas.model.UnidadMedida;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnidadMedidaRepository extends AbstractJpaRepository<UnidadMedida, Long> {
    @Override protected String getTableName() { return "upeu_unid_medida"; }
    @Override protected String getPkColumn()  { return "id_unidad"; }

    @Override
    protected UnidadMedida mapRow(ResultSet rs) throws SQLException {
        return UnidadMedida.builder().idUnidad(rs.getLong("id_unidad"))
                .nombreMedida(rs.getString("nombre_medida")).build();
    }
    @Override
    protected UnidadMedida insert(Connection conn, UnidadMedida e) throws SQLException {
        long id = executeInsertGetKey(conn,
                "INSERT INTO upeu_unid_medida(nombre_medida) VALUES(?)", e.getNombreMedida());
        e.setIdUnidad(id); return e;
    }
    @Override
    protected UnidadMedida updateRow(Connection conn, UnidadMedida e) throws SQLException {
        executeUpdate(conn, "UPDATE upeu_unid_medida SET nombre_medida=? WHERE id_unidad=?",
                e.getNombreMedida(), e.getIdUnidad()); return e;
    }
}
