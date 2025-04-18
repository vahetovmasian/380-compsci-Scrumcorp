import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import db.SQLconnector;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = SQLconnector.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SHOW DATABASES");

            while (rs.next()) {
                System.out.println(rs.getString("Database"));
            }

            rs.close();
            st.close();
            conn.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            System.out.println("Failed to connect.");
            e.printStackTrace();
        }
    }
}
