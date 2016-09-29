package br.edu.ifsp.add.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifsp.add.model.Contato;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Classe de persistência para a entidade {@link Contato}. Essa classe
 * implementa os padrões Singleton e Strategy.
 *
 * @author Venilton FalvoJr
 *
 * @since 31/08/2016
 */
public class ContatoDao extends BaseDao implements IContatoDao {

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
    
    @Override
    public void inserir(Contato entidade) {
        String sql = "INSERT INTO contatos (nome, email, telefone, data_nascimento) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, entidade.getNome());
            stmt.setString(2, entidade.getEmail());
            stmt.setString(3, entidade.getTelefone());
            stmt.setDate(4, new Date(entidade.getDataNascimento().getTimeInMillis()));
            stmt.execute();
            
            entidade.setId(super.getChaveGerada(stmt));
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Contato entidade) {
        String sql = "UPDATE contatos SET nome=?, email=?, telefone=?, data_nascimento=? WHERE id=?";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql);
            stmt.setString(1, entidade.getNome());
            stmt.setString(2, entidade.getEmail());
            stmt.setString(3, entidade.getTelefone());
            stmt.setDate(4, new Date(entidade.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, entidade.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Contato entidade) {
        String sql = "DELETE FROM contatos WHERE id=?";
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
    public List<Contato> listar() {
        List<Contato> contatos = new ArrayList<Contato>();
        String sql = "SELECT * FROM contatos";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
               Contato contato = new Contato();
               contato.setId(rs.getLong("id"));
               contato.setNome(rs.getString("nome"));
               contato.setEmail(rs.getString("email")); 
               contato.setTelefone(rs.getString("telefone"));
               
               Calendar calendar = Calendar.getInstance();
               calendar.setTimeInMillis(rs.getDate("data_nascimento").getTime());
               contato.setDataNascimento(calendar);
               
               contatos.add(contato);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contatos;
    }

}


