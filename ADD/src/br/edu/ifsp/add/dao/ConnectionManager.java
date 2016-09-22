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
public final class ConnectionManager {

    private static ConnectionManager instancia;

    public static ConnectionManager getInstancia() {
        if (ConnectionManager.instancia == null) {
            ConnectionManager.instancia = new ConnectionManager();
        }
        return ConnectionManager.instancia;
    }

    private ConnectionManager() {
        super();
        this.conexao = this.newConnection();
    }

    private final Connection conexao;
    
    public Connection getConexao() {
        return this.conexao;
    }
    
    /**
     * Fábrica de conexões, isto é, ele cria novas conexões para nós. Basta
     * invocar o método e recebemos uma conexão pronta para uso, não importando
     * de onde elas vieram e eventuais detalhes de criação.
     *
     * @return conexão do tipo {@link Connection}.
     */
    private Connection newConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
