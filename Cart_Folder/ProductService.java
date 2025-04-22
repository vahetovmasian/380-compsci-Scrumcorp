import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> getAllProducts() { //fetches products from db
        List<Product> products = new ArrayList<>(); //empty product list
        String sql = "SELECT product_num, title, artist, genre, price, " + //sql query to get products
                    "release_year, media_type, image_url FROM products";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) { //loops through resulting rows from query
                Product product = new Product( //converts row to a product object
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
        return products; //returns list
    }
}