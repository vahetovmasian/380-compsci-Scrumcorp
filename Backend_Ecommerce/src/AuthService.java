import java.sql.*;
import org.mindrot.jbcrypt.BCrypt; //password encryption for storing in DB

public class AuthService {
    public User authenticate(String usernameOrEmail, String password) throws SQLException { //authenticates user based on email or ID, throws exception if db issues occur
        String sql = "SELECT user_id, username, email, user_password, date_created FROM users WHERE username = ? OR email = ?"; //retrieves user info given email or ID

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usernameOrEmail); // next 2 lines fill in placeholder in sql query
            stmt.setString(2, usernameOrEmail);
            ResultSet rs = stmt.executeQuery(); //executes query and stores matching row from table

            if (rs.next() && BCrypt.checkpw(password, rs.getString("user_password"))) { //checks if theres a match, checks if password is correct
                return new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getTimestamp("date_created")
                );
            }
        }
        return null; //authentification failed, no existing user or wrong passcode
    }

    public boolean registerUser(String username, String email, String password) throws SQLException { //registers a new user, "creates account"
        // Check if the email already exists
        if (isEmailRegistered(email)) {
            System.out.println("Email is already registered."); //returns message if email exists
            return false;
        }

        String sql = "INSERT INTO users (username, email, user_password) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, hashedPassword);

            return stmt.executeUpdate() > 0;
        }
    }

    private boolean isEmailRegistered(String email) throws SQLException { //helper method, checks if email is already used 
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // If count > 0, the email is already registered
            }
        }
        return false;
    }
}