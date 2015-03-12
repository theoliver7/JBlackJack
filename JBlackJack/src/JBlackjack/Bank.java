package JBlackjack;

public class Bank {
	// Variablen deklarieren
	private int kontostand;
	private String gewinner;
	private int kontostand_neu;
	
	//Methoden
	
	public int kontostandanzeigen(){
		
		return kontostand;
	}
	
	public String gewinnerermitteln(){
		
		return gewinner;
	}
	
	public int kontostandanpassen(){
		
		
		return kontostand_neu;
	}
	
	
/* 
 * Getter und Settermethoden
 */
	public int getKontostand() {
		return kontostand;
	}

	public void setKontostand(int kontostand) {
		this.kontostand = kontostand;
	} 

}
