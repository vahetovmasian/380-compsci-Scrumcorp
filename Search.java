public class Search {

   private Product[] productArray;
   
   public Search(Product[] products) { //constructor to initialize search with the array of products 
      this.productArray = products;
   }
   
   public Product[] searchProducts(String query) { //search method to return products matching the query
      Product[] results = new Product[productArray.length]; //array storing matching products
      int count = 0; //tracks how many matches 
      
      String lowerCaseQuery = query.toLowerCase(); //turns query to lower case for case-insensitive search
      String[] keywords = lowerCaseQuery.split("\\s+"); 
      
      for (Product product : productArray) { //iterate through array of products
            boolean isMatch = true ; // assumes product is a match
            String title = product.getTitle().toLowerCase(); 
            String genre = product.getGenre().toLowerCase();
            String artist = product.getArtist().toLowerCase();
            String mediaType = product.getMediaType().toLowerCase();
           
           for(String keyword : keywords) { //checks each keyword against the product 
               boolean keywordFound = false; //assumes the current keyword does not match 
               
               if (title.contains(keyword) || genre.contains(keyword) || artist.contains(keyword) || mediaType.contains(keyword)) { //checks the title, genre, and artist attributes
               keywordFound = true ; // current keyword matches an attribute, move on to next keyword 
               }
            
               if (!keywordFound) { // current keyword was not found
                  isMatch = false; // the product is not a match 
                  break; //exit loop and check next product
               }
           }
        
        if (isMatch) { // all keywords match, therefore result is valid 
            results[count]= product; //adds product to result array at index count 
             count++; //increments count by 1 because a product was added to result 
        } 
    }
      
      Product [] finalResults = new Product[count]; //creates an new array with the correct size 
      System.arraycopy(results, 0, finalResults, 0, count); //copy results into final array 
      return finalResults; //return final array 
      
   }
}
        
