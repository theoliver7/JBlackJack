package JBlackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Person {

	// Methoden
	public static void kartenehmen() {
		Kartenstapel.oberstekarte = Kartenstapel.getKartenstappel().get(1);
		System.out.println(Kartenstapel.getOberstekarte());
		Kartenstapel.getKartenstappel().remove(Kartenstapel.oberstekarte);
	}
	public static void main(String[] args) {
		Kartenstapel.stapelgenerieren();
		kartenehmen();
		kartenehmen();
		kartenehmen();
		kartenehmen();
		kartenehmen();
		kartenehmen();
		kartenehmen();
		kartenehmen();
		kartenehmen();
		kartenehmen();
	}

	public void verwerfen() {

	}

	public void assueberpruefung() {

	}

	public void wertueberpruefung() {
	}

	// Getter und Settermethoden

	public Array getAktuelleKarten() {
		Array aktuelleKarten = null;
		return aktuelleKarten ;
	}

	public void setAktuelleKarten(Array aktuelleKarten) {
	
	}
}
