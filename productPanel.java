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
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class productPanel extends JPanel implements ActionListener {
   
   String albumName;
   String albumArtist; 
   String genre; 
   String coverFileString;
   JLabel itemLabel = new JLabel();
   JLabel artistLabel = new JLabel();
   JPanel spacer = new JPanel(); 
  

   productPanel(String albumName,String albumArtist, String genre, String coverFileString) throws FileNotFoundException {
      Border border = BorderFactory.createLineBorder(Color.black, 1);
      this.albumName = albumName;
      this.albumArtist = albumArtist; 
      this.genre = genre;
      this.coverFileString = coverFileString; 

      spacer.setPreferredSize(new Dimension(20,18));
      spacer.setBackground(Color.WHITE);
      
      ImageIcon image = new ImageIcon("products/" + coverFileString);
      itemLabel.setText(albumName);
      itemLabel.setFont(new Font("Calibri", Font.BOLD,16));
      itemLabel.setIcon(image);
      itemLabel.setVerticalTextPosition(JLabel.BOTTOM);
      itemLabel.setHorizontalTextPosition(JLabel.CENTER);
      itemLabel.setHorizontalAlignment(JLabel.CENTER);
      itemLabel.setPreferredSize(new Dimension(250,250));
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
      this.setPreferredSize(new Dimension(300,350));
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
   public void actionPerformed(ActionEvent e) {                   // this would be for the view button 

   }


}
