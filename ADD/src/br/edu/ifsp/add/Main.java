package br.edu.ifsp.add;

import br.edu.ifsp.add.dao.ContatoDao;
import br.edu.ifsp.add.dao.IContatoDao;
import br.edu.ifsp.add.model.Contato;
import java.util.Calendar;

/**
 * Classe de testes.
 *
 * @author falvojr
 */
public class Main {

    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setNome("Teste JDBC");
        contato.setEmail("teste@jdbc.sql.java");
        contato.setTelefone("(16) 99999-9999");
        contato.setDataNascimento(Calendar.getInstance());
        
        IContatoDao dao = ContatoDao.getInstancia();
        dao.inserir(contato);
    }

}
