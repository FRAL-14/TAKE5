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

    private String url = "jdbc:postgresql://10.134.178.20:5432/game";
    private String username = "game";
    private String password = "7sur7";

    public Leaderboard(){

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM players");

            if (!rs.isBeforeFirst()) {
                System.out.println("No names found in players table.");
            } else {
                while (rs.next()) {
                    String name = rs.getString("name");
                    System.out.println("Name: " + name);
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

    }


}