import java.sql.*;
import java.math.BigDecimal;

public class PaymentService {
    public static boolean processPayment(int orderId, String paymentMethod, BigDecimal amount) {
        String sql = "INSERT INTO payments (order_id, payment_method, amount, payment_date) " + //enters info into payments table in db
                     "VALUES (?, ?, ?, NOW())";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, orderId);           // next 3 lines fill in the sql query 
            stmt.setString(2, paymentMethod);
            stmt.setBigDecimal(3, amount);
            
            return stmt.executeUpdate() > 0; //runs query, if successful returns a positive num
        } catch (SQLException e) { //code in case of error 
            System.err.println("Payment processing failed: " + e.getMessage()); //error message 
            return false;
        }
    }
}