package JBlackjack;

import java.util.ArrayList;
import java.util.Random;

public class Karte {
	private String name;

	public Karte(String string, String string2) {
		this.setName(string + " " + string2);
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
	
	public static void main(String[] args) {
		ArrayList<Karte> Kartenstappel = new ArrayList<Karte>();
		ArrayList<Karte> Kartenstappel_backup = new ArrayList<Karte>();
		Karte stapel[] = new Karte[52];
		String typ[] = { "Spade", "Hearts", "Clubs", "Diamonds" };
		String nummer[] = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "Jack", "Queen", "King" };
		int k = 0;
		for (int i = 0; i < typ.length; i++) {
			for (int j = 0; j < nummer.length; j++) {
				Karte kar = new Karte(typ[i], nummer[j]);
				stapel[k] = kar;
				k++;
			}
		}
		for (int i = 0 ; i < stapel.length; i++){
			Kartenstappel_backup.add(stapel[i]);
		}
		for (int i=0; i < 52; i++){
			int max=51;
			int min=0;
			int diff=max-min;
			Random ran= new Random();
			int a =ran.nextInt(diff+1);
			a+=min;			
			Kartenstappel.add(stapel[a]);
			Kartenstappel_backup.remove(stapel[a]);
		}
		for (Karte i:Kartenstappel){	
			System.out.println(i);
		}
	}

}