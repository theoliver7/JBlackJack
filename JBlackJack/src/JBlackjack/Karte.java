package JBlackjack;



public class Karte {
	private String name;

	public Karte(String string, String string2) {
		this.setName(string + " " + string2);
	}

	public String toString() {
		return this.getName();
	}

	public static void main(String[] args) {
		Karte stapel[] = new Karte[52];
		String suit[] = { "Spade", "Hearts", "Clubs", "Diamonds" };
		String number[] = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "Jack", "Queen", "King" };
		int k = 0;
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < number.length; j++) {
				Karte kar = new Karte(suit[i], number[j]);
				stapel[k] = kar;
				k++;
			}
		}
		for (int i = 0 ; i < stapel.length; i++){
			System.out.println(stapel[i]);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}