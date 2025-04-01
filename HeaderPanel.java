import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HeaderPanel extends JPanel implements ActionListener {  // class for handling search box/button
    JLabel title = new JLabel("CALIBRI VINYLS");
    JTextField textField = new JTextField("Search for Albums..."); 
    JButton searchButton = new JButton("🔍");

    BufferedImage image = ImageIO.read(new File("icons/userIcon.png"));              
    Image resizedImage = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    ImageIcon imageIcon = new ImageIcon(resizedImage);
    JButton userIconButton = new JButton(imageIcon);

    String searchString; 
     
    HeaderPanel() throws IOException {
        title.setFont(new Font("Helvetica", Font.PLAIN,65));
        title.setForeground(Color.white);
        title.setBounds(340, -90, 800, 300);

        textField.setBounds(460, 110, 200, 30);
        searchButton.addActionListener(this); 
        searchButton.setBounds(662,109,44,33);
        searchButton.setFont(new Font("Calibri", Font.BOLD,20));

        userIconButton.addActionListener(this);
        userIconButton.setOpaque(false);
        userIconButton.setBorderPainted(false);
        userIconButton.setFocusPainted(false);
        userIconButton.setBounds(1150,15,40,40);


        String[] filters = {"filter","Rock","Pop","Country"};
        JComboBox filterMenu = new JComboBox(filters);
        filterMenu.setBounds(710,111,95,31);    
        
        this.add(filterMenu);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1200,150));
        this.setLayout(null);
        this.add(title);
        this.add(textField);
        this.add(searchButton); 
        this.add(userIconButton);
        }


    public void actionPerformed(ActionEvent e) {      //actual part where search button decies to search for panels
        Product[] outputProducts = null; 
        Product[] inputProducts = null;

        if(e.getSource()==userIconButton){
            WindowManager.displayLoginPage();        
        }

        try {
            inputProducts = Product.generateProductArray();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } 
        Search search = new Search(inputProducts);
        if(e.getSource()==searchButton){              // or decides to generate all panels. 
            System.out.println(textField.getText());
            searchString = textField.getText(); 
            outputProducts = search.searchProducts(searchString);
            try {
                ProductListingPage.genSearchPanels(outputProducts);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
            }
        }

    }
    
    public String getString(){
        return searchString;
    }
}