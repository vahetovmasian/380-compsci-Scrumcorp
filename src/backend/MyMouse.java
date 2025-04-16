package backend;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MyMouse {

	public MyMouse(JPanel panel) {
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		        System.out.println("Clicked");
			}
		});
	}
	
	
}
