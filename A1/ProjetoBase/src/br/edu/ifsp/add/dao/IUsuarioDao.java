package br.edu.ifsp.add.dao;

import br.edu.ifsp.add.model.Usuario;
import java.sql.SQLException;

/**
 * Strategy utilizada pelo UsuarioDao.
 *
 * @author Venilton FalvoJr
 *
 * @since 11/10/2016
 */
public interface IUsuarioDao {

    public void inserir(Usuario usuario) throws SQLException;
    
    public void alterar(Usuario usuario);
    
    public Long contarAdministradoresAtivos();
    
    public boolean autenticar(Usuario usuario) throws SQLException;
}
