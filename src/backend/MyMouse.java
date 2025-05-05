package backend;
/** 
 * MyMouse object which handles gui components
 * being clicked (ones that already don't by default
 * have it handled like Jbutton ) 
 * 
 * @author Vahet
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MyMouse {
	/**
	 * Constructs MyMouse which is an event listner adding onto
	 * the passed JPanel.
	 * @param panel :the panel which checking to see if clicked 
	 * 
	 */
	// still needs more implementation than Clicked:
	public MyMouse(JPanel panel) {
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		        System.out.println("Clicked");
			}
		});
	}
	
	
}
