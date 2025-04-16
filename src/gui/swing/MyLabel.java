package gui.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

	public class MyLabel extends JLabel {
	
		// This is MyLabel for 
		
		public MyLabel(String label, Font myfont, ImageIcon image, int VerticalTextPosition
				, int HorizontalTextPosition,  int HorizontalAlignment, Dimension dimensions
				, float alignment) {
			setText(label);
			setFont(myfont);
			setIcon(image);
			setVerticalTextPosition(VerticalTextPosition);
			setHorizontalTextPosition( HorizontalTextPosition);
			setHorizontalAlignment(HorizontalAlignment);
			setPreferredSize(dimensions);
			setAlignmentX(alignment);
		}
		
	
}
