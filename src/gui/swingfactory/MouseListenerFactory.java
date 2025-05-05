package gui.swingfactory;
/** 
 * MyMouse object which handles gui components
 * being clicked (ones that already don't by default
 * have it handled like Jbutton ) 
 * 
 * @author Vahet
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MouseListenerFactory {
	/**
	 * Constructs MyMouse which is an event listner adding onto
	 * the passed JPanel.
	 * @param panel :the panel which checking to see if clicked 
	 * 
	 */
	// still needs more implementation than Clicked:
	public MouseListenerFactory(JPanel panel) {
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		        System.out.println("Clicked");
			}
		});
	}
	protected static JButton addDarkeningEffectWhenHovered(JButton button, ImageIcon darkImage,
			ImageIcon normalImage) {
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				button.setIcon(darkImage);
			}
			public void mouseExited(MouseEvent e) {
				button.setIcon(normalImage);
			}
		});
		return button;
	}
	
	
}
