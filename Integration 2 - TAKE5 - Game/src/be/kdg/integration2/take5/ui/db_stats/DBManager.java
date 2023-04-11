package be.kdg.integration2.take5.ui.db_stats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost/Take_5_pt2";
    private static final String USER = "postgres";
    private static final String PASS = "Aleksandra_1234";

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}

