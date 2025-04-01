//Manages accounts within a file

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Account{

    public Account() throws FileNotFoundException{

    }
 
    public static boolean checkIfAccountExists(String username) throws FileNotFoundException{    // Checks the accountFile to see if username exists within the file 
        Scanner input = new Scanner(new File("accountsFile.txt")); 
        while(input.hasNextLine()){
            String[] accountArr = input.nextLine().split(","); 
            String usernameInFile = accountArr[0];

            if(usernameInFile.equals(username)){
                System.out.println("true");
                input.close(); 
                return true; 
            }
        }
        System.out.println("false");    
        input.close();
        return false;
    }

    public static boolean checkIfPasswordIsCorrect(String username, String password) throws FileNotFoundException{  //takes in a username and password and checks if they match within the accountFile
        Scanner input = new Scanner(new File("accountsFile.txt")); 
        while(input.hasNextLine()){
            String[] accountArr = input.nextLine().split(","); 
            String usernameInFile = accountArr[0];
            String passwordInFile = accountArr[1];
            if(usernameInFile.equals(username)&&passwordInFile.equals(password)){
                input.close();
                return true;
            }
        }
        input.close();
        return false;
    }

    public static void createAccount(String username, String password) throws IOException{      //creates a username and password and writes them into the file. 
        FileWriter writer = new FileWriter("accountsFile.txt", true); 
        writer.write("\n"+username+","+password); 
        writer.close();
    }

 
}