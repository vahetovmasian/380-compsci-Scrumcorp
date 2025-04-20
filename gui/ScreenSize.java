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
		   ScreenSize myScreen= new ScreenSize();
		   Dimension myMonitorsDimensions= new Dimension(xDim/xDimRatio
				   , myScreen.yDim/yDimRatio );
		   return myMonitorsDimensions;
	   }
	
	
}
