import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        ProductService productService = new ProductService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Test database connection
            System.out.println("=== Music Store System ===");
            System.out.println("Loading products...\n");
            
            // Display all products
            displayProducts(productService);
            
            // Main menu loop
            while (true) {
                System.out.println("\n=== MAIN MENU ===");
                System.out.println("1. View Products");
                System.out.println("2. Add to Cart");
                System.out.println("3. View Cart");
                System.out.println("4. Checkout");
                System.out.println("5. Exit");
                System.out.print("Select option: ");
                
                int choice = getIntInput(scanner);
                
                switch (choice) {
                    case 1:
                        displayProducts(productService);
                        break;
                    case 2:
                        addToCart(scanner, productService, cartService);
                        break;
                    case 3:
                        viewCart(cartService, productService);
                        break;
                    case 4:
                        checkout(scanner, cartService, orderService, productService);
                        break;
                    case 5:
                        System.out.println("Exiting system. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("System error: " + e.getMessage());
        }
    }

    // Helper Methods
    private static void displayProducts(ProductService productService) {
        System.out.println("\n=== AVAILABLE PRODUCTS ===");
        System.out.printf("%-5s %-30s %-20s %-10s %-8s %-15s\n", 
                         "ID", "Title", "Artist", "Genre", "Price", "Media Type");
        
        productService.getAllProducts().forEach(p -> 
            System.out.printf("%-5d %-30s %-20s %-10s $%-7.2f %-15s\n",
                p.getProductNum(),
                p.getTitle(),
                p.getArtist(),
                p.getGenre(),
                p.getPrice(),
                p.getMediaType())
        );
    }

    private static void addToCart(Scanner scanner, ProductService productService, CartService cartService) {
        System.out.print("Enter product ID: ");
        int productId = getIntInput(scanner);
        
        System.out.print("Enter quantity: ");
        int quantity = getIntInput(scanner);
        
        cartService.addToCart(productId, quantity);
        System.out.println("Item added to cart!");
    }

    private static void viewCart(CartService cartService, ProductService productService) {
        Map<Integer, Integer> cart = cartService.getCartItems();
        
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }
        
        System.out.println("\n=== YOUR CART ===");
        System.out.printf("%-3s %-30s %-10s %-8s %-10s\n", 
                         "Qty", "Product", "Artist", "Price", "Subtotal");
        
        BigDecimal total = BigDecimal.ZERO;
        
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
            Product p = productService.getAllProducts().stream()
                .filter(prod -> prod.getProductNum() == entry.getKey())
                .findFirst()
                .orElse(null);
                
            if (p != null) {
                BigDecimal subtotal = p.getPrice().multiply(BigDecimal.valueOf(entry.getValue()));
                total = total.add(subtotal);
                
                System.out.printf("%-3d %-30s %-10s $%-7.2f $%-7.2f\n",
                    entry.getValue(),
                    p.getTitle(),
                    p.getArtist(),
                    p.getPrice(),
                    subtotal);
            }
        }
        
        System.out.println("\nTOTAL: $" + total);
    }

    private static void checkout(Scanner scanner, CartService cartService, 
                               OrderService orderService, ProductService productService) {
        if (cartService.getCartItems().isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }
        
        System.out.print("Enter your user ID: ");
        int userId = getIntInput(scanner);
        
        try {
            // Create order
            int orderId = orderService.createOrder(userId, cartService.getCartItems());
            System.out.println("Order #" + orderId + " created successfully!");
            
            // Process payment
            BigDecimal total = cartService.calculateTotal(productService);
            boolean paymentSuccess = PaymentService.processPayment(
                orderId, 
                "Credit Card", 
                total
            );
            
            if (paymentSuccess) {
                System.out.println("Payment processed successfully!");
                cartService.clearCart();
            } else {
                System.out.println("Payment failed. Please try again.");
            }
        } catch (SQLException e) {
            System.out.println("Checkout error: " + e.getMessage());
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
}