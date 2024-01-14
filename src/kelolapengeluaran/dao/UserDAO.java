package kelolapengeluaran.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class UserDAO {
    private final Connection connection;
    
    public UserDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean verifyUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean registerUser(String username, String password, String nama) {
        try {
            String query = "INSERT INTO users (username, password, nama) VALUES (?, ?, ?)";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, nama);
                
                int rowsAffected = statement.executeUpdate();
                
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
