package pakke;

import java.util.Scanner;

import javax.swing.JOptionPane;
/** 
 * 
 * @author MatiasRaknes
 *
 */

public class Main {
	
	public static void main(String[] args) {
		
		/**
		 * starter spillet og angir hvor mange som skal væree med 
		 */
		
		
		Stigespill spill = new Stigespill(Integer.parseInt(JOptionPane.showInputDialog("Velg antall spillere som skal spille")));
		
		spill.start();
		
	
		
	}

}
