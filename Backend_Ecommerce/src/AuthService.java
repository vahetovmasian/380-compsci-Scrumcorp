import java.sql.*;

public class AuthService {
    public User authenticate(String usernameOrEmail, String password) throws SQLException {
        String sql = "SELECT user_id, username, email, user_password, date_created FROM users WHERE username = ? OR email = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usernameOrEmail);
            stmt.setString(2, usernameOrEmail);
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && password.equals(rs.getString("user_password"))) {  
                return new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getTimestamp("date_created")
                );
            }
        }
        return null; // Authentication failed
    }

    public boolean registerUser(String username, String email, String password) throws SQLException {
        // Check if the email already exists
        if (isEmailRegistered(email)) {
            System.out.println("Email is already registered.");
            return false;
        }

        String sql = "INSERT INTO users (username, email, user_password) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Store plaintext password instead of hashed
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);  // Storing plaintext password

            return stmt.executeUpdate() > 0;
        }
    }

    private boolean isEmailRegistered(String email) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}