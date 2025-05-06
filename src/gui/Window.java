package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import gui.page.HomePage;
import gui.swingfactory.JFrameFactory;

/** this class manages the frame for all the pages to be on and swaps between pages 
 * 
 * @author Vahet EthanG 
 *
 */
public class Window  {

	/** Makes A MyFrame which will function as the main window for everything 
	 * 
	 */
	JFrame mainWindow = new JFrameFactory("Vinyls", 2, 3, new BorderLayout());
	
	public Window() {
		
	}
	
	public void loadHomePage() {
		System.out.println("Loading Home Page...");
		try {
		HomePage page = new HomePage();
		
		displayPage(page);
		}
		catch(Exception e){
			System.out.print("Failed to Load Homepage");
		}
		
	}
	
	
	public void displayPage(Page page){
		mainWindow.add(page.createHeaderPanel());
		mainWindow.pack();
		System.out.println("Header Added to Main Page");
		//mainWindow.add(page.createBodyPanel());
		System.out.println("BodyCreated");
		mainWindow.setVisible(true);
		System.out.println("SetVisible");
	}
	   

	public void clearWindow(){
	     mainWindow.removeAll();
	}
	   
	// swaps to a different page by clearing current page and displaying new one
	public void swapToDifPage(Page page) {
		clearWindow();
		displayPage(page);
		   
	}
	// Opens a newPage in a newWindow
	public void openInNewTab() {
		   
	}
	   
	  
}
