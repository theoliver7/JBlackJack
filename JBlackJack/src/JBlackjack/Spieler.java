package JBlackjack;

import java.util.ArrayList;


public class Spieler extends Person {
	
//Variablen deklarieren
	private String Spielername;
	private boolean entscheiden_S;
	private boolean spielbeenden;
	static ArrayList<Karte> spielerHand = new ArrayList<Karte>();
	
//Methoden
	public boolean entscheiden_S(){
		       
		return entscheiden_S;
	}
	public static void spieler_kartenehmen() {	
		Kartenstapel.oberstekarte = Kartenstapel.getKartenstappel().get(1);
		Kartenstapel.getKartenstappel().remove(Kartenstapel.oberstekarte);
		System.out.println("Spieler :");
		System.out.println(getSpielerHand());
		System.out.println(getKartenwert());
		System.out.println();
	}
	

//Getter und Settermethoden	
	public static ArrayList<Karte> getSpielerHand() {
		spielerHand.add(Kartenstapel.oberstekarte);
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
