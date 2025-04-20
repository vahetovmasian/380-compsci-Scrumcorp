package gui.swingfactory;
/**
 * JLabel Factory, makes different JLabels
 * 
 * @author Vahet 
 */
import java.awt.Color;
/**
 * A custom JLabel that has more parameters in its constructor
 * @author vahet EthanG
 */
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import gui.swingfactory.constants.LabelConstants;

	public class JLabelFactory  {
	 
		public static void JLabel() {
			
		}

		public static JLabel defaultHeaderLabel() {
				JLabel label = new JLabel(LabelConstants.TEXT);
				label.setForeground(LabelConstants.COLOR);
				label.setBounds(LabelConstants.XCORD, LabelConstants.YCORD, 
						LabelConstants.XWIDTH , LabelConstants.YLENGTH);
				label.setFont(LabelConstants.FONT);
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				return label;
			}
						
}
