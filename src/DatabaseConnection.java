import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://217.24.203.175:3306/tobi";
    private static final String USERNAME = "ftit";
    private static final String PASSWORD = "ftit";

    private Connection connection;

    public DatabaseConnection() {
        this.connection = connect();
    }

    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Verbindung fehlgeschlagen
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

