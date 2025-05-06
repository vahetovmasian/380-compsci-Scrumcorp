package gui.page;

import javax.swing.JPanel;

import gui.DefaultHeaderPanel;
import gui.Page;
import gui.swingfactory.JPanelFactory;

public class HomePage extends Page {

	public JPanel createHeaderPanel() {
		DefaultHeaderPanel panel = new DefaultHeaderPanel();
		panel.makeDefaultPanel();
		return panel;
	}

	public JPanelFactory createBodyPanel() {
		return null;
	}


	public JPanelFactory addComponentsToMyFrame() {
		return null;
	}

}
