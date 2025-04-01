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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProductListingPage extends JPanel{
    static JPanel containerPanel = new JPanel(); 
    static JPanel centerPanel = new JPanel();
    static JPanel topPanel = new JPanel();
    static JScrollPane scrollPane = new JScrollPane(centerPanel);   
    static JLabel label = new JLabel("test Label");   
    
        ProductListingPage(){
            try {
                HeaderPanel headerContainer = new HeaderPanel();            //container for the title/search bar 
        
                topPanel.setBackground(Color.BLACK);
                topPanel.setPreferredSize(new Dimension(500,160));
                topPanel.add(headerContainer);
                
                centerPanel.setLayout(new GridLayout(0,4,5,20));
                centerPanel.setBackground(Color.WHITE);
                
                scrollPane.getVerticalScrollBar().setUnitIncrement(10);

                containerPanel.setLayout(new BorderLayout());
                containerPanel.add(scrollPane,BorderLayout.CENTER); 
                containerPanel.add(topPanel,BorderLayout.NORTH);
                ProductListingPage.generateProductPanels();


            } catch (IOException e) {e.printStackTrace();}
        }

        public static JPanel getPage(){
            return containerPanel; 
        }
    
        public static void genSearchPanels(Product[] products) throws IOException {
            centerPanel.removeAll();
            for (Product product: products){
                JPanel containerPanel = new JPanel(new FlowLayout());
                containerPanel.setBackground(Color.white);
    
                productPanel prodPanel = new productPanel(product.getTitle(), product.getArtist(), product.getGenre(),product.getCoverFileString()); 
                containerPanel.add(prodPanel);
                centerPanel.add(containerPanel);
                centerPanel.revalidate();
                centerPanel.repaint(); 
            }
        }
    
        public static void generateProductPanels() throws IOException {
            centerPanel.removeAll();
            Product prodArray[] = Product.generateProductArray();
            for (Product product: prodArray){
                JPanel containerPanel = new JPanel(new FlowLayout());
                containerPanel.setBackground(Color.white);
    
                productPanel prodPanel = new productPanel(product.getTitle(), product.getArtist(), product.getGenre(),product.getCoverFileString()); 
                containerPanel.add(prodPanel);
                centerPanel.add(containerPanel); 
                centerPanel.revalidate();
                centerPanel.repaint(); 
            }
        }

}
