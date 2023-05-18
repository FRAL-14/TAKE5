package be.kdg.integration2.take5.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Leaderboard {

    private static Connection connection;
    private static Statement statement;
    private ResultSet resultSet;
    private String url = "jdbc:postgresql://10.134.178.20:5432/game";
    private String username = "game";
    private String password = "7sur7";

    public Leaderboard() {

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void addPlayer(Player player) {
        try {
            String query = "INSERT INTO players (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, player.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int getPlayerID(String player_name) {
        try {
            String query = "SELECT id FROM players WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, player_name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                System.out.printf("User %s not found.%n", player_name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }







}
