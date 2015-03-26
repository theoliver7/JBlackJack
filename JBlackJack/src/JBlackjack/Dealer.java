package JBlackjack;

import java.util.ArrayList;

public class Dealer {
	// ==================== Variablen deklarieren ====================
	static ArrayList<Karte> dealerHand = new ArrayList<Karte>();
	static int dealerkartenwert = 0;
	
	
	// ==================== Methoden ====================	
	
	/*
	 * Diese Methode list die oberste Karte des erstellten Kartenstapel aus, fügt dessen Wert dem der 
	 * Dealerhand hinzu, und löscht die oberste Karte aus dem Stapel
	 */
	public static void dealer_kartenehmen() {
		Kartenstapel.obersteKarte = Kartenstapel.getKartenstappel().get(0);
		Kartenstapel.getKartenstappel().remove(Kartenstapel.obersteKarte);
		setdealerHand();
		setdealerkKartenwert(Kartenstapel.obersteKarte.getWert());
	}

	
	// ==================== Getter und Settermethoden ====================
	public static ArrayList<Karte> getdealerHand(ArrayList<Karte> dealerHand) {
		return Dealer.dealerHand = dealerHand;
	}
	
	/*
	 * Hier wird der Dealerhand die oberste Karte hinzugefügt
	 */
	public static ArrayList<Karte> setdealerHand() {
		dealerHand.add(Kartenstapel.obersteKarte);
		return dealerHand;
	}

	/*
	 * Hier sind 2 Gettermethoden möglich
	 * Ist verändern = 0 so wird der wert ausgegeben
	 * Ist verändern = 1 so wird der Wert auf 0 gesetzt
	 */
	public static int getdealerKartenwert(int veraendern) {
		if (veraendern == 1) {
			dealerkartenwert = 0;
			return dealerkartenwert;
		} else {
			return dealerkartenwert;
		}
	}
	
	/*
	 * Hier wird der Wert der Karten des Spielers aktualisiert
	 */
	public static int setdealerkKartenwert(int wert) {
		dealerkartenwert = dealerkartenwert + wert;
		return dealerkartenwert;
	}

}
