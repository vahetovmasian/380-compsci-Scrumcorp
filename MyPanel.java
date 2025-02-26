import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.security.DigestException;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.Font;



import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class MyPanel extends JPanel {
   
   String name;
   JLabel myLabel = new JLabel();



   MyPanel() {
      JButton cartButton = new JButton("ADD TO CART");
      cartButton.setBounds(100, 295, 120, 50);
      ImageIcon image = new ImageIcon("disk.png");
      myLabel.setText("Turtle Bebop");
      //myLabel.setFont(new Font("Calibri", Font.BOLD,60));
      myLabel.setIcon(image);
      myLabel.setBounds(50, 25, 250, 250);
      myLabel.setVerticalTextPosition(JLabel.TOP);
      myLabel.setHorizontalTextPosition(JLabel.CENTER);





      this.add(myLabel);
      this.setLayout(null);
      this.setName(name);
      this.setPreferredSize(new Dimension(300,350));
      this.setBackground(Color.lightGray);
      this.add(cartButton);


      //this.cartButton.setBounds(100, 200, 120,40);
      //this.cartButton.setVerticalAlignment(JButton.BOTTOM);
      //this.cartButton.setAlignmentY(150);

      











      /*this.setTitle("GUI");
      this.setDefaultCloseOperation(3);
      this.setSize(600, 400);
      this.setVisible(true);*/
   }
}
