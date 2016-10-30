package br.edu.ifsp.add.dao;

import br.edu.ifsp.add.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe de persistência para a entidade Usuario. 
 * Essa classe implementa os padrões Singleton e Strategy.
 *
 * @author Venilton FalvoJr
 *
 * @since 11/10/2016
 */
public class UsuarioDao extends BaseDao implements IUsuarioDao {

    private static UsuarioDao instancia;

    public static UsuarioDao getInstancia() {
        if (UsuarioDao.instancia == null) {
            UsuarioDao.instancia = new UsuarioDao();
        }
        return UsuarioDao.instancia;
    }

    private UsuarioDao() {
        super();
    }

    @Override
    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario (email, senha, ativo, id_permissao) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.setBoolean(3, usuario.isAtivo());
            stmt.setLong(4, usuario.getPermissao().getId());
            stmt.execute();

            usuario.setId(super.getChaveGerada(stmt));

            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Usuario usuario) {
        String sql = "UPDATE usuario SET email=?, senha=?, ativo=?, id_permissao=? WHERE id=?";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.setBoolean(3, usuario.isAtivo());
            stmt.setLong(4, usuario.getPermissao().getId());
            stmt.setLong(5, usuario.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long contarAdministradoresAtivos() {
        Long retorno = 0L;
        String sql = "select count(*) quantidade from usuario u " +
            "inner join permissao p on u.id_permissao = p.id " +
            "where p.id = 1 and u.ativo = 1";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            retorno = rs.getLong("quantidade");
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return retorno;
    }

}
