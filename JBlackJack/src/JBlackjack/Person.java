package JBlackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Person {

//Variablen deklarieren
	private Array aktuelleKarten;
	
	
	
//Methoden
	public void kartenehmen() {
		ArrayList<Karte> oberstekarte = new ArrayList<Karte>();
		ArrayList<Karte> Karten = new ArrayList<Karte>();
		Karten = getAktuelleKarten();
		
		for (int i =0 ; i<10 ; i++) {
			if (i == 1) {
				oberstekarte;
			}
		}
		
	}

	public void verwerfen() {

	}

	public void assueberpruefung() {

	}

	public void wertueberpruefung() {
	}
	
	
//Getter und Settermethoden

	public ArrayList<Karte> getAktuelleKarten() {
		ArrayList<Karte> aktuelleKarten = new ArrayList<Karte>();
		aktuelleKarten = Kartenstapel.getKartenstappel();		
		return aktuelleKarten;
	}

	public void setAktuelleKarten(Array aktuelleKarten) {
		this.aktuelleKarten = aktuelleKarten;
	}	
}

