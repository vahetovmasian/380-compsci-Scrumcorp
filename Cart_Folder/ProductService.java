import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_num, title, artist, genre, price, " +
                    "release_year, media_type, image_url FROM products";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product(
                    rs.getInt("product_num"),
                    rs.getString("title"),
                    rs.getString("artist"),
                    rs.getString("genre"),
                    rs.getBigDecimal("price"),
                    rs.getObject("release_year", Integer.class),
                    rs.getString("media_type"),
                    rs.getString("image_url")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
        return products;
    }
}