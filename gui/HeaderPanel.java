package gui;
/**
 *  handles the top panel that is at the top of every page 
 *  (the black bar with the logo that you can click to return
 *  to the home page)
	@author vahet EthanG
 */

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.HeaderPanel.defaultListener;
import gui.constants.HeaderConstants;
import gui.swingfactory.JButtonFactory;
import gui.swingfactory.JLabelFactory;
import gui.swingfactory.JPanelFactory;
import gui.swingfactory.JTextFieldFactory;

   /**
    * HeaderPanel is a Jpanel with specific parameters
    */
public class HeaderPanel extends JPanel  {
   /**
    * blank constructor 
    * 
    */
   public HeaderPanel() {
	   
   }
   /**
    * makes a default Panel using standard headerPanel stuff
    */
   public void makeDefaultPanel() {
	   setDefaultStuff();
	   addDefaultStuff();
	
   }
   
   public void setDefaultStuff() {
	   setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	   setPreferredSize(HeaderConstants.PANELDIM);
	   setBackground(HeaderConstants.BACKGROUNDCOLOR);
   }
   
   public void addDefaultStuff() {
	   add(makeDefaultLabel());
	   System.out.println("Label was added ");
	   add(makeTextDefaultField());
	   System.out.println("Text field was added ");
	   add(makeDefaultSearchButton());
	   System.out.println("Button was added ");
   }
   
   /**
    * Makes a MyLabel with defaults constants,
    * pulls them from HeaderConstants.java
    * @return MyLabel: custom JLabel
    */
   private JLabel makeDefaultLabel() {
	   System.out.println("Making Label...");
	   JLabel label = JLabelFactory.defaultHeaderLabel();
	   System.out.println("Label Made");
	  
	   return label;
   }
   /**
    * makes the default Search button for the default Header
    * Panel 
    * for the Listener uses the aListener right under it to
    * make search button be click able 
    * @return JButton: a object that people can click on 
    */
   private JButton makeDefaultSearchButton() {
	   JButton searchButton = JButtonFactory.defaultHeaderButton();
	   searchButton.addActionListener(new defaultListener());
	   return searchButton;
   }
   
   
   	   public class defaultListener implements ActionListener {
   			public void actionPerformed(ActionEvent e) {
   				System.out.println("needs to be implemeneted");
   			}
   	   }
   
   
   private JTextField makeTextDefaultField() {
	   return JTextFieldFactory.defaultHeaderTextField() ;
   }

}
