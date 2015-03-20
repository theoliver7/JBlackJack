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
		System.out.println(getDealerHand());
		System.out.println(setdealerkKartenwert());
		System.out.println();
	}

public static ArrayList<Karte> getDealerHand() {
		dealerHand.add(Kartenstapel.obersteKarte);
		int wert;
		wert = Kartenstapel.obersteKarte.getWert();
		Person.assUeberpruefung(wert);
		return dealerHand;
	}

	public static void setDealerHand(ArrayList<Karte> dealerHand) {
		Dealer.dealerHand = dealerHand;
	}

	public void neueRunde() {

	}
	public static int getdealerKartenwert() {
			return dealerkartenwert;
	}

	public static int setdealerkKartenwert() {
		dealerkartenwert = dealerkartenwert + Kartenstapel.obersteKarte.getWert();
		return dealerkartenwert;
	}

}
