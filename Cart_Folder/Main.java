import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Step 1: Initialize services
            ProductService productService = new ProductService();
            CartService cartService = new CartService();
            OrderService orderService = new OrderService();

            // Step 2: Display products
            System.out.println("Available Products:");
            List<Product> products = productService.getAllProducts();
            for (Product p : products) {
                System.out.println(p); // Uses Product's toString()
            }

            // Step 3: Simulate adding to cart
            System.out.println("\nAdding products to cart...");
            cartService.addToCart(1, 2); // e.g. 2 units of product #1
            cartService.addToCart(2, 1); // e.g. 1 unit of product #2

            // Step 4: Display cart contents
            System.out.println("\nCart Contents:");
            Map<Integer, Integer> cartItems = cartService.getCartItems();
            for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
                int productNum = entry.getKey();
                int quantity = entry.getValue();
                Product product = productService.getAllProducts().stream()
                        .filter(p -> p.getProductNum() == productNum)
                        .findFirst().orElse(null);

                if (product != null) {
                    System.out.printf("- %s x%d ($%.2f each)%n", 
                        product.getTitle(), quantity, product.getPrice());
                }
            }

            // Step 5: Calculate total
            BigDecimal total = cartService.calculateTotal(productService);
            System.out.println("\nTotal: $" + total);

            // Step 6: Create the order
            int userId = 1; // Simulated user ID
            int orderId = orderService.createOrder(userId, cartItems);
            System.out.println("Order created successfully with ID: " + orderId);

            // Step 7: Simulate payment
            String paymentMethod = "Credit Card"; // Simulated payment method
            boolean paymentSuccess = PaymentService.processPayment(orderId, paymentMethod, total);

            if (paymentSuccess) {
                System.out.println("Payment successful!");
            } else {
                System.out.println("Payment failed.");
            }

            // Step 8: Clear cart
            cartService.clearCart();
            System.out.println("Cart cleared.");

        } catch (Exception e) {
            System.err.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
