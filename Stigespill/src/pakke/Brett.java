package pakke;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author MatiasRaknes
 *
 */

public class Brett {

	private int[] ruter;
	private Map<Integer, Integer> slangerOgStiger;

	/**
	 * lager brettet
	 */

	public Brett(int antallRuter) {

		this.ruter = new int[antallRuter];

		slangerOgStiger = new HashMap<Integer, Integer>();

		for (int i = 0; i < antallRuter; i++) {
			ruter[i] = i;
		}

		for (int i = 0; i < 8; i++) {
			opprettStiger();

		}
		for (int i = 0; i < 12; i++) {

			opprettSlanger();
		}

	}

	/**
	 * TODO
	 */
	private void opprettSlanger() {
		boolean opptatt = false;

		do {

			Random r = new Random();
			int fra = tilfeldigRute() + 2;
			int til = r.nextInt(fra - 1) + 1;

			opptatt = false;

			if (fra <= 10 || (fra / 10 - til / 10) == 0) {
				opptatt = true;
			}

			if (slangerOgStiger.containsKey(fra) || opptatt || fra == 100)
				opptatt = true;
			else {
				this.slangerOgStiger.put(fra, til);
				opptatt = false;
				System.out.println("Slange opprettet fra " + fra + " til " + til);
			}

		} while (opptatt);
	}

	private void opprettStiger() {
		boolean opptatt = false;

		do {

			Random r = new Random();
			int fra = tilfeldigRute();
			int til = r.nextInt(100 - fra) + fra;

			opptatt = false;

			if (fra > 90 || (til / 10 - fra / 10) == 0) {
				opptatt = true;
			}

			if (slangerOgStiger.containsKey(fra) || opptatt)
				opptatt = true;
			else if(slangerOgStiger.containsKey(slangerOgStiger.get(fra)))
				opptatt = true;
			else {
				this.slangerOgStiger.put(fra, til);
				opptatt = false;
				System.out.println("Stige opprettet fra " + fra + " til " + til);
			}

		} while (opptatt);

	}

	private Integer tilfeldigRute() {
		Random r = new Random();
		int rute = r.nextInt(100);
		return rute;

	}

	/**
	 * Sjekker rute, er det en spesiell rute
	 */
	public int sjekkRute(int rute) {
		if (slangerOgStiger.containsKey(rute)) {
			if (slangerOgStiger.get(rute) > rute)
				System.out.println(
						"Grattis! Du har landet på en stige og blir flyttet til plass " + slangerOgStiger.get(rute));
			else
				System.out.println("Wooops, du har havnet på en slange og blir flyttet tilbake til plass "
						+ slangerOgStiger.get(rute));

			return slangerOgStiger.get(rute);

		}

		return rute;
	}

	public int[] getRuter() {
		return ruter;
	}
}
