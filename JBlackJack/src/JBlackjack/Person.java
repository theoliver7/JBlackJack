package JBlackjack;

import java.lang.reflect.Array;

public abstract class Person {

//Variablen deklarieren
	private Array aktuelleKarten;
	
	
	
//Methoden
	public void kartenehmen() {

	}

	public void verwerfen() {

	}

	public void assueberpruefung() {

	}

	public void wertueberpruefung() {
	}
	
	
//Getter und Settermethoden

	public Array getAktuelleKarten() {
		return aktuelleKarten;
	}

	public void setAktuelleKarten(Array aktuelleKarten) {
		this.aktuelleKarten = aktuelleKarten;
	}

}
