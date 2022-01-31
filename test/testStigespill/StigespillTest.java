package testStigespill;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import pakke.Brett;
import pakke.Spiller;
import pakke.Stigespill;
import pakke.Terning;

public class StigespillTest {
	
	
	/**
	 * tester trill
	 */

	@Test
	public void testTrill() {

		Terning dice = new Terning();
		dice.trill();
		int value = dice.getVerdi();
		assertTrue("value between 1 and 6", value <= 6 && value >= 1);
	}

	@Test
	public void testSjekkRute() {
		int sjekk = 20;
		Brett brett = new Brett(100);
		assertTrue(sjekk == brett.sjekkRute(sjekk));
		
	}
	@Test
	public void testTilfeldigrute() {
		Random r = new Random();
		int value = r.nextInt(100);
		
		assertTrue("value between 0 and 99", value <= 99 && value >= 0);
		
	}
	
	@Test
	public void testAntallspillere() {
		
		Spiller[] spiller = new Spiller[4];
		int antallspillere = spiller.length;
		
		Stigespill stigespill = new Stigespill(antallspillere);
		
		assertTrue(stigespill.antallSpillere()== antallspillere);
		
		
	}
	

}
