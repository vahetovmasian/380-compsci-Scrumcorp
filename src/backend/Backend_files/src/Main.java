import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            productService productService = new productService();
            cartService cart = new cartService();
            orderService orderService = new orderService();
            paymentService paymentService = new paymentService();

            // 1. Register and login
            System.out.println("[1] Registering test user...");
            boolean registered = authService.registerUser(
                "sarah",
                "sarah.hermida.306@my.csun.edu", 
                "123"
            );
            System.out.println("Registration " + (registered ? "successful" : "failed"));

            user user = authService.authenticate("sarah", "123");
            if (user == null) {
                System.out.println("Login failed!");
                return;
            }
            System.out.println("Logged in as: " + user.getUsername() +
                               " (ID: " + user.getUserId() + ")\n");

            // 2. Load and display products
            System.out.println("[2] Available products:");
            List<products> products = productService.getAllProducts();
            for (products p : products) {
                System.out.printf("  %d. %s by %s - $%.2f [%s]%n",
                    p.getProductNum(),
                    p.getTitle(),
                    p.getArtist(),
                    p.getPrice(),
                    p.getMediaType()
                );
            }

            // 3. Cart operations
            System.out.println("\n[3] Adding items to cart...");
            cart.addItem(5, 1); 
            cart.addItem(18, 2); 
            cart.addItem(7,3);

            System.out.println("\nCurrent Cart:");
            for (Map.Entry<Integer, Integer> item : cart.getItems().entrySet()) {
                products p = productService.getProductById(item.getKey());
                if (p != null) {
                    System.out.printf("  - %s [%s] x %d = $%.2f%n",
                        p.getTitle(),
                        p.getMediaType(),
                        item.getValue(),
                        p.getPrice() * item.getValue()
                    );
                } else {
                    System.out.printf("  - [Product ID %d not found] x %d%n",
                        item.getKey(), item.getValue());
                }
            }
            System.out.printf("Total: $%.2f%n", cart.getTotal(productService));

            // 4. Create order
            System.out.println("\n[4] Creating order...");
            double total = cart.getTotal(productService);
            int orderId = orderService.createOrder(
                user.getUserId(),
                cart.getItems(),
                total
            );
            System.out.println("Order created! ID: " + orderId);

            // 5. Process payment & send email
            System.out.println("\n[5] Processing payment...");
            shippingInfo shipping = new shippingInfo(
                0,
                user.getUserId(),
                "sarah",
                "address",
                "Los Angeles",
                "CA",
                "90032"
            );
            billingInfo billing = new billingInfo(
                0,
                user.getUserId(),
                "sarah",
                "address",
                "Los Angeles",
                "CA",
                "90032",
                "4111111111111111",
                "12/25",
                "123"
            );

            boolean paymentSuccess = paymentService.processPayment(
                orderId,
                total,
                "CREDIT_CARD",
                shipping,
                billing,
                user
            );
            System.out.println("Payment " + (paymentSuccess ? "succeeded" : "failed"));

            System.out.println("\nDone!");
        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}