package br.edu.ifsp.add.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifsp.add.model.Contato;

/**
 * Classe de persistência para a entidade {@link Contato}. Essa classe
 * implementa os padrões Singleton e Strategy.
 *
 * @author Venilton FalvoJr
 *
 * @since 31/08/2016
 */
public class ContatoDao implements IContatoDao {

    private static ContatoDao instancia;

    public static ContatoDao getInstancia() {
        if (ContatoDao.instancia == null) {
            ContatoDao.instancia = new ContatoDao();
        }
        return ContatoDao.instancia;
    }

    private ContatoDao() {
        super();
    }

    private final Connection conexao = ConnectionFactory.getInstancia().getConnection();

    @Override
    public void inserir(Contato entidade) {
        String sql = "INSERT INTO contatos (nome, email, telefone, data_nascimento) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, entidade.getNome());
            stmt.setString(2, entidade.getEmail());
            stmt.setString(3, entidade.getTelefone());
            stmt.setDate(4, new Date(entidade.getDataNascimento().getTimeInMillis()));
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Contato entidade) {
        String sql = "UPDATE contatos SET nome=?, email=?, telefone=?, data_nascimento=? WHERE id=?";
        //FIXME: Executar o comando de UPDATE via JDBC.
    }

    @Override
    public void deletar(Contato entidade) {
        String sql = "DELETE FROM contatos WHERE id=?";
        //FIXME: Executar o comando de DELETE via JDBC.
    }

    @Override
    public List<Contato> listar() {
        String sql = "SELECT * FROM contatos";
        //TODO: Executar o comando de SELECT via JDBC e retornar os resultados.
        return null;
    }

}
