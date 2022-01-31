package pakke;

/**
 * 
 * @author MatiasRaknes
 *
 */

public class Spiller {

	private int spillerNr;
	private int rute;
	private Stigespill spill;
	private boolean trash;

	public Spiller(int spillerNr, Stigespill spill) {
		this.spillerNr = spillerNr;
		this.spill = spill;
		rute = 0;
		trash = false;
	}

	public void spillTrekk() {

		int terning = 6;

		int i = 0;
		
		System.out.println("Spiller nr. " + spillerNr);

		if (trash) {
			System.out.println("Du er trash, du må trille 6 for å fjerne denne forbannelsen og komme deg videre! >:D");
		}

		while (terning == 6 && i < 3 && rute < 100) {
			
			if (i > 0)
				System.out.println("Du har trillet 6, så du kan trille igjen :D");
			i++;

			spill.getTerning().trill();
			terning = this.spill.getTerning().getVerdi();

			if (terning != 6 && trash) {
				System.out.println("Still trash...");
				break;
			} else if (trash) {
				trash = false;
				System.out.println("Grattis luring ;) Du er ikke lenger trash, og du kan komme deg videre");

			}

			int nyRute = rute + terning;



			if (nyRute > 100) {
			System.out.println("-Du trillet " + terning + ". Du må trille nøyaktig " + (100 - rute) + " for å vinne spillet, prøv neste runde ;)"
					);
			
			}
			else {	
			System.out.println(
					"-Du trillet " + terning + "!!\nFlytter brikke din fra " + rute + " til " + nyRute);
			rute = nyRute;
			rute = this.spill.getBrett().sjekkRute(rute);
			}


		}

		if (i == 3 && terning == 6) {
			trash = true;
			System.out.println("ÅNEI, spiller " + spillerNr
					+ " trillet 6, hele tre ganger på rad! Du havner tilbake på rute 1 :((((\n-Spiller nr. " + spillerNr
					+ " har blitt trash, skam deg");
			rute = 0;

		}
		System.out.println();
		
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getSpillerNr() {
		return spillerNr;
	}

	public int getRute() {
		return rute;
	}

	public Stigespill getSpill() {
		return spill;
	}

}
