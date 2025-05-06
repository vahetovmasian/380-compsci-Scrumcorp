package gui;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.Border;

import backend.Product;
import gui.swingfactory.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class productPanel {
  
   Product product;	
   int xDimR, yDimR;
   
   public productPanel(Product product, int xDimR, int yDimR) throws FileNotFoundException {
	   this.product=product;
       this.xDimR = xDimR;
       this.yDimR = yDimR;
    
   }
   
   public JLabel createProductItemlabel(ImageIcon image) {
	   
	   return null;
   }
   
 
   
   public JLabel createArtistLabel() {
	  
	   return null;
   }
   
   public JPanel createMainProductPanel() {
	   JPanel productPanel= JPanelFactory.productPanel(Color.white, xDimR, yDimR, null);
	   
	   
	   
	   return productPanel;
	   
   }
   
   public JPanel addStufftoPanel(JPanel jPanel, Border border) {
	   BoxLayout myLayout= new BoxLayout(jPanel, BoxLayout.Y_AXIS);
	   jPanel.setLayout(myLayout);
	   jPanel.add(Box.createVerticalGlue());
	   jPanel.setName(product.getTitle());
	   jPanel.setBorder(border);
	  // productPanel.add(productPanel.createSpacer(xDimR,yDimR));
	   return jPanel;
   }
   
   public JPanel getFinishedPanel() {
	      JPanel finalPanel;
	   	  ImageIcon image = new ImageIcon("./src/products/" + product.getCoverFileString());
	      Border border = BorderFactory.createLineBorder(Color.black, 1);
	      finalPanel = addStufftoPanel(createMainProductPanel(), border);
	      finalPanel.add( createProductItemlabel(image));
	      finalPanel.add(createArtistLabel());
	      MouseListenerFactory mouse = new MouseListenerFactory(finalPanel);
	      return finalPanel;
   }
   
   
   
   

}
