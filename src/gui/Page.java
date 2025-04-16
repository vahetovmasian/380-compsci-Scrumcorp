package gui;
/* This class ia an abstraction of what a Page is supposed to be
 * A page is like an internet page. How this is acomplished is by 
 * adding Java GUI components onto a Jframe (this is the window which
 * gui stuff is added) Their are different page objects that add
 * different components to repersent different pages. An 
 * ex of this would be the LoginPage which has a place to type
 * username and password 
 */

import gui.swing.MyFrame;
import gui.swing.MyPanel;

abstract public class Page {
	MyFrame frame;
	
	public Page(MyFrame frame) {
		this.frame = frame;
	}
	
	
	 public void addHeader(MyPanel headerPanel) {
		 frame.add(headerPanel);
	 }
	 
	 abstract public MyPanel createHeaderPanel();
	 
	 abstract public MyPanel createBodyPanel();
	 
	 public void addScrollWheel(MyPanel panel) {
		 frame.addScrollWheel(panel);
	 }
	 
	 
	 
	 
	 
		
	
	
}
