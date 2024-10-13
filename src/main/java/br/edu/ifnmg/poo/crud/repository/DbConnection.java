package br.edu.ifnmg.poo.crud.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class DbConnection
 *
 * @author AnaLuizanc
 * @author T1T1R3
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

    /**
     * Establishes and generates database connection retention
     *
     * @return Dabatase connection
     */
    public static Connection getConnection() {

        if (connection == null) {
            try {
                System.out.println("Connected");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "System stopped because there is no RDBMS connection",  e);
                System.exit(-1);
            }
        }
        return connection;
    }
}
