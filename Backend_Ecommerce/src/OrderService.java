import java.sql.*;
import java.util.Map;

public class OrderService {
    private ProductService productService = new ProductService();

    public int createOrder(int userId, Map<Integer, Integer> cartItems) throws SQLException { //creates an order ID, enters order and order items into db 
        Connection conn = null;
        try {
            conn = Database.getConnection(); 
            conn.setAutoCommit(false);

            double total = calculateTotal(cartItems); 
            int orderId = insertOrder(conn, userId, total); 
            insertOrderItems(conn, orderId, cartItems); 

            conn.commit();
            return orderId;
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
    }

    private int insertOrder(Connection conn, int userId, double total) throws SQLException { //inserts into order table in DB, helper method
        String sql = "INSERT INTO orders (user_id, total) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, userId);
            stmt.setDouble(2, total);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
                throw new SQLException("Order creation failed");
            }
        }
    }

    private void insertOrderItems(Connection conn, int orderId, Map<Integer, Integer> cartItems) throws SQLException { //inserts into order items table in DB, helper method 
        String sql = "INSERT INTO order_items (order_id, product_num, quantity, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
                Product product = productService.getProductById(entry.getKey());
                if (product != null) {
                    stmt.setInt(1, orderId);
                    stmt.setInt(2, product.getProductNum());
                    stmt.setInt(3, entry.getValue());
                    stmt.setDouble(4, product.getPrice());
                    stmt.addBatch();
                }
            }
            stmt.executeBatch();
        }
    }

    private double calculateTotal(Map<Integer, Integer> cartItems) { //calculates order total, helper method
        double total = 0.0;
        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
            Product product = productService.getProductById(entry.getKey());
            if (product != null) {
                total += product.getPrice() * entry.getValue();
            }
        }
        return total;
    }
}
