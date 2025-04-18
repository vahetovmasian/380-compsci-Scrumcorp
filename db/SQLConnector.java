package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLconnector {

    private static final String URL = "jdbc:mysql://myecommercedb.cx260wiy6cmj.us-east-2.rds.amazonaws.com:3306/myecommercedb";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "scrumcorp";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
