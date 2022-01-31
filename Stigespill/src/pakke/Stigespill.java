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

		while (antallSpillere < 2 || antallSpillere > 100) {
			antallSpillere = Integer
					.parseInt(JOptionPane.showInputDialog("Antall spillere m� v�re mellom 2 og 4!\nAntall spillere:"));
		}

		this.antallSpillere = antallSpillere;

		spillere = new Spiller[antallSpillere];
		this.brett = new Brett(100);

		for (int i = 0; i < antallSpillere; i++) {
			spillere[i] = new Spiller(i + 1, this);
		}

		this.terning = new Terning();
		this.ferdig = false;

		System.out.println("Stigespill opprettet med " + antallSpillere + " spillere!");

	}

	/**
	 * Starter spillet
	 */

	public void start() {

		System.out.println("Stigespille startet!");

		while (!this.ferdig) {

			for (int i = 0; i < antallSpillere; i++) {
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				if (!ferdig)
					spillere[i].spillTrekk();
				if (spillere[i].getRute() >= 100) {
					System.out.println("Gratulerer spiller nr. " + spillere[i].getSpillerNr()
							+ "!! Du har vunnet spillet\nAvslutter...");
					ferdig = true;
				}

			}

		}
		if (!ferdig)
			System.out.println("Ny runde");
		else {
			System.out.println();
			for (int i = 0; i < antallSpillere; i++) {
				System.out.println("Spiller nr. " + (i + 1)+ " kom p� plass:" + spillere[i].getRute());
			}
		}

	}

	/**
	 * Spiller gj�r et trekk + sjekk om hvor mange 6-ere spiller triller
	 */

	public Brett getBrett() {
		return brett;
	}

	public Terning getTerning() {
		return terning;
	}
	
	public int antallSpillere() {
		return antallSpillere;
	}
}
