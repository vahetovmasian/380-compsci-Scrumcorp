import java.io.*;
import java.sql.Timestamp;

public class paymentService {
    private static final String PAYMENTS_FILE = "data/payments.txt";
    private static final String SHIPPING_FILE = "data/shipping_info.txt";
    private static final String BILLING_FILE = "data/billing_info.txt";

    public boolean processPayment(int orderId, double amount, String paymentMethod,
            shippingInfo shippingInfo, billingInfo billingInfo, user customer) throws IOException {
        
        // Create data directory if it doesn't exist
        new File("data").mkdirs();
        
        int shippingId = saveShippingInfo(shippingInfo);
        int billingId = saveBillingInfo(billingInfo);

        // Write payment info
        try (PrintWriter out = new PrintWriter(new FileWriter(PAYMENTS_FILE, true))) {
            File file = new File(PAYMENTS_FILE);
            boolean writeHeader = !file.exists() || file.length() == 0;
            
            if (writeHeader) {
                out.println("PaymentID,OrderID,Amount,Method,Timestamp,ShippingID,BillingID");
            }
            out.println(String.format("%d,%d,%.2f,%s,%s,%d,%d",
                getNextPaymentId(), orderId, amount, paymentMethod,
                new Timestamp(System.currentTimeMillis()), shippingId, billingId));
        }

        emailService.sendConfirmationEmail(
            customer.getEmail(),
            shippingInfo.getFullName(),
            orderId
        );

        return true;
    }

    private int saveShippingInfo(shippingInfo info) throws IOException {
        int nextId = getNextId(SHIPPING_FILE);
        try (PrintWriter out = new PrintWriter(new FileWriter(SHIPPING_FILE, true))) {
            File file = new File(SHIPPING_FILE);
            boolean writeHeader = !file.exists() || file.length() == 0;
            
            if (writeHeader) {
                out.println("ShippingID,UserID,FullName,Address,City,State,ZipCode");
            }
            out.println(String.format("%d,%d,%s,%s,%s,%s,%s",
                nextId, info.getUserId(),
                info.getFullName(), info.getAddress(),
                info.getCity(), info.getState(), info.getZipCode()));
        }
        return nextId;
    }

    private int saveBillingInfo(billingInfo info) throws IOException {
        int nextId = getNextId(BILLING_FILE);
        try (PrintWriter out = new PrintWriter(new FileWriter(BILLING_FILE, true))) {
            File file = new File(BILLING_FILE);
            boolean writeHeader = !file.exists() || file.length() == 0;
            
            if (writeHeader) {
                out.println("BillingID,UserID,FullName,Address,City,State,ZipCode,CardNumber,CardExpiry,CardCVV");
            }
            out.println(String.format("%d,%d,%s,%s,%s,%s,%s,%s,%s,%s",
                nextId, info.getUserId(),
                info.getFullName(), info.getAddress(),
                info.getCity(), info.getState(), info.getZipCode(),
                info.getCardNumber(), info.getCardExpiry(), info.getCardCvv()));
        }
        return nextId;
    }

    private int getNextPaymentId() throws IOException {
        return getNextId(PAYMENTS_FILE);
    }

    private int getNextId(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists() || file.length() == 0) {
            return 1;
        }
        
        int maxId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Skip header
            String header = reader.readLine();
            if (header == null) return 1;
            
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                
                String[] parts = line.split(",");
                if (parts.length > 0 && !parts[0].isEmpty()) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        maxId = Math.max(maxId, id);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid ID in line: " + line);
                    }
                }
            }
        }
        return maxId + 1;
    }
}