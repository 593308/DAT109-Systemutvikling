package pakke;

import javax.swing.JOptionPane;

/**
 * 
 * @author MatiasRaknes
 *
 */

public class Stigespill {

	private Integer runder = 100;
	private Terning terning;
	private Brett brett;
	private boolean ferdig;
	private int antallSpillere;
	private Spiller[] spillere;

	/**
	 * angir data til spillet
	 */
	public Stigespill(int antallSpillere) {

		while (antallSpillere < 2 || antallSpillere > 4) {
			antallSpillere = Integer
					.parseInt(JOptionPane.showInputDialog("Antall spillere m� v�re mellom 2 og 4!\nAntall spillere:"));
		}

		this.antallSpillere = antallSpillere;

		spillere = new Spiller[antallSpillere];

		for (int i = 0; i < antallSpillere; i++) {
			spillere[i] = new Spiller(i + 1);
		}

		this.terning = new Terning();
		this.brett = new Brett(100);
		this.ferdig = false;

		System.out.println("Stigespill opprettet med " + antallSpillere + " spillere!");

	}

	/**
	 * Starter spillet
	 */

	public void spill() {

		System.out.println("Stigespille startet!");

		while (!this.ferdig) {

			for (int i = 0; i < antallSpillere; i++) {
				if (!ferdig)
					spillTrekk(spillere[i]);
			}
		}

	}
	
	/**
	 * Spiller gjør et trekk + sjekk om hvor mange 6-ere spiller triller
	 */

	public void spillTrekk(Spiller spiller) {
		int terning = 6;

		int i = 0;
		while (terning == 6 && i < 2) {
			i++;
			// terning = this.terning.trill();
			terning = 5;
			System.out.println("Spiller nr. " + spiller.getSpillerNr() + " trillet " + terning
					+ "!!\n-Flytter brikke til plass " + spiller.getRute() + terning);

			spiller.setRute(brett.getRuter()[spiller.getRute().getRuteNummer() + terning]);

			brett.sjekkRute(spiller.getRute().getRuteNummer());

		}

		if (i == 3) {
			System.out.println("�NEI, spiller " + spiller.getSpillerNr()
					+ " trillet 6, hele tre ganger p� rad! Du havner tilbake p� rute 1 :((((");

		} else if (spiller.getRute().getRuteNummer() == 99) {

			System.out.println("Gratulerer spiller nr. " + spiller.getSpillerNr() + "!! Du har vunnet spillet!");
			this.ferdig = true;

		}

	}
}
