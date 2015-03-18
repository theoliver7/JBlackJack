package JBlackjack;

import java.util.ArrayList;
import java.util.Random;

public class Kartenstapel {
	private static ArrayList<Karte> Kartenstappel = new ArrayList<Karte>();
	static Karte obersteKarte;
	static Karte stapel[] = new Karte[56];	
	private static int wert;
	
	public static void stapelGenerieren() {
		ArrayList<Karte> Kartenstappel_backup = new ArrayList<Karte>();
		
		String typ[] = { "Spade", "Hearts", "Clubs", "Diamonds" };
		String nummer[] = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "Jack", "Queen", "King" };
		int wert[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
		int k = 0;
		for (int i = 0; i < typ.length; i++) {
			for (int j = 0; j < nummer.length; j++) {
				Karte kar = new Karte(typ[i], nummer[j], wert[j]);
				stapel[k] = kar;
				k++;
			}
		}
		for (int i = 0; i < stapel.length; i++) {
			Kartenstappel_backup.add(stapel[i]);
		}
		for (int i = 55; i < 57 && i >= 0; i--) {
			int max = 51;
			int min = 0;
			int diff = max - min;
			Random ran = new Random();
			int a = ran.nextInt(diff + 1);
			a += min;
			if (i!=0){
				Kartenstappel.add(stapel[a]);
				Kartenstappel_backup.remove(stapel[a]);
			} else {
				Kartenstappel_backup.remove(stapel[a]);
				obersteKarte = stapel[a];
			}						
		}
	}
	public static ArrayList<Karte> getKartenstappel() {
		return Kartenstappel;
	}

	public void setKartenstappel(ArrayList<Karte> kartenstappel) {
		Kartenstappel = kartenstappel;
	}

	public static Karte getObersteKarte() {
		return obersteKarte;
	}
	
	public void setObersteKarte(Karte oberstekarte) {
		Kartenstapel.obersteKarte = oberstekarte;
	}



	public static int getWert() {
		return wert;
	}
	
	public static void setWert(int wert) {
		Kartenstapel.wert = wert;
	}

}
