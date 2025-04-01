package main;
import java.io.FileNotFoundException;

import backend.*;
import gui.*;
//Main where every package is called to make website work 
public class Main {
		
	public static void main(String[] args) {
			
			try {
				ProductListingPage commercePage = new ProductListingPage();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


	}

}
