package pakke;

import java.util.Scanner;
/** 
 * 
 * @author MatiasRaknes
 *
 */

public class Main {
	
	public static void main(String[] args) {
		
		/**
		 * starter spillet og angir hvor mange som skal være med 
		 */
		System.out.println(Terning.trill());
		
		Stigespill spill = new Stigespill(5);
		
		spill.spill();
		
	
		
	}

}
