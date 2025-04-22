import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CartService {
    // Maps productNum -> quantity
    private Map<Integer, Integer> cartItems = new HashMap<>();

    // Adds new item or if existing, updates quantity in cart
    public void addToCart(int productNum, int quantity) {
        if (cartItems.containsKey(productNum)) { 
            // Update existing quantity
            int currentQty = cartItems.get(productNum);
            cartItems.put(productNum, currentQty + quantity);
        } else {
            // Add new product
            cartItems.put(productNum, quantity);
        }
    }

    // Returns a safe copy of cart items
    public Map<Integer, Integer> getCartItems() {
        return new HashMap<>(cartItems); // Defensive copy
    }

    // Calculates total cart value
    public BigDecimal calculateTotal(ProductService productService) {
        BigDecimal total = BigDecimal.ZERO; //starts total from 0
        List<Product> allProducts = productService.getAllProducts(); //list of all products
        
        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) { //iterates through cart items
            int productNum = entry.getKey(); 
            int quantity = entry.getValue();
            
            // Find product by ID 
            Product product = findProductById(allProducts, productNum); //searches product list for the product using product number
            
            if (product != null) { // checks if product exists
                BigDecimal itemTotal = product.getPrice()
                    .multiply(BigDecimal.valueOf(quantity)); //multiplies quantity by price to get item total
                total = total.add(itemTotal); //adds item total to total
            }
        }
        return total;
    }

    // Helper method to find product by ID
    private Product findProductById(List<Product> products, int productNum) {
        for (Product product : products) {
            if (product.getProductNum() == productNum) {
                return product;
            }
        }
        return null; // Not found
    }

    // Clears the cart
    public void clearCart() {
        cartItems.clear();
    }
}