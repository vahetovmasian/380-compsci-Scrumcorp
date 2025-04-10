import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class ProductListingPage extends JPanel{
    static JPanel containerPanel = new JPanel(); 
    static JPanel centerPanel = new JPanel();
    static JPanel topPanel = new JPanel();
    static JScrollPane scrollPane = new JScrollPane(centerPanel);
    static JPanel spacerPanel = new JPanel();    
    Border border = BorderFactory.createLineBorder(Color.black, 5);
    
        ProductListingPage(){
            try {
                spacerPanel.setSize(new Dimension(40,40));
                spacerPanel.setBackground(Color.white);

                HeaderPanel headerContainer = new HeaderPanel();            //container for the title/search bar 
        
                topPanel.setBackground(Color.BLACK);
                //topPanel.setLayout(new BorderLayout());
                topPanel.setPreferredSize(new Dimension(500,160));
                topPanel.add(headerContainer);

                //topPanel.add(spacerPanel,BorderLayout.SOUTH); 
                centerPanel.setLayout(new GridLayout(0,4,5,20));
                centerPanel.setBackground(Color.WHITE);
                
                //scrollPane.setLayout(new BorderLayout());
                scrollPane.getVerticalScrollBar().setUnitIncrement(10);
                scrollPane.setBorder(border);

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