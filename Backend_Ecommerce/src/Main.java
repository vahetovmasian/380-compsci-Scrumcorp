import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // === Step 1: Register or Authenticate a User ===
            AuthService authService = new AuthService();
            String username = "";
            String email = "";
            String password = "";

            // Register user (if needed)
            if (authService.registerUser(username, email, password)) {
                System.out.println(" User registered successfully.");
            } else {
                System.out.println(" User already exists or registration failed.");
            }

            // Authenticate user
            User user = authService.authenticate(email, password);
            if (user == null) {
                System.out.println(" Login failed.");
                return;
            }
            System.out.println(" Logged in as: " + user.getUsername());

            int userId = user.getUserId();

            // === Step 2: Add products to cart ===
            ProductService productService = new ProductService();
            CartService cartService = new CartService();

          
            cartService.addItem(); 

            System.out.println("\n Cart Contents:");
            for (Map.Entry<Integer, Integer> entry : cartService.getItems().entrySet()) {
                Product p = productService.getProductById(entry.getKey());
                System.out.printf("- %s by %s (Qty: %d, Price: $%.2f each)%n",
                        p.getTitle(), p.getArtist(), entry.getValue(), p.getPrice());
            }

            double total = cartService.getTotal(productService);
            System.out.printf(" Total: $%.2f%n", total);

            // === Step 3: Place Order ===
            OrderService orderService = new OrderService();
            int orderId = orderService.createOrder(userId, cartService.getItems());
            System.out.println(" Order placed! Order ID: " + orderId);

            // === Step 4: Simulate Payment ===
            BillingInfo billingInfo = new BillingInfo(
                    userId,
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""
            );

            ShippingInfo shippingInfo = new ShippingInfo(
                    userId,
                    "",
                    "",
                    "",
                    "",
                    ""
            );

            boolean paymentSuccess = PaymentService.processPayment(userId, orderId, "Credit Card", total, billingInfo, shippingInfo);

            if (paymentSuccess) {
                System.out.println(" Payment processed successfully!");
            } else {
                System.out.println(" Payment failed.");
            }

        } catch (Exception e) {
            System.err.println(" Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
