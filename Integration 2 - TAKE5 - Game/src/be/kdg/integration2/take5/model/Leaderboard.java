package be.kdg.integration2.take5.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leaderboard {

    public static void writeToDatabase(String userName) {

        String url = "jdbc:postgresql://localhost/Take_5_pt2";
        String user = "postgres";
        String password = "Aleksandra_1234";

        String name = userName;
//        String id = userID;


        String query = "INSERT INTO players(name) VALUES(?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, name);
//            pst.setString(2, id);
            pst.executeUpdate();
            System.out.println("Sucessfully created.");
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Leaderboard.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }
}

