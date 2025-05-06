import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() throws SQLException { //connects to db using jdbc
        String url = "jdbc:mysql://myecommercedb.cx260wiy6cmj.us-east-2.rds.amazonaws.com:3306/myecommercedb";
        String user = "admin";
        String pass = "scrumcorp";
        return DriverManager.getConnection(url, user, pass);
    }
}
