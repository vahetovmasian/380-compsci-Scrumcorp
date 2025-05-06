import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize services
            authService auth = new authService();
            productService productService = new productService();
            cartService cart = new cartService();
            orderService orderService = new orderService();
            paymentService paymentService = new paymentService();

            // 1. Register and login
            System.out.println("[1] Registering test user...");
            boolean registered = auth.registerUser("testuser", "test@email.com", "password123");
            System.out.println("Registration " + (registered ? "successful" : "failed"));
            
            user user = auth.authenticate("testuser", "password123");
            if (user == null) {
                System.out.println("Login failed!");
                return;
            }
            System.out.println("Logged in as: " + user.getUsername() + " (ID: " + user.getUserId() + ")");

            // 2. Load and display products
            System.out.println("\n[2] Loading products...");
            List<products> products = productService.getAllProducts();
            for (products p : products) {
                System.out.printf("%d. %s by %s - $%.2f [%s]%n",
                    p.getProductNum(), p.getTitle(), p.getArtist(), 
                    p.getPrice(), p.getMediaType());
            }

            // 3. Cart operations
            System.out.println("\n[3] Adding items to cart...");
            
            cart.addItem(1, 1); // 1x Cowboy Carter Vinyl
            cart.addItem(3, 2); // 2x If I Know Me Vinyl
            
            System.out.println("\nCurrent Cart:");
            for (Map.Entry<Integer, Integer> item : cart.getItems().entrySet()) {
                products p = productService.getProductById(item.getKey());
                if (p != null) {
                    System.out.printf(" - %s [%s] x %d = $%.2f%n",
                        p.getTitle(), p.getMediaType(), 
                        item.getValue(), p.getPrice() * item.getValue());
                } else {
                    System.out.printf(" - [Product ID %d not found] x %d%n",
                        item.getKey(), item.getValue());
                }
            }
            System.out.printf("Total: $%.2f%n", cart.getTotal(productService));

            // 4. Checkout process
            System.out.println("\n[4] Creating order...");
            double total = cart.getTotal(productService);
            int orderId = orderService.createOrder(user.getUserId(), cart.getItems(), total);
            System.out.println("Order created! ID: " + orderId);

            // 5. Payment processing
            System.out.println("\n[5] Processing payment...");
            shippingInfo shipping = new shippingInfo(
                0,                  // shippingId (0 for new)
                user.getUserId(),   // userId
                "name",        // fullName
                "address",      // address
                "city",          // city
                "CA",               // state
                "12345"             // zipCode
            );

            billingInfo billing = new billingInfo(
                0,                  // billingId (0 for new)
                user.getUserId(),   // userId
                "name",        // fullName
                "adress",      // address
                "city",          // city
                "CA",               // state
                "12345",            // zipCode
                "1111111111111111", // cardNumber
                "01/01",            // cardExpiry
                "123"               // cardCvv
            );
            
            boolean paymentSuccess = paymentService.processPayment(
                orderId, total, "CREDIT_CARD", shipping, billing);
            System.out.println("Payment " + (paymentSuccess ? "succeeded" : "failed"));

            System.out.println("\nDone!");
            
        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}