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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class page {
    public static void main(String[] args) {



    JPanel bottomPanel = new JPanel();
    bottomPanel.setBackground(Color.lightGray);
    bottomPanel.setPreferredSize(new Dimension(50,50));




    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    topPanel.setBackground(Color.BLACK);
    //centerPanel.setBackground();
    centerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
    //centerPanel.setLayout(new GridLayout(3,4, 20, 20));

    topPanel.setPreferredSize(new Dimension(100,100));
    centerPanel.setPreferredSize(new Dimension(800,2000));// dynamic resize
    //centerPanel.setPreferredSize(null);
 
    JLabel header = new JLabel("CALIBRI VYNELS");
    header.setFont(new Font("Calibri", Font.BOLD,60));
    header.setForeground(Color.white);
    header.setVerticalAlignment(JLabel.CENTER);
    topPanel.add(header);


    for(int i=1;i<15;i++)
    {
        MyPanel xpanel = new MyPanel();
        xpanel.setName("panel"+i);
        centerPanel.add(xpanel);
        
    }
    //MyPanel panel2 = new MyPanel();
    //centerPanel.add(panel1); 
    //centerPanel.add(panel2);






    

    MyFrame myFrame = new MyFrame();
    myFrame.setSize(1300,800);
    //myFrame.add(topPanel,BorderLayout.NORTH);
    //myFrame.add(centerPanel,BorderLayout.CENTER);



    JScrollPane scrollPane = new JScrollPane(centerPanel);
    scrollPane.setPreferredSize(new Dimension(800, 600));
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    myFrame.getContentPane().setLayout(new BorderLayout());
    myFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

    myFrame.add(topPanel,BorderLayout.NORTH);
    //myFrame.add(bottomPanel










    myFrame.setVisible(true);
    }
}

