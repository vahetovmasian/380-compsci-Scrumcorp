import java.io.IOException;

import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) throws IOException{
        WindowManager myWindow = new WindowManager(); 
               try {
    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
 } catch (Exception e) {
            e.printStackTrace();
 }
    }   
}
