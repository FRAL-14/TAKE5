//package be.kdg.integration2.take5.model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//    public class Leaderboard {
//        public Leaderboard() {
//        }
//
//        public static void main(String[] args) {
//            String url = "jdbc:postgresql://localhost/Take_5_pt2";
//            String username = "postgres";
//            String password = "Aleksandra_1234";
//
//            try {
//                Connection conn = DriverManager.getConnection(url, username, password);
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM players");
//
//                if (!rs.isBeforeFirst()) {
//                    System.out.println("No names found in players table.");
//                } else {
//                    while (rs.next()) {
//                        String name = rs.getString("name");
//                        System.out.println("Name: " + name);
//                    }
//                }
//
//                rs.close();
//                stmt.close();
//                conn.close();
//            } catch (SQLException var9) {
//                var9.printStackTrace();
//            }
//
//        }
//    }


