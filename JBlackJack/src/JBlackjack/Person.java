package JBlackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Person {
	
	
	static ArrayList<Karte> aktuelleHand = new ArrayList<Karte>();
	// Methoden
	public static void main(String[] args) {
		Kartenstapel.stapelgenerieren();
		
		Spieler Oliver = new Spieler();
		Dealer Miguel = new Dealer();
			
		
		Spieler.spieler_kartenehmen();
		
	}

	public void verwerfen() {

	}

	public void assueberpruefung() {

	}

	public void wertueberpruefung() {
	}

	// Getter und Settermethoden

	public static ArrayList<Karte> getAktuelleKarten() {
		aktuelleHand.add(Kartenstapel.oberstekarte);
		return aktuelleHand;
	}

	public void setAktuelleHand(Array aktuelleKarten) {
		
	}
	
}
