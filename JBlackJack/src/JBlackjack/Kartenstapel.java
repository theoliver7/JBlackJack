package JBlackjack;

import java.util.ArrayList;
import java.util.Random;

public class Kartenstapel {
	
	// ==================== Variablen deklarieren ====================
	static ArrayList<Karte> Kartenstappel = new ArrayList<Karte>();
	static Karte obersteKarte;
	static Karte stapel[] = new Karte[52];	
	private static String nummer;
	private static int wert;
	
	
	// ==================== Methoden ====================
	
	 /*
	  * Hier wird der Stapel generiert
	  */
	public static void stapelGenerieren() {
		ArrayList<Karte> Kartenstappel_backup = new ArrayList<Karte>();
		
		/* 
		 * F�r jeden Typ wird jede Nummer hinzugef�gt und jeweils den richtigen Wert hinzugeteilt
		 */
		String typ[] = { "spades", "hearts", "clubs", "diamonds" };
		String nummer[] = { "ace", "2", "3", "4", "5", "6", "7", "8", "9","10", "jack", "queen", "king" };
		int wert[] = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
		int k = 0;
		for (int i = 0; i < typ.length; i++) {
			for (int j = 0; j < nummer.length; j++) {
				Karte kar = new Karte(typ[i], nummer[j], wert[j]);
				stapel[k] = kar;
				k++;
			}
		}
		
		/*
		 * Es wird ein gleicher Stapel erstellt als Backup
		 */
		
		for (int i = 0; i < stapel.length; i++) {
			Kartenstappel_backup.add(stapel[i]);
			System.out.println(stapel[i]);
		}
		
		/*
		 * Aus dem Kartenstapel wird eine zufällige Karte ausgesucht
		 * Diese wird dem Kartenstapel hinzugefügt und aus dem Backup gelöscht
		 * Zum Schluss wird noch die oberste Karte bestummen
		 */
		for (int i = 51;i >= 0; i--) {
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
	
	// ==================== Getter und Settermethoden ====================
	
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
	public static String getNummer() {
		nummer = obersteKarte.getNummer();
		return nummer;
	}
	public void setNummer(String nummer) {
		Kartenstapel.nummer = nummer;
	}

}
