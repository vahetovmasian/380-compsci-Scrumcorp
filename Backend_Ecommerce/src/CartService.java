import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<Integer, Integer> cart = new HashMap<>(); //product num -> quantity

    // Adds a product and its quantity to the cart
    public void addItem(int productId, int quantity) {
        cart.put(productId, cart.getOrDefault(productId, 0) + quantity);
    }

    // Removes a product from the cart
    public void removeItem(int productId) {
        cart.remove(productId);
    }

    // Returns the full cart with product IDs and quantities
    public Map<Integer, Integer> getItems() {
        return cart;
    }

    // Calculates the total price of all items in the cart
    public double getTotal(ProductService ps) {
        double total = 0.0; //sets total to 0
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) { //iterates through cart
            Product product = ps.getProductById(entry.getKey()); //finds product through ID using ProductService
            if (product != null) { //if product exists in db 
                total += product.getPrice() * entry.getValue(); //multiplies quantity by price and adds to total
            }
        }
        return total;
    }
}
