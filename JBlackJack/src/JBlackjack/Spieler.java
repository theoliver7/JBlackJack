package JBlackjack;

import java.util.ArrayList;

public class Spieler {

	// ==================== Variablen deklarieren ====================
	private String SpielerName;
	private boolean spielbeenden;
	static int spielerKartenwert = 0;
	static ArrayList<Karte> spielerHand = new ArrayList<Karte>();
	private static String weitereKarte;

	// ==================== Methoden ====================
	
	/*
	 * Diese Methode list die oberste Karte des erstellten Kartenstapel aus, fügt dessen Wert dem der 
	 * Spielerhand hinzu, und löscht die oberste Karte aus dem Stapel
	 */
	public static void spieler_kartenehmen() {
		Kartenstapel.obersteKarte = Kartenstapel.getKartenstappel().get(0);
		Kartenstapel.getKartenstappel().remove(Kartenstapel.obersteKarte);
		getSpielerHand();
		setspielerKartenwert(Kartenstapel.obersteKarte.getWert());
	}

	// ==================== Getter und Settermethoden ====================
	
	/*
	 * Hier sind 2 Gettermethoden möglich
	 * Ist verändern = 0 so wird der wert ausgegeben
	 * Ist verändern = 1 so wird der Wert auf 0 gesetzt
	 */
	public static int getspielerKartenwert(int veraendern) {
		if (veraendern == 1) {
			spielerKartenwert = 0;
			return spielerKartenwert;
		} else {
			return spielerKartenwert;
		}
	}
	
	/*
	 * Hier wird der Wert der Karten des Spielers aktualisiert
	 */
	public static int setspielerKartenwert(int wert) {
		spielerKartenwert = spielerKartenwert + wert;
		return spielerKartenwert;
	}

	/*
	 * Hier wird der Spielerhand die oberste Karte hinzugefügt
	 */
	public static ArrayList<Karte> getSpielerHand() {
		spielerHand.add(Kartenstapel.obersteKarte);
		return spielerHand;
	}

	public static void setSpielerHand(ArrayList<Karte> spielerHand) {
		Spieler.spielerHand = spielerHand;
	}

	public String getSpielername() {
		return SpielerName;
	}

	public void setSpielername(String spielername) {
		SpielerName = spielername;
	}

	public boolean isSpielbeenden() {
		return spielbeenden;
	}

	public void setSpielbeenden(boolean spielbeenden) {
		this.spielbeenden = spielbeenden;
	}

	public static String getWeitereKarte() {
		return weitereKarte;
	}

	public static void setWeitereKarte(String weitereKarte) {
		Spieler.weitereKarte = weitereKarte;
	}

}
