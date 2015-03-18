package JBlackjack;

public class Bank {
	// Variablen deklarieren
	private static int kontostand = 500;

	// Methoden

	public static void gewinnerErmitteln() {
		int dealer = Dealer.getdealerKartenwert();
		int spieler = Spieler.getspielerKartenwert();

		if (dealer <= spieler) {
			System.out.println("Der Spieler hat gewonnen");
			kontostandanpassen(+10);
			System.out.println(kontostand);
		}
		else {
			System.out.println("Der Dealer hat gewonnen");
			kontostandanpassen(-10);
			System.out.println(kontostand);
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
