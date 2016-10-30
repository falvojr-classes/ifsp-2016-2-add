package br.edu.ifsp.add.dao;

import br.edu.ifsp.add.model.Permissao;
import java.util.List;

/**
 * Strategy utilizada pelo PermissaoDao.
 *
 * @author Venilton FalvoJr
 *
 * @since 11/10/2016
 */
public interface IPermissaoDao {

    public List<Permissao> listar();
}
