/*The Page class is supposed to represent a webpage which is the GUI portion of the 
website that users interact with. It will have 
METHODS:
    Scroll:   a person can scroll up and down webpage
    GUI:      a method for actually displaying 
    Navigate: a method from going from one page to another
RESPONSIBILITYS:
    Search:   calls upon class to search for things ???


    MUST HAVE productPanel.java, products folder, MyFrame.java
*/

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class Page {

    static JPanel centerPanel = new JPanel();
    static JPanel topPanel = new JPanel();

    Page() throws FileNotFoundException{

        HeaderPanel headerContainer = new HeaderPanel();            //container for the title/search bar 

        topPanel.setBackground(Color.BLACK);
        topPanel.setPreferredSize(new Dimension(500,160));
        topPanel.add(headerContainer);

        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        centerPanel.setPreferredSize(new Dimension(800,3400));                  //needs to be fixed to dynamic resize 
        centerPanel.setBackground(Color.WHITE);

        Page.generateProductPanels();

        MyFrame myFrame = new MyFrame();
        myFrame.setSize(1350,800);

        JScrollPane scrollPane = new JScrollPane(centerPanel);                          // put centerpanel in a scrollpane for scroll feature 
        scrollPane.setPreferredSize(new Dimension(800, 600));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        myFrame.getContentPane().setLayout(new BorderLayout());
        myFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        myFrame.add(topPanel,BorderLayout.NORTH);
        myFrame.setVisible(true);
    }

    public static void genSearchPanels(Product[] products) throws FileNotFoundException {
        centerPanel.removeAll();
        for (Product product: products){
            productPanel prodPanel = new productPanel(product.getTitle(), product.getArtist(), product.getGenre(),product.getCoverFileString()); 
            centerPanel.add(prodPanel); 
            centerPanel.revalidate();
            centerPanel.repaint(); 
        }
    }

    public static void generateProductPanels() throws FileNotFoundException {
        centerPanel.removeAll();
        Product prodArray[] = Product.generateProductArray();
        for (Product product: prodArray){
            productPanel prodPanel = new productPanel(product.getTitle(), product.getArtist(), product.getGenre(),product.getCoverFileString()); 
            centerPanel.add(prodPanel); 
            centerPanel.revalidate();
            centerPanel.repaint(); 
        }
    }
}
