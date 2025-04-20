package gui.swingfactory;
/**
 * A custom JPanel that has more parameters in its constructor
 * and some methods to make other specific Jpanels with hardcoded
 * values that come up often
 * @author vahet EthanG
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import gui.ScreenSize;

public class JPanelFactory extends JPanel {
	/**
	 * Empty constructor 
	 */
	public JPanelFactory(){
		
	}
	public static JPanel productPanel(Color color,int xDimR, int YDimR, LayoutManager layout  ){
		JPanel helper= new JPanel();
		helper.setBackground(color);
		helper.setPreferredSize(ScreenSize.createDim(xDimR,YDimR));
		helper.setLayout(layout);
		return helper;
	}
	/** 
	 * Creates a JPanel that is designed to put space between two other JPanels
	 * 
	 */
	/*public static JPanel Spacer(int xDimRatio, int yDimRatio) {
		   JPanel spacer = new JPanel();
		   spacer.setBackground(Color.WHITE);
		   spacer.setPreferredSize(ScreenSize.createDim(xDimRatio,yDimRatio));
		   return spacer;
	}*/

}
