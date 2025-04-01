import java.awt.BorderLayout;

public class WindowManager {
    static MyFrame myWindow = new MyFrame();
    static ProductListingPage productListingPage = new ProductListingPage();
    static LoginPage loginPage = new LoginPage();

    WindowManager(){
        myWindow.add(ProductListingPage.containerPanel,BorderLayout.CENTER);  //default page
        myWindow.setVisible(true);
    }


    public static void displayLoginPage(){
        myWindow.remove(ProductListingPage.containerPanel);
        myWindow.add(LoginPage.containerPanel,BorderLayout.CENTER); 
        myWindow.revalidate();
        myWindow.repaint();
        myWindow.setVisible(true);
    }

    public static void displayProductListingPage(){
        myWindow.remove(LoginPage.containerPanel);
        myWindow.add(ProductListingPage.containerPanel,BorderLayout.CENTER);
        myWindow.revalidate();
        myWindow.repaint();
        myWindow.setVisible(true);
    }
  
}