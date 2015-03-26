package JBlackjack;

public class Bank {
	// Variablen deklarieren
	private static int kontostand = 500;
	private static int Einsatz = 0;

	// Methoden

	public static String gewinnerErmitteln() {
		int dealer = Dealer.getdealerKartenwert(0);
		int spieler = Spieler.getspielerKartenwert(0);
		String gewinner = null;
		int Einsatz = Integer.parseInt(Gui.einsatzt_feld.getText());

		if (spieler == dealer) {
			gewinner = "Beide Spieler haben den gleichen Kartenwertert";
		} else {

			if (dealer >= spieler && dealer < 22 || spieler > 21) {

				int RAM = Einsatz;
				Einsatz = Einsatz - Einsatz - Einsatz;
				kontostandanpassen(Einsatz);
				Einsatz = RAM;
				System.out.println(Einsatz);
				System.out.println(kontostand);
				gewinner = "Der Dealer hat gewonnen, zieh eine Karte um eine neue Runde zu beginnen";

			} else {
				System.out.println(Einsatz + "test");
				kontostandanpassen(Einsatz);
				System.out.println(kontostand);
				gewinner = "Du hast gewonnen, zieh eine Karte um eine neue Runde zu beginnen";
			}
		}

		return gewinner;
	}

	public static int einsatzErhoehen(int eingesetzt) {
		Einsatz = eingesetzt;
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

	public static void setKontostand(int kontostand) {
		Bank.kontostand = kontostand;
	}

}
