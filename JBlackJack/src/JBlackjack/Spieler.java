package JBlackjack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Spieler extends Person {

	// Variablen deklarieren
	private String Spielername;
	private boolean entscheiden_S;
	private boolean spielbeenden;
	static int spielerkartenwert = 0;
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
		System.out.println();if (spielerkartenwert<21) 
		
		if (Dealer.dealerkartenwert <= 17 ) {	
			Dealer.dealer_kartenehmen();
			} else {
			Bank.gewinnerErmitteln();
		}
	}

	// Getter und Settermethoden
	public static int getspielerKartenwert() {
		spielerkartenwert = spielerkartenwert
				+ Kartenstapel.obersteKarte.getWert();
		if (spielerkartenwert > 21) {
			spielerkartenwert = 0;
			return spielerkartenwert;
		} else {
			return spielerkartenwert;
		}
	}

	public static void setspielerkartenwert(int spielerkartenwert) {
		Spieler.spielerkartenwert = spielerkartenwert;
	}

	public static ArrayList<Karte> getSpielerHand() {
		spielerHand.add(Kartenstapel.obersteKarte);
		return spielerHand;
	}

	public static void setSpielerHand(ArrayList<Karte> spielerHand) {
		Spieler.spielerHand = spielerHand;
	}

	public String getSpielername() {
		return Spielername;
	}

	public void setSpielername(String spielername) {
		Spielername = spielername;
	}

	public boolean isSpielbeenden() {
		return spielbeenden;
	}

	public void setSpielbeenden(boolean spielbeenden) {
		this.spielbeenden = spielbeenden;
	}
}
