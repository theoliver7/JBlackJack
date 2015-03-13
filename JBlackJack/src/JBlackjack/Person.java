package JBlackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Person {
	private static int kartenwert = 0;
	
	static ArrayList<Karte> aktuelleHand = new ArrayList<Karte>();
	// Methoden
	public static void kartenehmen() {	
		Kartenstapel.oberstekarte = Kartenstapel.getKartenstappel().get(1);
		Kartenstapel.getKartenstappel().remove(Kartenstapel.oberstekarte);
		System.out.println(getAktuelleKarten());
		System.out.println(getKartenwert());
	}
	public static void main(String[] args) {
		Kartenstapel.stapelgenerieren();
		
		kartenehmen();
		kartenehmen();
			
			
		Bank.gewinnerermitteln();
		Bank.kontostandanzeigen();
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
	public static int getKartenwert() {
		kartenwert = kartenwert + Kartenstapel.oberstekarte.getWert();
		if (kartenwert>21){
			kartenwert=0;
			return kartenwert;
		}
		else{
			return kartenwert;
		}
		
	}
}
