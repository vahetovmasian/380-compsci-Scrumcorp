package gui.swingfactory;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import gui.swingfactory.Constants;

/** Button Factory: Makes different Jbuttons
 * 
 * @author Vahet 
 *
 */
public class JButtonFactory {
	
	// MULTIPLE PAGES 
	public static JButton defaultHeaderButton() { 
		JButton searchButton = new JButton(Constants.HOME_H_B_SEARCHBUTTONTEXT);
		   searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		   return searchButton;
	}
	// HOME PAGE 
	public static JButton loginButton() {
		ImageIcon defaultimage = new ImageIcon("./src/gui/images/userIcon.png");
		ImageIcon hoveredimage = new ImageIcon("./src/gui/images/userIconDark.png");
		testLoginButton(defaultimage);
		JButton login = new JButton(defaultimage);
		login = makeBackgroundInvisible(login);
		login.setAlignmentX(Component.RIGHT_ALIGNMENT);
		MouseListenerFactory.addDarkeningEffectWhenHovered(login, hoveredimage, defaultimage );
		return login;
	}
	
	public static JButton shopingCartButton() {
		ImageIcon defaultimage = new ImageIcon("./src/gui/images/shoppingCartIcon.png");
		ImageIcon hoveredimage = new ImageIcon("./src/gui/images/userIconDark.png");
		testLoginButton(defaultimage);
		JButton shop = new JButton(defaultimage);
		shop = makeBackgroundInvisible(shop);
		shop.setAlignmentX(Component.RIGHT_ALIGNMENT);
		MouseListenerFactory.addDarkeningEffectWhenHovered(shop, hoveredimage, defaultimage );
		return shop;
	}
	
	
	
	private static JButton makeBackgroundInvisible(JButton button) {
		button.setBorderPainted(false);
		button.setContentAreaFilled(false); // no button "fill" color
		button.setFocusPainted(false);    // no focus rectangle (ugly dotted line when clicked)
		button.setOpaque(false);  
		return button;
	}
	

	
	
	
	private static void testLoginButton(ImageIcon image) {
		System.out.println(image.getIconWidth() + " x " + image.getIconHeight());
		System.out.println("if -1 x -1 then image didnt load properly");
	}
	
}
