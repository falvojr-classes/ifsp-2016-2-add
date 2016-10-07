package br.edu.ifsp.add;

import br.edu.ifsp.add.dao.ContatoDao;
import br.edu.ifsp.add.dao.IContatoDao;
import br.edu.ifsp.add.model.Contato;
import java.util.Calendar;
import java.util.List;

/**
 * Classe de testes da entidade Contato.
 *
 * @author Venilton FalvoJr
 *
 * @since 20/09/2016
 */
public class MainContato {

    public static void main(String[] args) {
        Contato contatoInserir = new Contato();
        contatoInserir.setEmail("teste@jdbc.sql.java");
        contatoInserir.setTelefone("(16) 99999-9999");
        contatoInserir.setDataNascimento(Calendar.getInstance());

        IContatoDao dao = ContatoDao.getInstancia();

        // Inserção
        for (int i = 1; i < 10; i++) {
            contatoInserir.setNome("Contato " + i);
            dao.inserir(contatoInserir);
        }

        // Listagem
        List<Contato> contatos = dao.listar();
        for (Contato contato : contatos) {
            System.out.println(contato.getNome());
        }

        // Alteração
        for (Contato contato : contatos) {
            contato.setNome("Nome Alterado");
            dao.alterar(contato);
        }

        List<String> nomes = dao.listarNomesPorCep("14835-001");
        if (nomes.isEmpty()) {
            System.out.println("Nenhum contato encontrado!");
        } else {
            for (String nome : nomes) {
                System.out.println(nome);
            }
        }
        
        // Exclusão
        // TODO: Considerar exclusão com relação de chave estrangeira.
        // for (Contato contato : contatos) {
        //   dao.deletar(contato);
        // }
    }

}
