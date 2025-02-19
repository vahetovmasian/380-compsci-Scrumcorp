import java.awt.image.BufferedImage;

public class Product {
    String title;
    String genre;
    double price;
    int releaseYear;
    String[] artist;
    int productNum;
    String mediaType;
    String[] track;
    BufferedImage Image;
  
    public Product(String title, String genre, double price, int releaseYear, String[] artist, int productNum, String mediaType, String[] track, BufferedImage image) {
      this.title = title;
      this.genre = genre;
      this.price = price;
      this.releaseYear = releaseYear;
      this.artist = artist;
      this.productNum = productNum;
      this.mediaType = mediaType;
      this.track = track;
      this.image = image;
    }
  }
