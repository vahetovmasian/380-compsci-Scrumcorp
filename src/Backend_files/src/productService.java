import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class productService {
    private static final String PRODUCTS_FILE = "data/products.txt";
    private List<products> productCache;

    public products getProductById(int productId) throws IOException {
        if (productCache == null) {
            loadProducts();
        }
        
        for (products p : productCache) {
            if (p.getProductNum() == productId) {
                return p;
            }
        }
        return null;
    }

    public List<products> getAllProducts() throws IOException {
        if (productCache == null) {
            loadProducts();
        }
        return new ArrayList<>(productCache);
    }

    private void loadProducts() throws IOException {
        productCache = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCTS_FILE))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    productCache.add(new products(
                        Integer.parseInt(parts[5].trim()),
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        Double.parseDouble(parts[3].trim()),
                        Integer.parseInt(parts[4].trim()),
                        parts[6].trim()
                    ));
                }
            }
        }
    }
}