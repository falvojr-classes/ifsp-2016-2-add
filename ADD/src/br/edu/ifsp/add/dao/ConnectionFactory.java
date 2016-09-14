package br.edu.ifsp.add.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que representa nossa frabrica de conexões, caracterizada pelo método
 * getConnection(). Essa classe implementa o padrão Factory usando Singleton.
 *
 * @author C1279147 Venilton FalvoJr
 *
 * @since 31/08/2016
 */
public class ConnectionFactory {

    private static ConnectionFactory instancia;

    public static ConnectionFactory getInstancia() {
        if (ConnectionFactory.instancia == null) {
            ConnectionFactory.instancia = new ConnectionFactory();
        }
        return ConnectionFactory.instancia;
    }

    private ConnectionFactory() {
        super();
    }

    /**
     * Fábrica de conexões, isto é, ele cria novas conexões para nós. Basta
     * invocar o método e recebemos uma conexão pronta para uso, não importando
     * de onde elas vieram e eventuais detalhes de criação.
     *
     * @return conexão do tipo {@link Connection}.
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
