package JBlackjack;


public class Karte {
	
	//==================== Variablen deklarieren ====================
	private String name;
	private int wert;
	private static String nummer;

	/*
	 * Hier wird der Name der Karten bestimmt, welcher wichtig ist 
	 * um sp�ter einen Stapel herzustellen
	 */
	public Karte(String string, String nummer, int wert) {
		this.setName(nummer + "_of_" + string);
		this.setWert(wert);
	}

	
	// ==================== Getter und Settermethoden ====================
	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}

	
	public String toString() {
		return this.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getNummer() {
		return nummer;
	}

	public static void setNummer(String nummer) {
		Karte.nummer = nummer;
	}
}
