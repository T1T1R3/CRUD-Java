package br.edu.ifnmg.poo.crud.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana
 */
public class DbConnection {

    private static Connection connection;
    public static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        URL = "jdbc:mysql://127.0.0.1:3306/" + Dao.DB
                + "?useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&serverTimezone=UTC"
                + "&autoReconnect=true";
        USER = "root";
        PASSWORD = "";
    }

    private DbConnection() {
    }

    public static Connection getConnection() {

        if (connection == null) {
            try {
                System.out.println(">> Connected");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return connection;
    }
}
