import java.util.HashMap;
import java.util.Map;

public class cartService {
    private Map<Integer, Integer> cart = new HashMap<>(); // productId -> quantity

    public void addItem(int productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        cart.put(productId, cart.getOrDefault(productId, 0) + quantity);
    }

    public void removeItem(int productId) {
        cart.remove(productId);
    }

    public void updateQuantity(int productId, int newQuantity) {
        if (newQuantity <= 0) {
            removeItem(productId);
        } else {
            cart.put(productId, newQuantity);
        }
    }

    public Integer getQuantity(int productId) {
        return cart.get(productId);
    }

    public Map<Integer, Integer> getItems() {
        return new HashMap<>(cart);
    }

    public double getTotal(productService productService) {
        double total = 0.0;
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
            try {
                products product = productService.getProductById(entry.getKey());
                if (product != null) {
                    total += product.getPrice() * entry.getValue();
                }
            } catch (Exception e) {
                System.err.println("Error calculating total for product " + entry.getKey() + ": " + e.getMessage());
            }
        }
        return total;
    }

    public void clearCart() {
        cart.clear();
    }
}