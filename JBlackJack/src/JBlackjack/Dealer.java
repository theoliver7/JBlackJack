package JBlackjack;

import java.util.ArrayList;

public class Dealer extends Person {
	private boolean entscheidung;
	static ArrayList<Karte> dealerHand = new ArrayList<Karte>();
	static int dealerkartenwert = 0;

	public boolean entscheiden_dealer() {

		return entscheidung;
	}

	public static void dealer_kartenehmen() {
		if ((dealerkartenwert <= Spieler.spielerkartenwert) && (dealerkartenwert<=17)) {
			Kartenstapel.oberstekarte = Kartenstapel.getKartenstappel().get(0);
			Kartenstapel.getKartenstappel().remove(Kartenstapel.oberstekarte);
			System.out.println("Dealer :");
			System.out.println(getDealerHand());
			System.out.println(getdealerKartenwert());
			System.out.println();
			Spieler.spieler_kartenehmen();	
		} else{
			dealerkartenwert = 0;
			System.out.println();
			Bank.gewinnerErmitteln();
		}
	}
	
	public static ArrayList<Karte> getDealerHand() {
		dealerHand.add(Kartenstapel.oberstekarte);
		return dealerHand;
	}
	public static void setDealerHand(ArrayList<Karte> dealerHand) {
		Dealer.dealerHand = dealerHand;
	}

	public void neueRunde() {

	}

	public static int getdealerKartenwert() {
		dealerkartenwert = dealerkartenwert
				+ Kartenstapel.oberstekarte.getWert();
		if (dealerkartenwert > 21) {
			dealerkartenwert = 0;
			return dealerkartenwert;
		} else {
			return dealerkartenwert;
		}

	}

	public static void setDealerkartenwert(int dealerkartenwert) {
		Dealer.dealerkartenwert = dealerkartenwert;
	}

}
