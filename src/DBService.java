import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBService {
    private DatabaseConnection dbConnection;

    public DBService() {
        this.dbConnection = new DatabaseConnection();
    }

    public boolean checkCredentials(User user) {
        try (Connection connection = dbConnection.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT id FROM users WHERE username = ? AND password = ?")) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            dbConnection.close();
        }
    }


    
}

