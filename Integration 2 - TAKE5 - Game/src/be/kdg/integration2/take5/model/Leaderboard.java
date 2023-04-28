package be.kdg.integration2.take5.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Leaderboard {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private String url = "jdbc:postgresql://localhost:5432/Take_5_pt2";
    private String username = "postgres";
    private String password = "";

    public Leaderboard(){

        try{
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            createTables();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void createTables() {

    }


}