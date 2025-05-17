import java.io.*;
import java.net.*;
import java.util.*;

public class emailService {
    private static final String API_KEY = "";
    private static final String DOMAIN = "sandbox2d4ee5d1a17049e9bc622f385989ff2c.mailgun.org";
    private static final String FROM_EMAIL = "postmaster@" + DOMAIN;
    private static productService productService = new productService();

    public static void sendConfirmationEmail(String toEmail, String toName, int orderId) {
        try {
            double total = readOrderTotal(orderId);
            Map<Integer, Integer> items = readOrderItems(orderId);
            
            StringBuilder body = new StringBuilder();
            body.append("Hey ").append(toName).append(",\n\n");
            body.append("Thanks for your order! Here's your receipt:\n\n");
            
            for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
                products product = productService.getProductById(entry.getKey());
                if (product != null) {
                    body.append(String.format("• %s by %s (%-5s) x%d @ $%.2f%n",
                        product.getTitle(),
                        product.getArtist(),
                        product.getMediaType(),
                        entry.getValue(),
                        product.getPrice()));
                } else {
                    body.append(String.format("• [Product ID %d] x%d%n", 
                        entry.getKey(), entry.getValue()));
                }
            }
            
            body.append(String.format("%nTotal: $%.2f%n", total));
            body.append("\nYour order will ship soon!\n");
            body.append("— ScrumCorp Team");

            postToMailgun(toEmail, "Order Confirmation #" + orderId, body.toString());
        } catch (Exception e) {
            System.err.println("Failed to send confirmation email: " + e.getMessage());
        }
    }

    private static double readOrderTotal(int orderId) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data/orders.txt"))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 4 && Integer.parseInt(fields[0].trim()) == orderId) {
                    return Double.parseDouble(fields[2].trim());
                }
            }
        }
        return 0.0;
    }

    private static Map<Integer, Integer> readOrderItems(int orderId) throws IOException {
        Map<Integer, Integer> items = new LinkedHashMap<>();
        File file = new File("data/order_items.txt");
        if (!file.exists()) return items;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                
                String[] fields = line.split(",");
                if (fields.length >= 3 && Integer.parseInt(fields[0].trim()) == orderId) {
                    int productId = Integer.parseInt(fields[1].trim());
                    int quantity = Integer.parseInt(fields[2].trim());
                    items.put(productId, items.getOrDefault(productId, 0) + quantity);
                }
            }
        }
        return items;
    }
    private static void postToMailgun(String to, String subject, String text) 
            throws IOException, URISyntaxException {
        URI uri = new URI("https://api.mailgun.net/v3/" + DOMAIN + "/messages");
        HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        // Basic authentication
        String auth = "api:" + API_KEY;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes("UTF-8"));
        conn.setRequestProperty("Authorization", "Basic " + encodedAuth);

        // Form parameters
        String data = "from=" + URLEncoder.encode(FROM_EMAIL, "UTF-8")
                   + "&to=" + URLEncoder.encode(to, "UTF-8")
                   + "&subject=" + URLEncoder.encode(subject, "UTF-8")
                   + "&text=" + URLEncoder.encode(text, "UTF-8");

        // Send request
        try (OutputStream os = conn.getOutputStream()) {
            os.write(data.getBytes("UTF-8"));
        }

        // Check response
        int status = conn.getResponseCode();
        if (status >= 400) {
            throw new IOException("Mailgun API error: " + status + " - " + conn.getResponseMessage());
        }
    }
}