/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.jdbc;

import config.ConfigManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.repository.exception.RepositoryException;

/**
 * The DBManager class is a singleton that manages the connection to the
 * database
 */
public class DBManager {

    private Connection connection;

    private final String url;

    private DBManager() {
        url = ConfigManager.getInstance().getProperties("db.url");
    }

    /**
     * It returns a connection to the database
     * 
     * @return A connection to the database.
     */
    public Connection getConnection() throws RepositoryException {
        String jdbcUrl = "jdbc:sqlite:" + url;
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(jdbcUrl);
            } catch (SQLException ex) {
                throw new RepositoryException("Connexion impossible: " + ex.getMessage());
            }
        }
        return connection;
    }

    /**
     * Create at the first time call a single instance of the class.
     * And return it
     * 
     * @return instance of DBManager
     */
    public static DBManager getInstance() {
        return DBManagerHolder.INSTANCE;
    }

    private static class DBManagerHolder {
        private static DBManager INSTANCE = new DBManager();
    }

}
