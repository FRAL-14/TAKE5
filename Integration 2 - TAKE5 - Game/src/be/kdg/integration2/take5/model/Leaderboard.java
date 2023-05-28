package be.kdg.integration2.take5.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leaderboard {

    public static void writeToDatabase(String userName) {

        String url = "jdbc:postgresql://localhost/Take_5_pt2";
        String user = "postgres";
        String password = "Aleksandra_1234";

        String name = userName;

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            con.setAutoCommit(false); // Start a transaction

            // Insert into players table
            String playerInsertQuery = "INSERT INTO players(name) VALUES(?)";
            try (PreparedStatement playerStatement = con.prepareStatement(playerInsertQuery)) {
                playerStatement.setString(1, name);
                playerStatement.executeUpdate();
            }

            // Insert into games table with the current date
            String gameInsertQuery = "INSERT INTO games(date_played, winner) VALUES(?, ?)";
            try (PreparedStatement gameStatement = con.prepareStatement(gameInsertQuery)) {
                gameStatement.setObject(1, LocalDate.now());
                gameStatement.setInt(2, 1); // Provide an integer value for the winner column
                gameStatement.executeUpdate();
            }



            con.commit(); // Commit the transaction

            System.out.println("Record inserted successfully into players and games tables.");

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Leaderboard.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}



