import java.io.*;
import java.util.Map;

public class orderService {
    private static final String ORDERS_FILE = "data/orders.txt";
    private static final String ORDER_ITEMS_FILE = "data/order_items.txt";

    public int createOrder(int userId, Map<Integer, Integer> cartItems, double total) throws IOException {
        int orderId = getNextOrderId();
        
        try (PrintWriter out = new PrintWriter(new FileWriter(ORDERS_FILE, true))) {
            out.printf("%d,%d,%.2f,%d%n",
                orderId, userId, total, System.currentTimeMillis());
        }
        
        try (PrintWriter out = new PrintWriter(new FileWriter(ORDER_ITEMS_FILE, true))) {
            for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
                out.printf("%d,%d,%d%n",
                    orderId,
                    entry.getKey(),
                    entry.getValue());
            }
        }
        
        return orderId;
    }

    private int getNextOrderId() throws IOException {
        int maxId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(ORDERS_FILE))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                int id = Integer.parseInt(line.split(",")[0]);
                if (id > maxId) maxId = id;
            }
        }
        return maxId + 1;
    }
}