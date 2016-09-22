package br.edu.ifsp.add.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe base para os DAO's.
 *
 * @author Venilton FalvoJr
 */
public class BaseDao {

    protected Connection getConexao() {
        return ConnectionManager.getInstancia().getConexao();
    }

    protected Long getChaveGerada(PreparedStatement statement) throws SQLException {
        ResultSet rs = statement.getGeneratedKeys();
        rs.next();
        return rs.getLong(1);
    }
}
