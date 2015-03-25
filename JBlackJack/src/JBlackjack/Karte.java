package JBlackjack;


public class Karte {
	private String name;
	private int wert;
	private static String nummer;

	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}

	public Karte(String string, String nummer, int wert) {
		this.setName(nummer + "_of_" + string);
		this.setWert(wert);

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
