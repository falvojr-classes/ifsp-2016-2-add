package br.edu.ifsp.add.dao;

import br.edu.ifsp.add.model.Permissao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de persistência para a entidade Permissao. 
 * Essa classe implementa os padrões Singleton e Strategy.
 *
 * @author Venilton FalvoJr
 *
 * @since 11/10/2016
 */
public class PermissaoDao extends BaseDao implements IPermissaoDao {

    private static PermissaoDao instancia;

    public static PermissaoDao getInstancia() {
        if (PermissaoDao.instancia == null) {
            PermissaoDao.instancia = new PermissaoDao();
        }
        return PermissaoDao.instancia;
    }

    private PermissaoDao() {
        super();
    }

    @Override
    public List<Permissao> listar() {
        List<Permissao> permissoes = new ArrayList<>();
        String sql = "select * from permissao";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //Cria o Permissão:
                Permissao permissao = new Permissao();
                permissao.setId(rs.getLong("id"));
                permissao.setDescricao(rs.getString("descricao"));

                //Adiciona na lista de retorno:
                permissoes.add(permissao);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return permissoes;
    }

}
