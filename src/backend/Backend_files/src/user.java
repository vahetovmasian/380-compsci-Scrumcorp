import java.sql.Timestamp;

public class user {
    private int userId;
    private String username;
    private String email;
    private String password;
    private Timestamp dateCreated;

    public user(int userId, String username, String email, String password, Timestamp dateCreated) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateCreated = dateCreated;
    }

    // Getters
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Timestamp getDateCreated() { return dateCreated; }
}