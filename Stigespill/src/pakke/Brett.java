package pakke;

import java.util.HashMap;

/** 
 * 
 * @author MatiasRaknes
 *
 */

public class Brett {
	
	private HashMap<Rute, Integer> slangerOgStiger;
	private Rute[] ruter;
	
	/**
	 * lager brettet
	 */
	
	public Brett(int antallRuter) {
		
		this.ruter = new Rute[antallRuter];
		
		for (int i = 0; i < antallRuter; i ++) {
			ruter[i] = new Rute(i);
		}
		
		opprettStiger();
		opprettSlanger();
	}
	/**
	 * 
	 */
	
	private void opprettStiger() {
		this.slangerOgStiger.put(ruter[4], 100 - 1);
	}
	

	/**
	 *  TODO
	 */
	private void opprettSlanger() {
	}
	
	
	
	
	
	/**
	 * TODO
	 */
	public HashMap<Rute, Integer> getSlangerOgStiger() {
		return slangerOgStiger;
	}
	
	/**
	 * Sjekker rute, er det en spesiell rute
	 */
	
	public Rute sjekkRute(int ruteNr) {
		
		Rute rute = ruter[ruteNr];
		
		
		if (slangerOgStiger.containsKey(rute)) {
			return ruter[slangerOgStiger.get(rute)];
		} 
		
		
	}
	
	public Rute[] getRuter() {
		return ruter;
	}
}
