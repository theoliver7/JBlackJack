package JBlackjack;

public class Bank {
	// ==================== Variablen deklarieren ====================
	private static int kontostand = 500;
	private static int Einsatz = 0;

	// ==================== Methoden ====================

	/*
	 * Hier wird der Gewinner ermittelt
	 */
	public static String gewinnerErmitteln() {
		/*
		 * Hier werden die Kartenwerte der Spieler ausgelesen und gespeichert
		 * Ausserdem wird der Einsatz aus dem Textfeld geholt
		 */
		int dealer = Dealer.getdealerKartenwert(0);
		int spieler = Spieler.getspielerKartenwert(0);
		String gewinner = null;
		int Einsatz = Integer.parseInt(Gui.einsatzt_feld.getText());

		if (spieler == dealer) {

			if (Spieler.getspielerKartenwert(0) <= 21 && Dealer.getdealerKartenwert(0) <= 21) {
				gewinner = "Beide Spieler haben den gleichen Kartenwert";
			}
		} else {

			if (dealer >= spieler && dealer < 22 || spieler > 21) {

				int RAM = Einsatz;
				Einsatz = Einsatz - Einsatz - Einsatz;
				kontostandanpassen(Einsatz);
				Einsatz = RAM;
				gewinner = "Der Dealer hat gewonnen, zieh eine Karte um eine neue Runde zu beginnen";

			} else {
				kontostandanpassen(Einsatz);
				gewinner = "Du hast gewonnen, zieh eine Karte um eine neue Runde zu beginnen";
			}
		}
		return gewinner;
	}

	/*
	 * Hier wird der Kontostand angepasst Je nachdem ob man verloren oder
	 * gewonnen hat, wird dem Konto dann Geld abgezogen oder hinzugefügt
	 */
	public static int kontostandanpassen(int einsatz) {
		kontostand = kontostand + einsatz;
		return kontostand;
	}

	/*
	 * Hier wird der Einsatz festgelegt
	 */
	public static int einsatzErhoehen(int eingesetzt) {
		Einsatz = eingesetzt;
		return Einsatz;
	}

	// ==================== Getter und Settermethoden ====================

	public static int getEinsatz() {
		return Einsatz;
	}

	public static void setEinsatz(int einsatz) {
		Einsatz = einsatz;
	}

	public static int getKontostand() {
		return kontostand;
	}

	public static void setKontostand(int kontostand) {
		Bank.kontostand = kontostand;
	}

}
