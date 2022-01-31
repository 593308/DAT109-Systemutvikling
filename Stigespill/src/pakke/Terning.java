package pakke;

/**
 * 
 * @author MatiasRaknes
 *
 */

public class Terning {
	
	private int verdi;

	/**
	 * triller terning
	 */

	public void trill() {

		//return (int) (Math.random()*6 + 1);
		
		verdi = (int) (Math.random()*6 + 1);
		
	}
	
	public int getVerdi() {
		return verdi;
	}

}
