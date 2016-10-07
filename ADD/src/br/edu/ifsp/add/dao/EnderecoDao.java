package br.edu.ifsp.add.dao;

import br.edu.ifsp.add.model.Contato;
import br.edu.ifsp.add.model.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Classe de persistência para a entidade Endereco. Essa classe implementa os
 * padrões Singleton e Strategy.
 *
 * @author Venilton FalvoJr
 *
 * @since 21/09/2016
 */
public class EnderecoDao extends BaseDao implements IEnderecoDao {

    @Override
    public void inserir(Endereco entidade) {
        String sql = "INSERT INTO enderecos (logradouro, numero, complemento, cep, id_contato) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, entidade.getLogradouro());
            stmt.setString(2, entidade.getNumero());
            stmt.setString(3, entidade.getComplemento());
            stmt.setString(4, entidade.getCep());
            stmt.setLong(5, entidade.getContato().getId());
            stmt.execute();

            entidade.setId(super.getChaveGerada(stmt));

            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Endereco entidade) {
        String sql = "UPDATE enderecos SET logradouro=?, numero=?, complemento=?, cep=?, id_contato=? WHERE id=?";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql);
            stmt.setString(1, entidade.getLogradouro());
            stmt.setString(2, entidade.getNumero());
            stmt.setString(3, entidade.getComplemento());
            stmt.setString(4, entidade.getCep());
            stmt.setLong(5, entidade.getContato().getId());
            stmt.setLong(6, entidade.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Endereco entidade) {
        String sql = "DELETE FROM enderecos WHERE id=?";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql);
            stmt.setLong(1, entidade.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Endereco> listar() {
        List<Endereco> enderecos = new ArrayList<>();
        String sql = "SELECT c.id id_contato, c.nome, c.email, "
                + "c.telefone, c.data_nascimento, e.id id_endereco, "
                + "e.logradouro, e.numero, e.complemento, e.cep "
                + "FROM contatos c JOIN enderecos e ON c.id = e.id_contato";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //Cria o Endereco:
                Endereco endereco = new Endereco();
                endereco.setId(rs.getLong("id_endereco"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCep(rs.getString("cep"));

                //Criar o Contato:
                Contato contato = new Contato();
                contato.setId(rs.getLong("id_contato"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setTelefone(rs.getString("telefone"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(rs.getDate("data_nascimento").getTime());
                contato.setDataNascimento(calendar);

                //Relaciona Endereço e Contato:
                endereco.setContato(contato);

                //Adiciona na lista de retorno:
                enderecos.add(endereco);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enderecos;
    }

}
