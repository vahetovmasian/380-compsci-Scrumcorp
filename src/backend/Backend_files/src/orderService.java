import java.io.*;
import java.util.Map;
import java.sql.Timestamp;

public class orderService {
    private static final String ORDERS_FILE = "data/orders.txt";
    private static final String ORDER_ITEMS_FILE = "data/order_items.txt";
    private static final String ORDERS_HEADER = "OrderID,UserID,Total,Timestamp";
    private static final String ORDER_ITEMS_HEADER = "OrderID,ProductID,Quantity";

    public int createOrder(int userId, Map<Integer, Integer> cartItems, double total) throws IOException {
        validateInput(userId, cartItems, total);
        
        // Create data directory if it doesn't exist
        new File("data").mkdirs();
        
        int orderId = getNextOrderId();
        
        // Write order
        writeOrder(orderId, userId, total);
        
        // Write order items
        writeOrderItems(orderId, cartItems);
        
        return orderId;
    }

    private void validateInput(int userId, Map<Integer, Integer> cartItems, double total) {
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        if (cartItems == null || cartItems.isEmpty()) {
            throw new IllegalArgumentException("Cart cannot be empty");
        }
        if (total <= 0) {
            throw new IllegalArgumentException("Total must be positive");
        }
        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
            if (entry.getKey() <= 0 || entry.getValue() <= 0) {
                throw new IllegalArgumentException("Invalid product ID or quantity");
            }
        }
    }

    private void writeOrder(int orderId, int userId, double total) throws IOException {
        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
        String orderData = String.format("%d,%d,%.2f,%s", orderId, userId, total, timestamp);
        writeWithHeader(ORDERS_FILE, ORDERS_HEADER, orderData);
    }

    private void writeOrderItems(int orderId, Map<Integer, Integer> cartItems) throws IOException {
        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
            String itemData = String.format("%d,%d,%d", orderId, entry.getKey(), entry.getValue());
            writeWithHeader(ORDER_ITEMS_FILE, ORDER_ITEMS_HEADER, itemData);
        }
    }

    private int getNextOrderId() throws IOException {
        return getMaxId(ORDERS_FILE) + 1;
    }

    private int getMaxId(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists() || file.length() == 0) {
            return 0;
        }
        
        int maxId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Skip header if exists
            String line = reader.readLine();
            if (line == null || line.equals(ORDERS_HEADER)) {
                line = reader.readLine();
            }
            
            while (line != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length > 0) {
                        try {
                            int id = Integer.parseInt(parts[0].trim());
                            maxId = Math.max(maxId, id);
                        } catch (NumberFormatException e) {
                            System.err.println("Warning: Invalid ID in line - " + line);
                        }
                    }
                }
                line = reader.readLine();
            }
        }
        return maxId;
    }

    private void writeWithHeader(String filename, String header, String data) throws IOException {
        File file = new File(filename);
        boolean writeHeader = !file.exists() || file.length() == 0;
        
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            if (writeHeader) {
                out.println(header);
            }
            out.println(data);
        }
    }
}