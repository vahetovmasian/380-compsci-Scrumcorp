import java.io.*;

public class paymentService {
    private static final String PAYMENTS_FILE = "data/payments.txt";
    private static final String SHIPPING_FILE = "data/shipping_info.txt";
    private static final String BILLING_FILE = "data/billing_info.txt";

    public boolean processPayment(int orderId, double amount, String paymentMethod,
                                shippingInfo shippingInfo, billingInfo billingInfo) throws IOException {
        int shippingId = saveShippingInfo(shippingInfo);
        int billingId = saveBillingInfo(billingInfo);
        
        try (PrintWriter out = new PrintWriter(new FileWriter(PAYMENTS_FILE, true))) {
            out.printf("%d,%d,%.2f,%s,%d,%d,%d%n",
                getNextPaymentId(),
                orderId,
                amount,
                paymentMethod,
                System.currentTimeMillis(),
                shippingId,
                billingId);
            return true;
        }
    }

    private int saveShippingInfo(shippingInfo info) throws IOException {
        int shippingId = getNextId(SHIPPING_FILE);
        try (PrintWriter out = new PrintWriter(new FileWriter(SHIPPING_FILE, true))) {
            out.printf("%d,%d,%s,%s,%s,%s,%s%n",
                shippingId,
                info.getUserId(),
                info.getFullName(),
                info.getAddress(),
                info.getCity(),
                info.getState(),
                info.getZipCode());
        }
        return shippingId;
    }

    private int saveBillingInfo(billingInfo info) throws IOException {
        int billingId = getNextId(BILLING_FILE);
        try (PrintWriter out = new PrintWriter(new FileWriter(BILLING_FILE, true))) {
            out.printf("%d,%d,%s,%s,%s,%s,%s,%s,%s,%s%n",
                billingId,
                info.getUserId(),
                info.getFullName(),
                info.getAddress(),
                info.getCity(),
                info.getState(),
                info.getZipCode(),
                info.getCardNumber(),
                info.getCardExpiry(),
                info.getCardCvv());
        }
        return billingId;
    }

    private int getNextPaymentId() throws IOException {
        return getNextId(PAYMENTS_FILE);
    }

    private int getNextId(String filename) throws IOException {
        int maxId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
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