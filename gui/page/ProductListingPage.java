package gui.page;
import  backend.Product;
import gui.HeaderPanel;
import gui.Page;
import gui.productPanel;
import gui.swingfactory.JFrameFactory;
import gui.swingfactory.JPanelFactory;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
/**NEEDS TO BE REFRACTORED 
 * Page for handling product listing, which shows all of the products
 * and allows the user to scroll through them
 * @author vahet EthanG
 */
public class ProductListingPage extends Page {
	
    public ProductListingPage()   {
    	
    }

	@Override
	public JPanel createHeaderPanel() {
		HeaderPanel panel= new HeaderPanel();
		return panel;
	}

	@Override
	public JPanelFactory createBodyPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPanelFactory addComponentsToMyFrame() {
		// TODO Auto-generated method stub
		return null;
	}
    	
   
    
    
}
