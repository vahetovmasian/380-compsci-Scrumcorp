import java.math.BigDecimal;

public class Product {
    private int productNum;
    private String title;
    private String artist;
    private String genre;
    private BigDecimal price;
    private Integer releaseYear;
    private String mediaType;
    private String imageUrl;

    // Constructor with all fields
    public Product(int productNum, String title, String artist, String genre, 
                 BigDecimal price, Integer releaseYear, String mediaType, String imageUrl) {
        this.productNum = productNum;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.price = price;
        this.releaseYear = releaseYear;
        this.mediaType = mediaType;
        this.imageUrl = imageUrl;
    }

    // Getters
    public int getProductNum() { return productNum; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public BigDecimal getPrice() { return price; }
    public Integer getReleaseYear() { return releaseYear; }
    public String getMediaType() { return mediaType; }
    public String getImageUrl() { return imageUrl; }

    // Setters (optional - include if you need mutability)
    public void setProductNum(int productNum) { this.productNum = productNum; }
    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
    public void setMediaType(String mediaType) { this.mediaType = mediaType; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    @Override
    public String toString() {
        return String.format(
            "Product #%d: %s by %s (%s, %d) - $%.2f [%s] %s",
            productNum, title, artist, genre, releaseYear, price, mediaType,
            (imageUrl != null ? "[Image Available]" : "")
        );
    }
}