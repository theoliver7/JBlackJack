package JBlackjack;

public class Karte {
	
// Variablen deklarieren
	private String sorte;
	private int[] wert;
	private String[][] KartenID;

	
	
	
	
	
// Getter und Settermethoden	
	public String getSorte() {
		return sorte;
	}

	public void setSorte(String sorte) {
		this.sorte = sorte;
	}

	public int[] getWert() {
		return wert;
	}

	public void setWert(int[] wert) {
		this.wert = wert;
	}

	public String[][] getKartenID() {
		return KartenID;
	}

	public void setKartenID(String[][] kartenID) {
		KartenID = kartenID;
	}

	
}
