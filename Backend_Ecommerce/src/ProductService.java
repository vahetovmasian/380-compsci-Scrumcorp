import java.sql.*;

public class ProductService {
    public Product getProductById(int productId) { //returns the product and attributes using the product number
        String sql = "SELECT * FROM products WHERE product_num = ?"; //sql query to return product from db

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery(); //executes 

            if (rs.next()) {
                return new Product( //returns product info 
                    rs.getInt("product_num"),
                    rs.getString("title"),
                    rs.getString("artist"),
                    rs.getString("genre"),
                    rs.getDouble("price"),
                    rs.getInt("release_year"),
                    rs.getString("media_type"),
                    rs.getInt("stock_quantity"),
                    rs.getString("image_url")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error fetching product: " + e.getMessage());
        }
        return null;
    }
}
