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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class page {

    static JPanel centerPanel = new JPanel();

    public static void main(String[] args) throws FileNotFoundException{

        JPanel topPanel = new JPanel();
        HeaderPanel headerContainer = new HeaderPanel();            //container for the title/search bar 

        topPanel.setBackground(Color.BLACK);
        topPanel.setPreferredSize(new Dimension(500,200));
        topPanel.add(headerContainer);

        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        centerPanel.setPreferredSize(new Dimension(800,2000));                  //needs to be fixed to dynamic resize 
        centerPanel.setBackground(Color.WHITE);

        generateProductPanels();

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

    public static String returnStringIfSubstringMatches(String text, String substring) {
        if (text != null && text.contains(substring)) {
            return text;
        }
        return null;
    }
                    
                    
    public static void generateProductPanels() throws FileNotFoundException {    // generates all productPanels from input file
        centerPanel.removeAll();
        Scanner input = new Scanner(new File("products/inventory"));
        while(input.hasNextLine()){
            String[] array = input.nextLine().split(",");
            if (array[0].equals("end"))
            break; 

            productPanel product = new productPanel(array[0],array[1], array[2], array[3]);
            centerPanel.add(product); 
            centerPanel.revalidate();
            centerPanel.repaint();
        }  
        input.close();
    }
    
    public static void searchPanels(String productString) throws FileNotFoundException {   // searches through panels and adds only ones that match
                                                                                            // the stirng or substing matches.
        Scanner input = new Scanner(new File("products/inventory"));
        centerPanel.removeAll(); 
        while(input.hasNextLine()){
            String[] array = input.nextLine().split(",");
            if (array[0].equals("end"))
            break; 

            productPanel product = new productPanel(array[0],array[1], array[2], array[3]);
            String tempstring; 
            tempstring = returnStringIfSubstringMatches(product.getAlbumName().toLowerCase(),productString.toLowerCase());  
            if (product.getAlbumName().toLowerCase().equals(tempstring)){               // turns all strings to lowercase before compare
                                                                                        // so that search case sensitive doesnt matter
                centerPanel.add(product); 
            }

            centerPanel.revalidate();
            centerPanel.repaint();
        }  
        input.close();
    }

    public static class HeaderPanel extends JPanel implements ActionListener {  // class for handling search box/button
        JLabel title = new JLabel("CALIBRI VINYLS");
        JTextField textField = new JTextField("Search for Albums..."); 
        JButton searchButton = new JButton("search");
        String searchString; 
         
        HeaderPanel() {
            title.setFont(new Font("Calibri", Font.BOLD,60));
            title.setForeground(Color.white);
            title.setBounds(150, -80, 800, 300);

            textField.setBounds(310, 140, 155, 30);
            searchButton.addActionListener(this); 
            searchButton.setBounds(470,140,70,30);

            this.setBackground(Color.BLACK);
            this.setPreferredSize(new Dimension(800,180));
            this.setLayout(null);
            this.add(title);
            this.add(textField);
            this.add(searchButton); 
            }
        
        public void actionPerformed(ActionEvent e) {      //actual part where search button decies to search for panels
            if(e.getSource()==searchButton){              // or decides to generate all panels. 
                System.out.println(textField.getText());
                searchString = textField.getText(); 
                try {
                searchPanels(searchString);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
            if (searchString.equals(""))
                try {
                generateProductPanels();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        
        public String getString(){
            return searchString;
        }
    }

}
