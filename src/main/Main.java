package main;
import backend.*;
import gui.*;
/**
 * Main where every package is called to make website work 
 * @author vahet EthanG
 *
 */
public class Main {
		
	public static void main(String[] args) {
	
			 
		 
			
		
			try {
				GUIMain.startGUI();
				System.out.println("GUI working :)");
			} catch (Exception e) {
				System.out.println("GUI failed :(");
			}
			


	}
	}

