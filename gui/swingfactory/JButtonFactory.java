package gui.swingfactory;

import java.awt.Component;

import javax.swing.JButton;

import gui.HeaderPanel.defaultListener;
import gui.constants.HeaderConstants;

/** Button Factory: Makes different Jbuttons
 * 
 * @author Vahet 
 *
 */
public class JButtonFactory {

	public static JButton defaultHeaderButton() { 
		JButton searchButton = new JButton(HeaderConstants.SEARCHBUTTONTEXT);
		   searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		   return searchButton;
	}
}
