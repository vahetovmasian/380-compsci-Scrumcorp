import java.sql.Timestamp;

public class User {
    private int userId;
    private String username;
    private String email;
    private Timestamp dateCreated;

    public User(int userId, String username, String email, Timestamp dateCreated) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.dateCreated = dateCreated;
    }

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public Timestamp getDateCreated() { return dateCreated; }
}
