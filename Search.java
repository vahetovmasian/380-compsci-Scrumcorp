public class Search {

   private Product[] productArray;
   
   public Search(Product[] products) { //constructor to initialize search with the array of products 
      this.productArray = products;
   }
   
   public Product[] search(String query) { //search method to return products matching the query
      Product[] results = new Product[productArray.length]; //array storing matching products
      int count = 0; //tracks how many matches 
      
      String lowerCaseQuery = query.toLowerCase(); //turns query to lower case for case-insensitive search
      
      
      for (Product product : productArray) { //iterate through array of products 
            String title = product.getTitle().toLowerCase(); 
            String genre = product.getGenre().toLowerCase();
            String artist = product.getArtist().toLowerCase();
            String mediaType = product.getMediaType().toLowerCase();
            
            if (title.contains(lowerCaseQuery) || genre.contains(lowerCaseQuery) || artist.contains(lowerCaseQuery) || mediaType.contains(lowerCaseQuery)) { //checks the title, genre, and artist attributes
               results[count] = product; // assigns the matched product to  the index of the value of count 
               count++; // increments counter because a product was found 
            }
      }

      if (count == 0) { //no results found 
         return new Product[0]; //empty array 
      } 
      
      Product [] finalResults = new Product[count]; //creates an array with the number of results 
      System.arraycopy(results, 0, finalResults, 0, count); //copy results into final array of size count 
      return finalResults; //return the array with correct size
      
   }
}
        
