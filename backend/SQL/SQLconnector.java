package backend.SQL;
import java.sql.*;
/**
 * Need to figure out how to actually set this up cleanly still bad code 
 */


/**
 * Class handles setting up a SQL connection 
 * @author vahet
 *
 */
public class SQLconnector {
	
		/**
		 * currently all the code is in a constructor due to it not being refactored
		 * and just being a test 
		 */
		public SQLconnector() {
	        String url = "myecommercedb.cx260wiy6cmj.us-east-2.rds.amazonaws.com"; // Database details
	        String username = "admin"; // MySQL credentials
	        String password = "scrumcorp";
	        String query = "SHOW DATABASES;";
	
	        // Load and register the driver
	        try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	
	        // Establish connection
	        Connection con = DriverManager.getConnection(url, username, password);
	        System.out.println("Connection Established successfully");
	
	        // Create a statement
	        Statement st = con.createStatement();
	
	        // Execute the query
	        ResultSet rs = st.executeQuery(query);
	
	        // Process the results
	        while (rs.next()) {
	            String name = rs.getString("name"); // Retrieve name from db
	            System.out.println(name); // Print result on console
	        }
	
	        // Close the statement and connection
	        st.close();
	        con.close();
	        System.out.println("Connection Closed....");
	        }
	        catch(Exception e) {
	        	System.out.print("Connection Failed");
	        }
		}
    
}
