/**
 * 
 */
package gui.swingfactory.constants;

import java.awt.Color;
import java.awt.Dimension;

import gui.ScreenSize;

/**
 * Class that just holds all the constants for TextFieldFactory since
 * there are alot, in the future will probably make 
 * more classes like this to hold constants
 * https://en.wikipedia.org/wiki/Constant_interface
 * where I got idea to do this 
 * @author vahet
 *
 */
public class TextFieldConstants {

	
	/*
	 * Default header panel TextField Constants 
	 */
	public static final String JTEXTFTEXT = "Search for Albums...";
	public static final Dimension TEXTFDIMENSION = ScreenSize.createDim(8, 30);
	public static final Color TEXTFBORDERCOLOR = Color.RED;
	public static final int TEXTFBORDERWIDTH = 3;
}
