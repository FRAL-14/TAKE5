import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    public database() {
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/Take_5";
        String username = "postgres";
        String password = "Aleksandra_1234";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM players");

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("Player ID: " + id + ", Name: " + name);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

    }
}

