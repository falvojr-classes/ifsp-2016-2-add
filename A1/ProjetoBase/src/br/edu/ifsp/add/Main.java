package br.edu.ifsp.add;

import br.edu.ifsp.add.dao.ConnectionManager;
import br.edu.ifsp.add.dao.PermissaoDao;
import br.edu.ifsp.add.dao.UsuarioDao;
import br.edu.ifsp.add.model.Permissao;
import br.edu.ifsp.add.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe de testes.
 *
 * @author Venilton FalvoJr
 *
 * @since 11/10/2016
 */
public class Main {

    public static void main(String[] args) {
        // Lista as pemissões.
        List<Permissao> permissoes = PermissaoDao.getInstancia().listar();
        // Percorre as Permissões listadas, criando um usuário para cada uma.
        for (Permissao permissao : permissoes) {
            // Instancia um Usuário
            Usuario usuario = new Usuario();
            usuario.setEmail(permissao.getDescricao() + "@ifsp.edu.br");
            usuario.setSenha("123456");
            usuario.setPermissao(permissao);
            // Insere um Usuário.
            UsuarioDao.getInstancia().inserir(usuario);
            // Inativa a instância do Usuário em questão.
            usuario.setAtivo(false);
            // Altera o Usuário em questão no banco de dados.
            UsuarioDao.getInstancia().alterar(usuario);
        }
        // Busca a quantidade de Usuários administradores.
        Long qtd = UsuarioDao.getInstancia().contarAdministradoresAtivos();
        System.out.println(qtd);

        try {
            // Inicia uma transação
            ConnectionManager.getInstancia().getConexao().setAutoCommit(false);

            // TODO Fazer quantas operações você quiser aqui...
            
            // Commita a transação, ou seja, efetiva as operações realizadas 
            // entre os métodos "setAutoCommit(false)" e commit().
            ConnectionManager.getInstancia().getConexao().commit();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
