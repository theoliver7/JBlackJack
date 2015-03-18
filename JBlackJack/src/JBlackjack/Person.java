package JBlackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;

@SuppressWarnings("unused")
public abstract class Person {

	static ArrayList<Karte> aktuelleHand = new ArrayList<Karte>();

	// Methoden
	public static void main(String[] args) {
		Kartenstapel.stapelGenerieren();

		Spieler Oliver = new Spieler();
		Dealer Miguel = new Dealer();
		Dealer.dealer_kartenehmen();
	}

	public void verwerfen() {
	}

	public void assUeberpruefung() {
	}

	public void wertueberpruefung() {
	}

	// Getter und Settermethoden

	public static ArrayList<Karte> getAktuelleKarten() {
		aktuelleHand.add(Kartenstapel.obersteKarte);
		return aktuelleHand;
	}

	public void setAktuelleHand(Array aktuelleKarten) {
	}
}
