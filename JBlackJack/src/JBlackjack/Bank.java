package JBlackjack;

public class Bank {
	// Variablen deklarieren
	private static int kontostand = 500;
	private static int Einsatz = 20;
	// Methoden

	public static void gewinnerErmitteln() {
		int dealer = Dealer.getdealerKartenwert();
		int spieler = Spieler.getspielerKartenwert();

		if (dealer <= spieler) {
			System.out.println("Der Spieler hat gewonnen");
			kontostandanpassen(Einsatz);
			System.out.println(kontostand);
		}
		else {
			System.out.println("Der Dealer hat gewonnen");
			int RAM = Einsatz;
			Einsatz = Einsatz - Einsatz - Einsatz;
			kontostandanpassen(Einsatz);
			Einsatz = RAM;
			System.out.println(kontostand);
		}
	}
	public static int einsatzErhoehen(int eingesetzt) {
		Einsatz = Einsatz + eingesetzt;
		return Einsatz;
	}
	public static int getEinsatz() {
		return Einsatz;
	}
	public static void setEinsatz(int einsatz) {
		Einsatz = einsatz;
	}
	public static int kontostandanpassen(int einsatz) {
		kontostand = kontostand + einsatz;
		return kontostand;
	}

	/*
	 * Getter und Settermethoden
	 */
	public static int getKontostand() {
		return kontostand;
	}

	public void setKontostand(int kontostand) {
		Bank.kontostand = kontostand;
	}

}
