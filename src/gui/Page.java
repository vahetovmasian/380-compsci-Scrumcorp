package gui;
/** This class ia an abstraction of what a Page is supposed to be
 * A page is like an internet page. How this is acomplished is by 
 * adding Java GUI components onto a Jframe (this is the window which
 * gui stuff is added) Their are different page objects that add
 * different components to repersent different pages. An 
 * ex of this would be the LoginPage which has a place to type
 * username and password 
 * @author Vahet EthanG
 */

import javax.swing.JPanel;

import gui.swingfactory.JFrameFactory;
import gui.swingfactory.JPanelFactory;

abstract public class Page {
	JFrameFactory frame;
	/**
	 * Constructs new Page
	 * @param JFrameFactory :a MyFrame object  
	 */
	public Page() {
	}
	
	/**
	 * adds a HeaderPanel to the main page 
	 * @param headerPanel
	 */
	 public void addHeader(JPanelFactory headerPanel) {
		 frame.add(headerPanel);
	 }
	 /**
	  * needs to be implemented in create 
	  */
	 abstract public JPanel createHeaderPanel();
	 
	 abstract public JPanel createBodyPanel();
	 
	 abstract public JPanel addComponentsToMyFrame();
	 
	 
		
	
	
}
