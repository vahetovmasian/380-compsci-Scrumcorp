/**
 * 
 */
package gui.swingfactory;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import gui.ScreenSize;
import gui.swingfactory.Constants;

/**
 * JTextField Factory, makes different JTextFields
 * @author vahet
 *
 */
public class JTextFieldFactory {

	
	public static JTextField defaultHeaderTextField() {
		JTextField text = new JTextField(Constants.HOME_H_TF_TEXT);
		text.setMaximumSize(Constants.HOME_H_TF_DIMENSION);
		text.setBorder(BorderFactory.createLineBorder(
				Constants.HOME_H_TF_BORDERCOLOR, Constants.HOME_H_TF_BORDERWIDTH));
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		return text;
		
	}
	
}


