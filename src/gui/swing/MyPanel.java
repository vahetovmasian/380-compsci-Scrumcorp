package gui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import gui.ScreenSize;

public class MyPanel extends JPanel {
	ScreenSize helper= new ScreenSize();
	public MyPanel(){
		
	}
	// constructor with standard parameters 
	public MyPanel(Color color,int xDimR, int YDimR, LayoutManager layout  ){
		
		setBackground(color);
		setPreferredSize(helper.createDim(xDimR,YDimR));
		setLayout(layout);
	}
	// Creates a JPanel that is designed to put space between two other JPanels
	public JPanel createSpacer(int xDimRatio, int yDimRatio) {
		   JPanel spacer = new JPanel();
		   spacer.setBackground(Color.WHITE);
		   spacer.setPreferredSize(helper.createDim(xDimRatio,yDimRatio));
		   return spacer;
	}
	public void revalidateMyPanel(){
		revalidate();
	}
	public void repaintMyPanel(){
		repaint();
	}
	
}
