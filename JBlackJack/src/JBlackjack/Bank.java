package JBlackjack;

public class Bank {
	// ==================== Variablen deklarieren ====================
	private static int kontostand = 500;
	private static int einsatz;
	private static String gewinner;

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

		if (dealer > 21 && spieler > 21) {
			gewinner="Beide Spieler haben einen zu grossen Kartenwert";
		} else {

			if (spieler == dealer) {

				if (Spieler.getspielerKartenwert(0) <= 21 && Dealer.getdealerKartenwert(0) <= 21) {
					gewinner = "Beide Spieler haben den gleichen Kartenwert";
				}
			} else {

				if (dealer >= spieler && dealer < 22 || spieler > 21) {

					int RAM = einsatz;
					einsatz = einsatz - einsatz - einsatz;
					kontostandanpassen(einsatz);
					einsatz = RAM;
					gewinner = "Der Dealer hat gewonnen, zieh eine Karte um eine neue Runde zu beginnen";

				} else {
					kontostandanpassen(einsatz);
					gewinner = "Du hast gewonnen, zieh eine Karte um eine neue Runde zu beginnen";
				}
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
		einsatz = eingesetzt;
		return einsatz;
	}

	// ==================== Getter und Settermethoden ====================

	public static int getEinsatz() {
		return einsatz;
	}

	public static void setEinsatz(int Einsatz) {
		einsatz = Einsatz;
	}

	public static int getKontostand() {
		return kontostand;
	}

	public static void setKontostand(int kontostand) {
		Bank.kontostand = kontostand;
	}

	public static String getGewinner() {
		return gewinner;
	}

	public static void setGewinner(String gewinner) {
		Bank.gewinner = gewinner;
	}

}
