public class Product {
    private int productNum;
    private String title;
    private String artist;
    private String genre;
    private double price;
    private int releaseYear;
    private String mediaType;
    private int stockQuantity;
    private String imageUrl;

    public Product(int productNum, String title, String artist, String genre, double price, int releaseYear, String mediaType, int stockQuantity, String imageUrl) {
        this.productNum = productNum;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.price = price;
        this.releaseYear = releaseYear;
        this.mediaType = mediaType;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
    }

    public int getProductNum() { return productNum; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public double getPrice() { return price; }
    public int getReleaseYear() { return releaseYear; }
    public String getMediaType() { return mediaType; }
    public int getStockQuantity() { return stockQuantity; }
    public String getImageUrl() { return imageUrl; }
}
