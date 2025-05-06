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

import gui.ScreenSize;

	public class JLabelFactory  {
	 
		public static void JLabel() {
			
		}

		public static JLabel defaultHeaderLabel() {
				JLabel label = new JLabel(Constants.HOME_H_L_TEXT);
				label.setForeground(Constants.HOME_H_L_COLOR);
				label.setBounds(Constants.HOME_H_L_XCORD, Constants.HOME_H_L_YCORD, 
						Constants.HOME_H_L_XWIDTH , Constants.HOME_H_L_YLENGTH);
				label.setFont(Constants.HOME_H_L_FONT);
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				return label;
			}
		
		public static JLabel defaultLogoLabel() {
			ImageIcon logo = new ImageIcon("./src/gui/images/frameIcon.png");
			
			JLabel imageLabel = new JLabel(JButtonFactory.resizeImages(logo));
			
				
			
				
			return imageLabel;
		}
		
					
}
