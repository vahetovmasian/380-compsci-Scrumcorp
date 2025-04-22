import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://myecommercedb.cx260wiy6cmj.us-east-2.rds.amazonaws.com:3306/myecommercedb";
    private static final String USER = "admin";
    private static final String PASS = "scrumcorp";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}