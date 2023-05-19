package be.kdg.integration2.take5.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Leaderboard {

    private static Connection connection;
    private static Statement statement;
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
            String insertQuery = "INSERT INTO players (id, name) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, player.getId());
            preparedStatement.setString(2, player.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int getPlayerID(String playerName) {
        try {
            String query = "SELECT id FROM players WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, playerName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                System.out.printf("User %s not found.%n", playerName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}

