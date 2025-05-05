package gui.swingfactory;
/**
 * A custom JPanel that has more parameters in its constructor
 * and some methods to make other specific Jpanels with hardcoded
 * values that come up often
 * @author vahet EthanG
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gui.ScreenSize;

public class JPanelFactory extends JPanel {
	/**
	 * Empty constructor 
	 */
	public static JPanel productPanel(Color color,int xDimR, int YDimR, LayoutManager layout  ){
		JPanel helper= new JPanel();
		helper.setBackground(color);
		helper.setPreferredSize(ScreenSize.createDim(xDimR,YDimR));
		helper.setLayout(layout);
		return helper;
	}
	
	public static JPanel topHeaderLoginPage(JLabel topLabel, 
			JButton loginButton, JButton shopingButton) {
		JPanel topHalf = new JPanel();
		topHalf.setBackground(Constants.HOME_H_P_BACKGROUNDCOLOR);
		topHalf.setLayout(new BoxLayout(topHalf, BoxLayout.X_AXIS));
		topHalf.add(Spacer(Constants.HOME_H_P_SPACER_X_PRE_LABEL,Constants.HOME_H_P_SPACER_Y_LABEL));
		topHalf.add(JLabelFactory.defaultLogoLabel());
		topHalf.add(topLabel);
		topHalf.add(Spacer(Constants.HOME_H_P_SPACER_X_AFTER_LABEL,Constants.HOME_H_P_SPACER_Y_LABEL));
		topHalf.add(loginButton);
		topHalf.add(shopingButton);
		return topHalf;
	}
	
	
	/*
	  public static void addScrollWheel(JPanel panel) {
	    	 JScrollPane scrollPane = new JScrollPane(panel); 
	    	  scrollPane.setPreferredSize(new Dimension(xDim, yDim));
	          scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	          // need to change this or confirm its good (refering to the 20 being hard coded)
	          scrollPane.getVerticalScrollBar().setUnitIncrement(20);
	          add(scrollPane);
	    }
	/** 
	 * Creates a JPanel that is designed to put space between two other JPanels
	 * 
	 */
	public static  Component  Spacer(int xDimRatio, int yDimRatio) {
		   Component spacer = new JPanel();
		   spacer = Box.createRigidArea(ScreenSize.createDim(xDimRatio, yDimRatio));
		   return spacer;
	}

}
