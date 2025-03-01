// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;

public class HeaderPanel extends JPanel implements ActionListener {
   JLabel title = new JLabel("CALIBRI VINYLS");
   JTextField textField = new JTextField("Search for Albums..."); 
   JButton searchButton = new JButton("search");

   HeaderPanel() {
      textField.setBounds(310, 145, 155, 30);
      searchButton.setBounds(470,145,70,30);
      title.setFont(new Font("Calibri", Font.BOLD,60));
      title.setForeground(Color.white);
      title.setBounds(150, -80, 800, 300);
      //title.setLayout(new FlowLayout());

      searchButton.addActionListener(this); 

      this.setPreferredSize(new Dimension(800,180));
      this.setLayout(null);
      this.add(title);
      this.add(textField);
      this.add(searchButton);
      }


   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==searchButton){
         System.out.println("Button goes pressss:  " + textField.getText()); 
      }
   }
}
