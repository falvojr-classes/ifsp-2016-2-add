package br.edu.ifsp.add.controller;

import br.edu.ifsp.add.dao.ContatoDao;
import br.edu.ifsp.add.dao.IContatoDao;
import java.util.List;

import br.edu.ifsp.add.model.Contato;

/**
 * Controlador negocial para a entidade {@link Contato}. Essa classe implementa
 * os padrões Singleton e Strategy.
 *
 * @author Venilton FalvoJr
 *
 * @since 31/08/2016
 */
public class ContatoController implements IContatoController {

    private static ContatoController instancia;

    public static ContatoController getInstancia() {
        if (ContatoController.instancia == null) {
            ContatoController.instancia = new ContatoController();
        }
        return ContatoController.instancia;
    }

    private ContatoController() {
        super();
    }

    private final IContatoDao contatoDao = ContatoDao.getInstancia();

    @Override
    public void salvar(Contato entidade) {
        // FIXME Chamada ao método INSERIR ou ALTERAR do DAO
    }

    @Override
    public void deletar(Contato entidade) {
        // FIXME Chamada ao método DELETAR do DAO.
    }

    @Override
    public List<Contato> listar() {
        // FIXME Chamada ao método LISTAR do DAO.
        return null;
    }

}
