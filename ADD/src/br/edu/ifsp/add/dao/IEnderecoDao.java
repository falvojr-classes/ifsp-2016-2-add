package br.edu.ifsp.add.dao;

import br.edu.ifsp.add.model.Endereco;
import java.util.List;

/**
 * Strategy utilizada pelo EnderecoDao.
 *
 * @author Venilton FalvoJr
 *
 * @since 21/09/2016
 */
public interface IEnderecoDao {

    public void inserir(Endereco entidade);

    public void alterar(Endereco entidade);

    public void deletar(Endereco entidade);

    public List<Endereco> listar();
}
