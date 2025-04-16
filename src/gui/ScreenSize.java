package gui;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


/**
 * @author vahet
 *	This class handles Getting information about the users screensize and passing 
 *  it to other methods
 */
public class ScreenSize {
    public int yDim;
    public int xDim;
	public ScreenSize() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		 xDim = gd.getDisplayMode().getWidth();
		 yDim = gd.getDisplayMode().getHeight();
	}
	// this gets the Y dimension of the users screen
	public int getYDim(){
		
		return yDim;
	}
	// this gets the X dimension of the users screen
	public int getXDim(){
		
		return xDim;
	}
	public Dimension createDim(int xDimRatio, int yDimRatio) {
		   ScreenSize myScreen= new ScreenSize();
		   Dimension myMonitorsDimensions= new Dimension(xDim/xDimRatio
				   , myScreen.yDim/yDimRatio );
		   return myMonitorsDimensions;
	   }
	
	
}
