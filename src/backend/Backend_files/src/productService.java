import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class productService {
    private static final String PRODUCTS_FILE = "data/products.txt";
    private List<products> productCache;

    public products getProductById(int productId) throws IOException {
        if (productCache == null) loadProducts();
        for (products p : productCache) {
            if (p.getProductNum() == productId) return p;
        }
        return null;
    }

    public List<products> getAllProducts() throws IOException {
        if (productCache == null) loadProducts();
        return new ArrayList<>(productCache);
    }

    private void loadProducts() throws IOException {
        productCache = new ArrayList<>();
        File file = new File(PRODUCTS_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCTS_FILE))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length == 7) {
                    productCache.add(new products(
                        Integer.parseInt(parts[5].trim()),  // ProductNum
                        parts[0].trim(),                    // Title
                        parts[1].trim(),                    // Artist
                        parts[2].trim(),                    // Genre
                        Double.parseDouble(parts[3].trim()),// Price
                        Integer.parseInt(parts[4].trim()),  // ReleaseYear
                        parts[6].trim()                     // MediaType
                    ));
                }
            }
        }
    }
}