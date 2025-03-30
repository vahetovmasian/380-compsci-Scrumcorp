import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class Window {
    static MyFrame myWindow = new MyFrame();
    static ProductListingPage productListingPage = new ProductListingPage();
    static LoginPage loginPage = new LoginPage();

    Window(){
        myWindow.add(ProductListingPage.containerPanel,BorderLayout.CENTER);
        myWindow.setVisible(true);

    }

    
    public static void displayLoginPage(){
        myWindow.remove(ProductListingPage.containerPanel);
        myWindow.add(LoginPage.containerPanel,BorderLayout.CENTER); 
        myWindow.repaint();
        myWindow.setVisible(true);
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
