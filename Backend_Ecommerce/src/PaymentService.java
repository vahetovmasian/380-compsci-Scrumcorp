import java.sql.*;

public class PaymentService {

    public static boolean processPayment(int userId, int orderId, String paymentMethod, double paymentAmount,
                                         BillingInfo billingInfo, ShippingInfo shippingInfo) {
        //insert billing and shipping information into their respective tables
        int billingId = insertBillingInfo(billingInfo);
        int shippingId = insertShippingInfo(shippingInfo);

        // insert the payment information, including references to the billing and shipping records
        String sql = "INSERT INTO payments (order_id, payment_method, payment_status, payment_amount, payment_date, billing_id, shipping_id) " +
                     "VALUES (?, ?, ?, ?, NOW(), ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set values for the payment
            stmt.setInt(1, orderId);
            stmt.setString(2, paymentMethod);
            stmt.setString(3, "Completed"); // Assuming successful payment
            stmt.setDouble(4, paymentAmount);
            stmt.setInt(5, billingId);  // Linking billing info
            stmt.setInt(6, shippingId); // Linking shipping info

            // Execute the query
            return stmt.executeUpdate() > 0; // If update is successful, return true
        } catch (SQLException e) {
            System.err.println("Payment failed: " + e.getMessage());
            return false;  // In case of an error, return false
        }
    }

    private static int insertBillingInfo(BillingInfo billingInfo) { //insert billing info and get billing ID
        String sql = "INSERT INTO billing_info (user_id, full_name, address, city, state, zip_code, card_number, card_expiry, card_cvv) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, billingInfo.getUserId());
            stmt.setString(2, billingInfo.getFullName());
            stmt.setString(3, billingInfo.getAddress());
            stmt.setString(4, billingInfo.getCity());
            stmt.setString(5, billingInfo.getState());
            stmt.setString(6, billingInfo.getZipCode());
            stmt.setString(7, billingInfo.getCardNumber());
            stmt.setString(8, billingInfo.getCardExpiry());
            stmt.setString(9, billingInfo.getCardCvv());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);  // Return the generated billing_id
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting billing info: " + e.getMessage());
        }

        return -1;  // Return -1 if insertion fails
    }
    private static int insertShippingInfo(ShippingInfo shippingInfo) { //insert shipping info and get shipping ID
        String sql = "INSERT INTO shipping_info (user_id, full_name, address, city, state, zip_code) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, shippingInfo.getUserId());
            stmt.setString(2, shippingInfo.getFullName());
            stmt.setString(3, shippingInfo.getAddress());
            stmt.setString(4, shippingInfo.getCity());
            stmt.setString(5, shippingInfo.getState());
            stmt.setString(6, shippingInfo.getZipCode());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);  // Return the generated shipping_id
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting shipping info: " + e.getMessage());
        }

        return -1;  // Return -1 if insertion fails
    }
}
