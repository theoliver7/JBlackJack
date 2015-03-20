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
		System.out.println(Kartenstapel.Kartenstappel);
		Dealer.dealer_kartenehmen();
		
		
		
		System.out.println(Kartenstapel.Kartenstappel);
	}

	public void verwerfen() {
	}

	public static int assUeberpruefung(int wert) {
		String ass_ueberpruefung;
		if (wert == 11) {
			System.out.println("Ass = true");
			ass_ueberpruefung = "true";
		} else {
			ass_ueberpruefung = "false";
		}
		return wert;
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
