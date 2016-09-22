package br.edu.ifsp.add.dao;

import br.edu.ifsp.add.model.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de persistência para a entidade {@link Endereco}. Essa classe
 * implementa os padrões Singleton e Strategy.
 *
 * @author Venilton FalvoJr
 *
 * @since 21/09/2016
 */
public class EnderecoDao extends BaseDao implements IEnderecoDao {
    
    @Override
    public void inserir(Endereco entidade) { 
        String sql = "INSERT INTO enderecos (logradouro, numero, complemento, cep) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, entidade.getLogradouro());
            stmt.setString(2, entidade.getNumero());
            stmt.setString(3, entidade.getComplemento());
            stmt.setString(4, entidade.getCep());
            stmt.execute();
            
            entidade.setId(super.getChaveGerada(stmt));
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Endereco entidade) {
        String sql = "UPDATE enderecos SET logradouro=?, numero=?, complemento=?, cep=? WHERE id=?";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql);
            stmt.setString(1, entidade.getLogradouro());
            stmt.setString(2, entidade.getNumero());
            stmt.setString(3, entidade.getComplemento());
            stmt.setString(4, entidade.getCep());
            stmt.setLong(5, entidade.getId());
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
        List<Endereco> enderecos = new ArrayList<Endereco>();
        String sql = "SELECT * FROM enderecos";
        try {
            PreparedStatement stmt = super.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
               Endereco endereco = new Endereco();
               endereco.setId(rs.getLong("id"));
               endereco.setLogradouro(rs.getString("logradouro"));
               endereco.setNumero(rs.getString("numero"));
               endereco.setComplemento(rs.getString("complemento"));
               endereco.setCep(rs.getString("cep"));
               
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
