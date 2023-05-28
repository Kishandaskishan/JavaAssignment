package in.neuron.ai;

import java.sql.*;

public class Question12 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/kishan";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            createTable(conn);
            insertRecord(conn, 1, "John Doe", 25);
            insertRecord(conn, 2, "Jane Smith", 30);

            System.out.println("Records in the table:");
            displayRecords(conn);

            updateRecord(conn, 2, "Jane Smith", 35);
            System.out.println("Updated records in the table:");
            displayRecords(conn);

            deleteRecord(conn, 1);
            System.out.println("Records after deletion:");
            displayRecords(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(50), age INT)";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully.");
        }
    }

    private static void insertRecord(Connection conn, int id, String name, int age) throws SQLException {
        String sql = "INSERT INTO users (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        }
    }

    private static void displayRecords(Connection conn) throws SQLException {
        String sql = "SELECT * FROM users";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        }
    }

    private static void updateRecord(Connection conn, int id, String name, int age) throws SQLException {
        String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Record updated successfully.");
        }
    }

    private static void deleteRecord(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Record deleted successfully.");
        }
    }
}
