package gui;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


/**
 * @author vahet
 *	This class handles Getting information about the users screensize and passing 
 *  it to other methods
 */
public final class ScreenSize {
    public static int yDim;
    public static int xDim;
    
	private ScreenSize() {
		// Empty 
	}
	// this gets the Y dimension of the users screen
	static public int getYDim(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		yDim = gd.getDisplayMode().getHeight();
		return yDim;
	}
	// this gets the X dimension of the users screen
	static public int getXDim(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		 xDim = gd.getDisplayMode().getWidth();
		
		return xDim;
	}
	static public Dimension createDim(int xDimRatio, int yDimRatio) {
		   Dimension myMonitorsDimensions= new Dimension(getXDim()/xDimRatio
				   , getYDim()/yDimRatio );
		   return myMonitorsDimensions;
	}
	/**
	 * 	This returns the size of screen divided by 
	 */
	static public int xRatio(int x) {
		return getXDim()/x;
	}
	static public int yRatio(int y) {
		return getXDim()/y;
	}
	
	
}
