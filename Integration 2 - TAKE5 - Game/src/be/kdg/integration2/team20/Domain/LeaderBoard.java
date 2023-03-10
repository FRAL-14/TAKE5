package be.kdg.integration2.team20.Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeaderBoard {
    public LeaderBoard() {
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/Take_5";
        String username = "postgres";
        String password = "Aleksandra_1234";

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

