/*The Page class is supposed to represent a webpage which is the GUI portion of the 
website that users interact with. It will have 
METHODS:
    Scroll:   a person can scroll up and down webpage
    GUI:      a method for actually displaying 
    Navigate: a method from going from one page to another
RESPONSIBILITYS:
    Search:   calls upon class to search for things ???
*/

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
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
    public static void main(String[] args) {

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    HeaderPanel headerContainer = new HeaderPanel(); 

    topPanel.setBackground(Color.BLACK);
    topPanel.setPreferredSize(new Dimension(500,200));
    topPanel.add(headerContainer);

    centerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
    centerPanel.setPreferredSize(new Dimension(800,2000));// dynamic resize
 
   
    for(int i=1;i<15;i++)                   // adds temp items to the page 
    {
        ItemPanel xpanel = new ItemPanel();
        xpanel.setName("panel"+i);
        centerPanel.add(xpanel);
        
    }



    

    MyFrame myFrame = new MyFrame();
    myFrame.setSize(1350,800);

    JScrollPane scrollPane = new JScrollPane(centerPanel);
    scrollPane.setPreferredSize(new Dimension(800, 600));
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    myFrame.getContentPane().setLayout(new BorderLayout());
    myFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    myFrame.add(topPanel,BorderLayout.NORTH);
    myFrame.setVisible(true);
    }
}
