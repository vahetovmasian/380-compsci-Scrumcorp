/**
 * 
 */
package gui.swingfactory;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import gui.ScreenSize;
import gui.constants.HeaderConstants;
import gui.swingfactory.constants.TextFieldConstants;

/**
 * JTextField Factory, makes different JTextFields
 * @author vahet
 *
 */
public class JTextFieldFactory {

	
	public static JTextField defaultHeaderTextField() {
		JTextField text = new JTextField(TextFieldConstants.JTEXTFTEXT);
		text.setMaximumSize(TextFieldConstants.TEXTFDIMENSION);
		text.setBorder(BorderFactory.createLineBorder(
				TextFieldConstants.TEXTFBORDERCOLOR,TextFieldConstants.TEXTFBORDERWIDTH));
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		return text;
	}
}
