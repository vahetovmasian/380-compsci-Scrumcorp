/**
 * 
 */
package gui.swingfactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import gui.ScreenSize;

/**
 * This class holds constant values that relate to Labels 
 * They will be split into sections depending on what that 
 * class is supposed to be used for 
 * 
 * It Follows a Organization Convention 
 * The first word in a name is which page it is for 
 * so if HOME is the first word then it is for the homePage
 * the second word refers if it is for the header or center panel
 * so for header its H and for center its C.
 * The last name before the name of the variable is for what JSwing component
 * it is used for, so for a Label it would be 
 * L
 * @author vahet
 *
 */
public final class Constants {
	
	/**
	 * HOME PAGE 
	 */
		/*
		 * HEADER CONSTANTS 
		 */
		 	//JLABEL for main text
	public static final String HOME_H_L_TEXT="CALIBRI VINYLS";
	public static final int HOME_H_L_XCORD = 0;
	public static final int HOME_H_L_YCORD = 0;
	public static final int HOME_H_L_XWIDTH = 800;
	public static final int HOME_H_L_YLENGTH = 800;
	public static final Font HOME_H_L_FONT = new Font("Calibri", Font.BOLD ,60);
	public static final Color HOME_H_L_COLOR = Color.white;
		
			//JBUTTON for search button
	
	public static final int HOME_H_B_XBUTTONLOC = ScreenSize.xDim/2;
	public static final int HOME_H_B_YBUTTONLOC = ScreenSize.yDim/10;
	public static final String HOME_H_B_SEARCHBUTTONTEXT = "Search"; 
	
			//PANEL for main header panel
	
	public static final Dimension HOME_H_P_PANELDIM = ScreenSize.createDim(2,3);
	public static final Color HOME_H_P_BACKGROUNDCOLOR = new Color(42, 40, 40);
	
			// JTEXTFIELD Constants
	
	public static final String HOME_H_TF_TEXT = "Search for Albums...";
	public static final Dimension HOME_H_TF_DIMENSION = ScreenSize.createDim(8, 30);
	public static final Color HOME_H_TF_BORDERCOLOR = Color.RED;
	public static final int HOME_H_TF_BORDERWIDTH = 3;
	
		

	/**
	 *  LOGIN PAGE 
	 */
		/*
		 * 
		 */
	
	
	
}
