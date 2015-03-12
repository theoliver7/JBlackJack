package JBlackjack;


public class Spieler extends Person {
	
//Variablen deklarieren
	private String Spielername;
	private boolean entscheiden_S;
	private boolean spielbeenden;
	
	
//Methoden
	public boolean entscheiden_S(){
		
		return entscheiden_S;
	}
	

//Getter und Settermethoden	
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
