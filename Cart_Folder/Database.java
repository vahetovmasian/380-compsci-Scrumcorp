import java.sql.*;

public class Database { //connects to database using JDBC
    private static final String URL = "jdbc:mysql://myecommercedb.cx260wiy6cmj.us-east-2.rds.amazonaws.com:3306/myecommercedb"; //database address
    private static final String USER = "admin"; //username 
    private static final String PASS = "scrumcorp"; //password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}