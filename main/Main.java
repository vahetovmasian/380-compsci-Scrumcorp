package main;
import java.io.FileNotFoundException;

import backend.*;
import backend.SQL.SQLconnector;
import gui.*;
import gui.page.ProductListingPage;
/**
 * Main where every package is called to make website work 
 * @author vahet EthanG
 *
 */
public class Main {
		
	public static void main(String[] args) {
		
			/**
			 * NEEDS TO BE REFRACTORED
			 * currently works by directly making a commercePage, but should 
			 * not work like this in future this is mainly for testing gui components
			 * 
			 */
		
		
		
			try {
				GUIMain.startGUI();
				System.out.println("GUI working :)");
			} catch (Exception e) {
				System.out.println("GUI failed :(");
			}
			


	}

}
