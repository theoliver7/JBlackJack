package JBlackjack;

import java.util.ArrayList;

public class Dealer extends Person {
	private boolean entscheidung;
	static ArrayList<Karte> dealerHand = new ArrayList<Karte>();
	static int dealerkartenwert = 0;
	private static String nummer;

	public boolean entscheiden_dealer() {

		return entscheidung;
	}

	public static void dealer_kartenehmen() {
		Kartenstapel.obersteKarte = Kartenstapel.getKartenstappel().get(0);
		Kartenstapel.getKartenstappel().remove(Kartenstapel.obersteKarte);
		System.out.println("Dealer :");
		System.out.println(setdealerHand());
		System.out.println(setdealerkKartenwert(Kartenstapel.obersteKarte.getWert()));
		System.out.println();
	}

public static ArrayList<Karte> getdealerHand(ArrayList<Karte> dealerHand) {
		return Dealer.dealerHand = dealerHand;
	}

	public static ArrayList<Karte> setdealerHand() {
		dealerHand.add(Kartenstapel.obersteKarte);
		int wert;
		wert = Kartenstapel.obersteKarte.getWert();
		Person.assUeberpruefung(wert);
		return dealerHand;
	}

	public void neueRunde() {

	}
	public static int getdealerKartenwert(int veraendern) {
		if (veraendern == 1) {
			dealerkartenwert = 0;
			return dealerkartenwert;
		} else {
			return dealerkartenwert;
		}
	}

	public static int setdealerkKartenwert(int wert) {
		dealerkartenwert = dealerkartenwert + wert;
		return dealerkartenwert;
	}

}
