public class products {
    private int productNum;
    private String title;
    private String artist;
    private String genre;
    private double price;
    private int releaseYear;
    private String mediaType;

    // Constructor matching your new data format
    public products(int productNum, String title, String artist, String genre,
                   double price, int releaseYear, String mediaType) {
        this.productNum = productNum;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.price = price;
        this.releaseYear = releaseYear;
        this.mediaType = mediaType;
    }

    // Getters
    public int getProductNum() { return productNum; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public double getPrice() { return price; }
    public int getReleaseYear() { return releaseYear; }
    public String getMediaType() { return mediaType; }

    
}