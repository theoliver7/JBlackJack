package JBlackjack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Spieler extends Person {

	// Variablen deklarieren
	private String SpielerName;
	private boolean entscheiden_S;
	private boolean spielbeenden;
	static int spielerKartenwert = 0;
	static ArrayList<Karte> spielerHand = new ArrayList<Karte>();
	private static String weitereKarte;
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	// Methoden
	public boolean entscheiden_S() {

		return entscheiden_S;
	}

	public static void spieler_kartenehmen() {
		Kartenstapel.obersteKarte = Kartenstapel.getKartenstappel().get(0);
		Kartenstapel.getKartenstappel().remove(Kartenstapel.obersteKarte);
		System.out.println("Spieler : ");
		System.out.println(getSpielerHand());
		System.out.println(getspielerKartenwert());
		System.out.println();
	}

	// Getter und Settermethoden
	public static int getspielerKartenwert() {
		spielerKartenwert = spielerKartenwert+ Kartenstapel.obersteKarte.getWert();
		spielerKartenwert = spielerKartenwert
				+ Kartenstapel.obersteKarte.getWert();
		if (spielerKartenwert > 21) {
			spielerKartenwert = 0;
			return spielerKartenwert;
		} else {
			return spielerKartenwert;
		}
	}

	public static void setSpielerKartenwert(int spielerKartenwert) {
		Spieler.spielerKartenwert = spielerKartenwert;
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

}
