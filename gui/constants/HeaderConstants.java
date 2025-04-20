package gui.constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import gui.ScreenSize;
/**
 * Class that just holds all the constants for Header since
 * there are alot, in the future will probably make 
 * more classes like this to hold constants
 * https://en.wikipedia.org/wiki/Constant_interface
 * where I got idea to do this 
 * @author vahet
 *
 */
public final class HeaderConstants {

		// Panel Constants
		public static final Dimension PANELDIM = ScreenSize.createDim(2,3);
		public static final Color BACKGROUNDCOLOR = Color.black;
	
	
		// JButton Constants 
		public static final int XBUTTONLOC = ScreenSize.xDim/2;
		public static final int YBUTTONLOC = ScreenSize.yDim/10;
		public static final String SEARCHBUTTONTEXT = "Search"; 
	
		
		// JTextField Constants
		
}

