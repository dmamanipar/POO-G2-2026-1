package pe.edu.upeu.sysventas.repository;

import pe.edu.upeu.sysventas.model.Perfil;
import pe.edu.upeu.sysventas.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository extends AbstractJpaRepository<Usuario,Long> {

    @Override
    protected String getTableName() {return "upeu_usuario";}
    @Override
    protected String getPkColumn() {return "id_usuario";}

    private static final String SELECT_JOIN =
            "SELECT u.*, p.nombre AS perfil_nombre, p.codigo AS perfil_codigo " +
                    "FROM upeu_usuario u JOIN upeu_perfil p ON u.id_perfil =p.id_perfil ";

    @Override
    public List<Usuario> findAll() {return executeQuery(SELECT_JOIN);}

    @Override
    public Optional<Usuario> findById(Long id) {
        return executeQueryOne(SELECT_JOIN+" WHERE u.id_usuario = ?", id);
    }

    public Optional<Usuario> findByUsuarioAndClave(String usuario, String clave) {
        return executeQueryOne(SELECT_JOIN + "WHERE u.usuario = ? AND u.clave = ?",
                usuario,
                clave
        );
    }

    @Override
    protected Usuario insert(Connection conn, Usuario u) throws SQLException {
        long id=executeInsertGetKey(conn, "insert into upeu_usuario(usuario,clave,estado,id_perfil) values (?,?,?,?)",
                u.getUsuario(),
                u.getClave(),
                u.getEstado(),
                u.getIdPerfil()!=null?u.getIdPerfil().getIdPerfil():null
        );
        u.setIdUsuario(id);
        return u;
    }

    @Override
    protected Usuario updateRow(Connection conn, Usuario u) throws SQLException {
        executeUpdate(conn, "UPDATE upeu_usuario SET usuario=?,clave=?,estado=?, id_perfil=? WHERE id_usuario=?",
        u.getUsuario(),
        u.getClave(),
        u.getEstado(),
        u.getIdPerfil().getIdPerfil(),
                u.getIdUsuario()
        );
        return u;
    }

    @Override
    protected Usuario mapRow(ResultSet rs) throws SQLException {
       return Usuario.builder()
                .idUsuario(rs.getLong("id_usuario"))
                .usuario(rs.getString("usuario"))
                .clave(rs.getString("clave"))
                .estado(rs.getString("estado"))
                .idPerfil(Perfil.builder()
                        .idPerfil(rs.getLong("id_perfil"))
                        .nombre(rs.getString("perfil_nombre"))
                        .codigo(rs.getString("perfil_codigo"))
                        .build())
                .build();
    }
}
