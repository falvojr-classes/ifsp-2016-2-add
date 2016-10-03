package br.edu.ifsp.add;

import br.edu.ifsp.add.dao.EnderecoDao;
import br.edu.ifsp.add.dao.IEnderecoDao;
import br.edu.ifsp.add.model.Endereco;
import java.util.List;

/**
 * Classe de testes da entidade Endereco.
 *
 * @author falvojr
 */
public class MainEndereco {

    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Teste 1");
        endereco.setNumero("104A");
        endereco.setComplemento(null);
        endereco.setCep("14.835-000");
        
        IEnderecoDao dao = new EnderecoDao();
        
        dao.inserir(endereco);
        
        endereco.setLogradouro("Alterado!");
        
        dao.alterar(endereco);
        
        List<Endereco> enderecos = dao.listar();
        
        dao.deletar(endereco);
    }

}
