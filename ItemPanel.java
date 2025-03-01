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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemPanel extends JPanel implements ActionListener {
   
   String name;
   String genre; 
   JLabel itemLabel = new JLabel();



   ItemPanel() {
      JButton cartButton = new JButton("ADD TO CART");
      cartButton.setBounds(90, 295, 120, 50);
      ImageIcon image = new ImageIcon("disk.png");
      itemLabel.setText("Turtle Bebop");
      //itemLabel.setFont(new Font("Calibri", Font.BOLD,60));
      itemLabel.setIcon(image);
      itemLabel.setBounds(50, 25, 250, 250);
      itemLabel.setVerticalTextPosition(JLabel.TOP);
      itemLabel.setHorizontalTextPosition(JLabel.CENTER);




      this.add(itemLabel);
      this.setLayout(null);
      this.setName(name);
      this.setPreferredSize(new Dimension(300,350));
      this.setBackground(Color.lightGray);
      this.add(cartButton);






   }

   @Override
   public void actionPerformed(ActionEvent e) {

   }
}
