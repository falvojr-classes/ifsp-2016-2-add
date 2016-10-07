package br.edu.ifsp.add.dao;

import java.util.List;

import br.edu.ifsp.add.model.Contato;

/**
 * Strategy utilizada pelo ContatoDao.
 *
 * @author Venilton FalvoJr
 *
 * @since 31/08/2016
 */
public interface IContatoDao {

    public void inserir(Contato entidade);

    public void alterar(Contato entidade);

    public void deletar(Contato entidade);

    public List<Contato> listar();
    
    public List<String> listarNomes();
    
    public List<String> listarNomesPorCep(String cep);
}
