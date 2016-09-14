package br.edu.ifsp.add.controller;

import java.util.List;

import br.edu.ifsp.add.model.Contato;

/**
 * Strategy utilizada pelo {@link ContatoController}.
 *
 * @author Venilton FalvoJr
 *
 * @since 31/08/2016
 */
public interface IContatoController {

    public void salvar(Contato entidade);

    public void deletar(Contato entidade);

    public List<Contato> listar();
}
