package backend;

  /**
   * 
 Class that repersents a Product it is composed of:
     year:      a int to represent the year the product came out
     title:     a string to hold the products title
     price:     a int that holds the products price to purchase
     artist:    a string that holds the name(s) of the artist(s) who made the product
     trackList: an array of strings that has all the songs on the product
     mediaType: a string that holds the name of what type of media EX(CD,Vinyl,Cassette)
     @author Vahet
  */ 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Product {
    String title;
    String artist;
    String genre;
    double price;
    int releaseYear;
    int productNum;
    String mediaType;
    String coverFileString; 
    String trackList;

    public Product(String title, String artist, String genre, double price, int releaseYear, int productNum, String mediaType, String coverFileString, String trackList) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.productNum = productNum;
        this.mediaType = mediaType;
        this.trackList = trackList;
        this.coverFileString = coverFileString; 
    }
    /**
     * Standard getter methods for the attributes in this class
     * 
     */
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
    public String getTrack(){
        return trackList;
    }
    public String getCoverFileString(){
        return coverFileString; 
    }

    /** Method that generates and array of product objects
     * currently from file but should eventually pull info
     * from database
     * 
     */
    public static Product[] generateProductArray() throws FileNotFoundException{     
        Product ProductArray[] = new Product[34];
        Scanner input = new Scanner(new File("./src/inventory.txt")); 
        int count = 0; 
        while(input.hasNextLine()){
            String[] array = input.nextLine().split(",");
            if(array[0].equals("end")) {
            	break; 
            }
            
            System.out.println(array[0]);

            Product singleProduct = new Product(array[0], array[1], array[2], 9.99, 2016, 99, array[6], array[7], "list"); 
            ProductArray[count] = singleProduct; 
            count++;
        }
        input.close();
        return ProductArray; 
    }
    
    
}
