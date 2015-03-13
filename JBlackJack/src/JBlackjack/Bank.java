package JBlackjack;

public class Bank {
	// Variablen deklarieren
	private int kontostand = 500;
	private String gewinner;

	// Methoden

	public int kontostandanzeigen() {

		return kontostand;
	}

	public String gewinnerermitteln() {
		int dealer = 1;
		int spieler = 2;

		if (dealer < spieler) {
			gewinner = "Der Spieler hat gewonnen";
			kontostandanpassen(-10);
			return gewinner;
		}

		else {
			gewinner = "Der Spieler hat gewonnen";
			kontostandanpassen(+10);
			return gewinner;
		}

	}

	public int kontostandanpassen(int einsatz) {
		kontostand = kontostand + einsatz;
		return kontostand;
	}

	/*
	 * Getter und Settermethoden
	 */
	public int getKontostand() {
		return kontostand;
	}

	public void setKontostand(int kontostand) {
		this.kontostand = kontostand;
	}

}
