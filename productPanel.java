import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class productPanel extends JPanel implements ActionListener {
   
   String albumName;
   String albumArtist; 
   String genre; 
   String coverFileString;
   JLabel itemLabel = new JLabel();
   JLabel artistLabel = new JLabel();
   JPanel spacer = new JPanel(); 
  

   productPanel(String albumName,String albumArtist, String genre, String coverFileString) throws IOException {
      Border border = BorderFactory.createLineBorder(Color.black, 1);
      this.albumName = albumName;
      this.albumArtist = albumArtist; 
      this.genre = genre;
      this.coverFileString = coverFileString; 

      spacer.setPreferredSize(new Dimension(20,18));
      spacer.setBackground(Color.WHITE);      

      try {
         BufferedImage image = ImageIO.read(new File("products/" + coverFileString));
         Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
         ImageIcon imageIcon = new ImageIcon(resizedImage);
         itemLabel.setIcon(imageIcon);

      } catch (Exception e) {
         BufferedImage image = ImageIO.read(new File("products/" + "disk.png"));
         Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
         ImageIcon imageIcon = new ImageIcon(resizedImage);
         itemLabel.setIcon(imageIcon);
         System.out.println(coverFileString);
      }


      itemLabel.setText(albumName);
      itemLabel.setFont(new Font("Calibri", Font.BOLD,16));
      itemLabel.setVerticalTextPosition(JLabel.BOTTOM);
      itemLabel.setHorizontalTextPosition(JLabel.CENTER);
      itemLabel.setHorizontalAlignment(JLabel.CENTER);
      itemLabel.setPreferredSize(new Dimension(295,250));
      itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      artistLabel.setText(albumArtist);
      artistLabel.setFont(new Font("Calibri", Font.PLAIN,12));
      artistLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      JButton viewButton = new JButton("VIEW ITEM");
      viewButton.setPreferredSize(new Dimension(260,50));
      viewButton.setAlignmentX(Component.CENTER_ALIGNMENT);

      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      this.add(Box.createVerticalGlue());
      this.setBorder(border);
      this.setName(albumName);
      this.setSize(new Dimension(400,350));
      this.setBackground(Color.white);
      this.add(itemLabel);                                                 // has image + albumTitle 
      this.add(artistLabel);
      this.add(spacer);
      this.add(viewButton);
   }

   public String getAlbumName(){
      return albumName.toString(); 
   }


   @Override
   public void actionPerformed(ActionEvent e) {                   // button in a productPanel to open product page  

   }


}
