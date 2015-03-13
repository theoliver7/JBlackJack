package JBlackjack;

public class Bank {
	// Variablen deklarieren
	private static int kontostand = 500;
	private static String gewinner;

	// Methoden

	public static int kontostandanzeigen() {
		System.out.println(kontostand);
		return kontostand;
	}

	public static String gewinnerermitteln() {
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

	public static int kontostandanpassen(int einsatz) {
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
		Bank.kontostand = kontostand;
	}

}
