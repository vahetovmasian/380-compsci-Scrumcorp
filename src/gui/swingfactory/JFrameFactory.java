package gui.swingfactory;
import gui.ScreenSize;


/**
 This class Extends Jframe, its main purpose is to create custom Jframes
* which are the windows for our website.
* This has two different method groups, one is a large method that allows for
* changing many of the most common things to Change in a Jframe. The other group
* is many smaller methods that allow for changing individual components of the 
* Jframe as seen neccesary, also there is a method for adding components
* @author vahet EthanG
*/
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.ScrollPane;

public class JFrameFactory extends JFrame{

	

			
	int xDim =ScreenSize.getXDim() /2;
	int yDim =ScreenSize.getYDim()  /3;
	/**
	 * empty constructor 
	 */
	public JFrameFactory() {
		
	}
	
	/**
	 * Constructor with more specifications for myFrame
	 * @param title
	 * @param xDim
	 * @param yDim
	 * @param myBorder
	 */
    public JFrameFactory(String title, int xDimR, int yDimR, BorderLayout myBorder) {
    	setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ScreenSize.getXDim()/xDimR,ScreenSize.getXDim()/yDimR);
        setLayout(myBorder);
    }
    /**
	 * Overloaded Constructor with different parameters to allow
	 * for different constraints 
	 */
    JFrameFactory(int xDim, int yDim){
    	
    }
    /**The purpose of this method is instead of calling a ton of different methods to edit the Jframe 
    * you can call just this one which handles what we generally would want every time of a Jframe
    * 
    *
    * This method handles editing frame info that every frame needs 
    * The information that every frame needs is
    * @param Dimensions: 	 a height and width component both being ints
    * @param Title: 		 a string that will be displayed to user
    * @param BorderLayout: this is a layout manager that arranges components within the frame 
    *  				into different regions North, South, East, West, and Center. Each 
    *    			Region can hold only one component. When a component is added to a 
    *               container using BorderLayout, the region where it should be placed 
    *               must be specified. If no region is specified, it defaults to the Center.
    *               
    * 
    */
    public void editFrameBasicInfo(String title,int xDim, int yDim, BorderLayout myBorder) {
    	setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(xDim,yDim);
        setLayout(myBorder);
    }
    /** adds JscrollPane component to frame allowing to scroll
     * 
     * @param panel
     */
    public void addScrollWheel(JPanel panel) {
    	 JScrollPane scrollPane = new JScrollPane(panel); 
    	  scrollPane.setPreferredSize(new Dimension(xDim, yDim));
          scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
          // need to change this or confirm its good (refering to the 20 being hard coded)
          scrollPane.getVerticalScrollBar().setUnitIncrement(20);
          add(scrollPane);
    }
    
   

}
