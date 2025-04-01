import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Account1 {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please Enter Your Email: ");
        String user = keyboard.nextLine();
        String path = ("user_email.txt");
        String path2 = ("password_bebop");
        File username = new File(path);
        File password = new File(path2);

        if (username.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(username))) {
                String words;
                while ((words = br.readLine()) != null) {
                    if (words.equals(user)) {
                        System.out.println("Please Enter Password: ");
                        String typePass = keyboard.nextLine();
                        if (password.exists()) {
                            try (BufferedReader br3 = new BufferedReader(new FileReader(password))) {
                                String words2;
                                while ((words2 = br3.readLine()) != null) {
                                    if (words2.equals(typePass)) {
                                        //println("You are now logged in");
                                    } else {
                                        System.out.println("Incorrect Password");
                                    }
                            }   
                            } catch (IOException e) {
                                e.printStackTrace();
                            } 
                        }
                    } else {
                        System.out.println("Incorrect Email");
                    }
            }   
            } catch (IOException e) {
                e.printStackTrace();
            } 
        } else {
            try (FileWriter write = new FileWriter(path)) {
                write.write(user);
                System.out.println("Email has been accepted"); 
            } catch (IOException x) {
                System.out.println("Error");
                x.printStackTrace();
            } 
            System.out.print("Please Create a Password: ");
            String pass = keyboard.nextLine();
            try (FileWriter write = new FileWriter(path2)) {
                write.write(pass);
                System.out.print("\nRe-type Password: ");
                String passConfirm = keyboard.nextLine();
                if (password.exists()) {
                    try (BufferedReader br2 = new BufferedReader(new FileReader(password))) {
                        String words;
                        while ((words = br2.readLine()) != null) {
                            if (words.equals(passConfirm)) {
                                System.out.println("Password Confirmed");
                            } else {
                                System.out.println("Incorrect Password");
                            }
                    }   
                    } catch (IOException e) {
                        e.printStackTrace();
                    } 
                }

            } catch (IOException x) {
                System.out.println("Error");
                x.printStackTrace();
            } 
        } 
        keyboard.close();
    }
}
