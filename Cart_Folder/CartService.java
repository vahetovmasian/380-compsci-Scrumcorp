import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<Integer, Integer> cartItems = new HashMap<>(); // productNum -> quantity

    public void addToCart(int productNum, int quantity) {
        cartItems.merge(productNum, quantity, Integer::sum);
    }

    public Map<Integer, Integer> getCartItems() {
        return new HashMap<>(cartItems);
    }

    public BigDecimal calculateTotal(ProductService productService) {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
            Product p = productService.getAllProducts().stream()
                .filter(product -> product.getProductNum() == entry.getKey())
                .findFirst()
                .orElse(null);
            if (p != null) {
                total = total.add(p.getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
            }
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
    }
}