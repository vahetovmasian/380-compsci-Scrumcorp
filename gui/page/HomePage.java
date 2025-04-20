package gui.page;

import javax.swing.JPanel;

import gui.HeaderPanel;
import gui.Page;
import gui.swingfactory.JPanelFactory;

public class HomePage extends Page {

	public JPanel createHeaderPanel() {
		HeaderPanel panel = new HeaderPanel();
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
