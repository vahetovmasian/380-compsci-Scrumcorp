package gui;
import gui.swing.*;
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

import backend.MyMouse;
import backend.Product;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class productPanel {
   ScreenSize helper = new ScreenSize();
   Product product;	
   int xDimR, yDimR;
   
   productPanel(Product product, int xDimR, int yDimR) throws FileNotFoundException {
	   this.product=product;
       this.xDimR = xDimR;
       this.yDimR = yDimR;
    
   }
   
   public MyLabel createProductItemlabel(ImageIcon image) {
	   MyLabel itemLabel = new MyLabel(product.getTitle(), new Font("Calibri", Font.BOLD,16), image,
	    		  JLabel.BOTTOM, JLabel.CENTER, JLabel.CENTER, new Dimension(250,250), Component.CENTER_ALIGNMENT);
	   return itemLabel;
   }
   
 
   
   public MyLabel createArtistLabel() {
	   MyLabel artistLabel= new MyLabel(product.getArtist(),new Font("Calibri", Font.PLAIN,12), null
	    		  ,0, 0, 0 , null , Component.CENTER_ALIGNMENT );
	   return artistLabel;
   }
   
   public MyPanel createMainProductPanel() {
	   MyPanel productPanel= new MyPanel(Color.white, xDimR, yDimR, null);
	   
	   
	   
	   return productPanel;
	   
   }
   
   public MyPanel addStufftoPanel(MyPanel productPanel, Border border) {
	   BoxLayout myLayout= new BoxLayout(productPanel, BoxLayout.Y_AXIS);
	   productPanel.setLayout(myLayout);
	   productPanel.add(Box.createVerticalGlue());
	   productPanel.setName(product.getTitle());
	   productPanel.setBorder(border);
	   productPanel.add(productPanel.createSpacer(xDimR,yDimR));
	   return productPanel;
   }
   
   public MyPanel getFinishedPanel() {
	      MyPanel finalPanel;
	   	  ImageIcon image = new ImageIcon("./src/products/" + product.getCoverFileString());
	      Border border = BorderFactory.createLineBorder(Color.black, 1);
	      finalPanel = addStufftoPanel(createMainProductPanel(), border);
	      finalPanel.add( createProductItemlabel(image));
	      finalPanel.add(createArtistLabel());
	      MyMouse mouse = new MyMouse(finalPanel);
	      return finalPanel;
   }
   
   
   
   

}
