  /* Class that repersents a Product it is composed of:
     year:      a int to represent the year the product came out
     title:     a string to hold the products title
     price:     a int that holds the products price to purchase
     artist:    a string that holds the name(s) of the artist(s) who made the product
     trackList: an array of strings that has all the songs on the product
     mediaType: a string that holds the name of what type of media EX(CD,Vinyl,Cassette

     This Class will have methods that include:
     Getters for each attribute 
     Mabye more added in future 
  */ 
public class Product {
    String title;
    String genre;
    double price;
    int releaseYear;
    String artist;
    int productNum;
    String mediaType;
    String[] track;

    public Product(String title, String genre, double price, int releaseYear, String artist, int productNum, String mediaType, String[] track) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.productNum = productNum;
        this.mediaType = mediaType;
        this.track = track;
    }
    //Standard getter methods 
   public String getTitle(){
        return title;
    }
   public String getGenre(){
        return genre;
    }
    public double getPrice(){
        return price;
    }
    public int getReleaseYear(){
        return releaseYear;
    }
    public String getArtist(){
        return artist;
    }
    public int getProductNum(){
        return productNum;
    }
    public String getMediaType(){
        return mediaType;
    }
    public String[] getTrack(){
        return track;
    }
}
}
