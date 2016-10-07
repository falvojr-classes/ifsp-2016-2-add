package br.edu.ifsp.add;

import br.edu.ifsp.add.dao.ContatoDao;
import br.edu.ifsp.add.dao.EnderecoDao;
import br.edu.ifsp.add.dao.IEnderecoDao;
import br.edu.ifsp.add.model.Contato;
import br.edu.ifsp.add.model.Endereco;
import java.util.Calendar;
import java.util.List;

/**
 * Classe de testes da entidade Endereco.
 *
 * @author falvojr
 */
public class MainEndereco {

    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setNome("Venilton");
        contato.setEmail("venilton.junior@ifsp.edu.br");
        contato.setTelefone("16 99721-8281");
        contato.setDataNascimento(Calendar.getInstance());
        
        ContatoDao.getInstancia().inserir(contato);
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Salvador Bruno");
        endereco.setNumero("415");
        endereco.setComplemento(null);
        endereco.setCep("14.835-000");
        endereco.setContato(contato);
        
        IEnderecoDao dao = new EnderecoDao();
        
        dao.inserir(endereco);
        
        endereco.setLogradouro("Nova Rua");
        
        dao.alterar(endereco);
        
        List<Endereco> enderecos = dao.listar();
        for (Endereco enderecoListado : enderecos) {
            System.out.println(enderecoListado.getContato().getNome());
            System.out.println(enderecoListado.getLogradouro());
        }
        
        dao.deletar(endereco);
    }

}
