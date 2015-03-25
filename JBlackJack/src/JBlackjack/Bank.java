package JBlackjack;

public class Bank {
	// Variablen deklarieren
	private static int kontostand = 500;
	private static int Einsatz = 20;

	// Methoden

	public static String gewinnerErmitteln() {
		int dealer = Dealer.getdealerKartenwert(0);
		int spieler = Spieler.getspielerKartenwert(0);
		String gewinner = null;

		if (dealer >= spieler) {
			if (dealer < 22 ) {
				int RAM = Einsatz;
				Einsatz = Einsatz - Einsatz - Einsatz;
				kontostandanpassen(Einsatz);
				Einsatz = RAM;
				System.out.println(kontostand);
				gewinner = "Dealer";

			} else {
				kontostandanpassen(Einsatz);
				System.out.println(kontostand);
				gewinner = "Spieler";
			}
			return gewinner;
		}
		if (spieler >= dealer) {
			if (spieler < 22) {
				kontostandanpassen(Einsatz);
				System.out.println(kontostand);
				gewinner = "Spieler";

			} else{
				int RAM = Einsatz;
				Einsatz = Einsatz - Einsatz - Einsatz;
				kontostandanpassen(Einsatz);
				Einsatz = RAM;
				System.out.println(kontostand);
				gewinner = "Dealer";
			}
		}
		return gewinner;
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
