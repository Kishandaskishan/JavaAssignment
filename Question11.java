package in.neuron.ai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question11 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/database_name";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");

            String sql = "SELECT * FROM table_name";
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                System.out.println("Table Data:");

                while (resultSet.next()) {
                    String column1Value = resultSet.getString("column1");
                    int column2Value = resultSet.getInt(2);
                    System.out.println("Column1: " + column1Value + ", Column2: " + column2Value);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
