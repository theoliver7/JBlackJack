package JBlackjack;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Dealer extends Person {
	private boolean entscheidung;
	static ArrayList<Karte> dealerHand = new ArrayList<Karte>();
	static int dealerkartenwert = 0;
	private int Drop_the_Supression;

	public boolean entscheiden_dealer() {

		return entscheidung;
	}

	public static void dealer_kartenehmen() {
		if (dealerkartenwert <= 17) {
			Kartenstapel.obersteKarte = Kartenstapel.getKartenstappel().get(0);
			Kartenstapel.getKartenstappel().remove(Kartenstapel.obersteKarte);
			System.out.println("Dealer :");
			System.out.println(getDealerHand());
			System.out.println(getdealerKartenwert());
			System.out.println();
			if (Spieler.spielerkartenwert <= 21) {
				Spieler.spieler_kartenehmen();
			}
		} else {
			Spieler.setspielerkartenwert(0);
			System.out.println();
			Bank.gewinnerErmitteln();
		}

	}

	public static ArrayList<Karte> getDealerHand() {
		dealerHand.add(Kartenstapel.obersteKarte);
		return dealerHand;
	}

	public static void setDealerHand(ArrayList<Karte> dealerHand) {
		Dealer.dealerHand = dealerHand;
	}

	public void neueRunde() {

	}

	public static int getdealerKartenwert() {
		dealerkartenwert = dealerkartenwert
				+ Kartenstapel.obersteKarte.getWert();
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
