import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/PlungerSchool"; // Update with your database URL
    private static final String USER = "postgres"; // Update with your database username
    private static final String PASSWORD = "Godisawesome@21"; // Update with your database password

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = connectToDatabase();
            if (connection != null) {
                System.out.println("Connected to the database successfully!");
                // Perform database operations here
            }
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close the connection: " + e.getMessage());
                }
            }
        }
    }

    public static Connection connectToDatabase() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
