import java.sql.*;
import java.math.BigDecimal;

public class PaymentService {
    public static boolean processPayment(int orderId, String paymentMethod, BigDecimal amount) {
        String sql = "INSERT INTO payments (order_id, payment_method, amount, payment_date) " +
                     "VALUES (?, ?, ?, NOW())";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, orderId);
            stmt.setString(2, paymentMethod);
            stmt.setBigDecimal(3, amount);
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Payment processing failed: " + e.getMessage());
            return false;
        }
    }
}