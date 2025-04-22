import java.sql.*;
import java.util.Map;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private ProductService productService;

    public OrderService() {
        this.productService = new ProductService();
    }

    public int createOrder(int userId, Map<Integer, Integer> cartItems) throws SQLException {
        Connection conn = null;
        try {
            conn = Database.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // Calculate total
            BigDecimal total = calculateOrderTotal(cartItems);

            // 1. Create order
            int orderId = createOrderRecord(conn, userId, total);

            // 2. Add order items
            addOrderItems(conn, orderId, cartItems);

            conn.commit();
            return orderId;
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
    }

    private BigDecimal calculateOrderTotal(Map<Integer, Integer> cartItems) {
        List<Product> products = productService.getAllProducts();
        return cartItems.entrySet().stream()
            .map(entry -> {
                Product p = products.stream()
                    .filter(prod -> prod.getProductNum() == entry.getKey())
                    .findFirst()
                    .orElse(null);
                return p != null ? p.getPrice().multiply(BigDecimal.valueOf(entry.getValue())) : BigDecimal.ZERO;
            })
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private int createOrderRecord(Connection conn, int userId, BigDecimal total) throws SQLException {
        String sql = "INSERT INTO orders (user_id, total) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, userId);
            stmt.setBigDecimal(2, total);
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        throw new SQLException("Failed to create order");
    }

    private void addOrderItems(Connection conn, int orderId, Map<Integer, Integer> cartItems) throws SQLException {
        String sql = "INSERT INTO order_items (order_id, product_num, quantity, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            List<Product> products = productService.getAllProducts();
            
            for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
                Product p = products.stream()
                    .filter(prod -> prod.getProductNum() == entry.getKey())
                    .findFirst()
                    .orElse(null);
                
                if (p != null) {
                    stmt.setInt(1, orderId);
                    stmt.setInt(2, p.getProductNum());
                    stmt.setInt(3, entry.getValue());
                    stmt.setBigDecimal(4, p.getPrice());
                    stmt.addBatch();
                }
            }
            stmt.executeBatch();
        }
    }
}