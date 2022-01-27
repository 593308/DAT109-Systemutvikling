package pakke;

import java.util.HashMap;

public class Brett {
	
	private HashMap<Rute, Integer> slangerOgStiger;
	private Rute[] ruter;
	
	public Brett(int antallRuter) {
		
		this.ruter = new Rute[antallRuter];
		
		for (int i = 0; i < antallRuter; i ++) {
			ruter[i] = new Rute(i);
		}
		
		opprettStiger();
		opprettSlanger();
	}
	
	
	private void opprettStiger() {
		this.slangerOgStiger.put(ruter[4], 100 - 1);
	}
	

	private void opprettSlanger() {
	}
	
	

	public HashMap<Rute, Integer> getSlangerOgStiger() {
		return slangerOgStiger;
	}
	
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
