package pakke;

public class Spiller {
	
	private int spillerNr;
	private Rute rute;
	
	public Spiller(int spillerNr) {
		this.spillerNr = spillerNr;
	}

	public int getSpillerNr() {
		return spillerNr;
	}

	public void setSpillerNr(int spillerNr) {
		this.spillerNr = spillerNr;
	}

	public Rute getRute() {
		return rute;
	}

	public void setRute(Rute rute) {
		this.rute = rute;
	}
	
	
}
