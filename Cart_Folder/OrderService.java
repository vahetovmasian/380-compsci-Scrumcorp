import java.sql.*;
import java.util.Map;
import java.math.BigDecimal;
import java.util.List;

public class OrderService {
    private ProductService productService;

    public OrderService() {
        this.productService = new ProductService(); // Create instance of ProductService
    }

    public int createOrder(int userId, Map<Integer, Integer> cartItems) throws SQLException {
        Connection conn = null;
        try {
            conn = Database.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // 1. Calculate the total using the adapted logic
            BigDecimal total = calculateTotal(cartItems, productService);

            // 2. Create order record in database
            int orderId = createOrderRecord(conn, userId, total);

            // 3. Add each item in the cart to order_items table
            addOrderItems(conn, orderId, cartItems);

            conn.commit(); // If everything worked, commit the transaction
            return orderId;
        } catch (SQLException e) {
            if (conn != null) conn.rollback(); // Rollback if anything failed
            throw e;
        } finally {
            if (conn != null) conn.close(); // Close DB connection
        }
    }

    // Reused logic from CartService to calculate the total
    private BigDecimal calculateTotal(Map<Integer, Integer> cartItems, ProductService productService) {
        BigDecimal total = BigDecimal.ZERO;
        List<Product> allProducts = productService.getAllProducts(); // List of all available products

        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
            int productNum = entry.getKey();
            int quantity = entry.getValue();

            Product product = findProductById(allProducts, productNum); // Look for the product in the list

            if (product != null) {
                BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(quantity));
                total = total.add(itemTotal); // Add item total to grand total
            }
        }

        return total;
    }

    // Helper to find a product by its number
    private Product findProductById(List<Product> products, int productNum) {
        for (Product product : products) {
            if (product.getProductNum() == productNum) {
                return product;
            }
        }
        return null; // Product not found
    }

    // Creates the actual order record in the orders table
    private int createOrderRecord(Connection conn, int userId, BigDecimal total) throws SQLException {
        String sql = "INSERT INTO orders (user_id, total) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, userId);
            stmt.setBigDecimal(2, total);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // Return the generated order ID
                }
            }
        }
        throw new SQLException("Failed to create order"); // If no ID was returned
    }

    // Adds all cart items to order_items table
    private void addOrderItems(Connection conn, int orderId, Map<Integer, Integer> cartItems) throws SQLException {
        String sql = "INSERT INTO order_items (order_id, product_num, quantity, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            List<Product> allProducts = productService.getAllProducts();

            for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
                int productNum = entry.getKey();
                int quantity = entry.getValue();

                Product product = findProductById(allProducts, productNum);
                if (product != null) {
                    stmt.setInt(1, orderId);
                    stmt.setInt(2, product.getProductNum());
                    stmt.setInt(3, quantity);
                    stmt.setBigDecimal(4, product.getPrice());
                    stmt.addBatch(); // Queue up the insert
                }
            }

            stmt.executeBatch(); // Execute all inserts at once
        }
    }
}
