/**
 * 
 */
package gui.swingfactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author vahet
 *
 */
public class ActionListenerFactory {
	  
	   public static class LoginButton implements ActionListener {
 			public void actionPerformed(ActionEvent e) {
 				
 				System.out.println("Login needs to be implemeneted");
 			}
 	   }
	   
	   public static class ShopingButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("shopping needs to be implemeneted");
			}
	   }
	   
	   
	   public static class DefaultSearchButton implements ActionListener {
 			public void actionPerformed(ActionEvent e) {
 				System.out.println("You clicked default Search Button");
 			}
 	   }
	   
}
