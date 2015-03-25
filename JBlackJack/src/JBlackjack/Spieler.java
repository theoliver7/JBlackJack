package JBlackjack;

import java.util.ArrayList;

public class Spieler extends Person {

	// Variablen deklarieren
	private String SpielerName;
	private boolean entscheiden_S;
	private boolean spielbeenden;
	static int spielerKartenwert = 0;
	static ArrayList<Karte> spielerHand = new ArrayList<Karte>();
	private static String weitereKarte;

	// Methoden
	public boolean entscheiden_S() {

		return entscheiden_S;
	}

	public static void spieler_kartenehmen() {
		Kartenstapel.obersteKarte = Kartenstapel.getKartenstappel().get(0);
		Kartenstapel.getKartenstappel().remove(Kartenstapel.obersteKarte);
		System.out.println("Spieler : ");
		System.out.println(getSpielerHand());
		System.out.println(setspielerKartenwert(Kartenstapel.obersteKarte.getWert()));
		System.out.println();
	}

	// Getter und Settermethoden
	public static int getspielerKartenwert(int veraendern) {
		if (veraendern == 1) {
			spielerKartenwert = 0;
			return spielerKartenwert;
		} else {
			return spielerKartenwert;
		}
	}

	public static int setspielerKartenwert(int wert) {
		spielerKartenwert = spielerKartenwert + wert;
		return spielerKartenwert;
	}

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
