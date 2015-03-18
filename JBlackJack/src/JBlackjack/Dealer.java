package JBlackjack;

import java.util.ArrayList;


public class Dealer extends Person {
	private boolean entscheidung;
	static ArrayList<Karte> dealerHand = new ArrayList<Karte>();
	
	public boolean entscheiden_dealer(){
		
		return entscheidung;
	}
	public static void dealer_kartenehmen() {	
		Kartenstapel.oberstekarte = Kartenstapel.getKartenstappel().get(1);
		Kartenstapel.getKartenstappel().remove(Kartenstapel.oberstekarte);
		System.out.println("Dealer :");
		System.out.println(getDealerHand());
		System.out.println(getKartenwert());
		System.out.println();
	}
	
	public static ArrayList<Karte> getDealerHand() {
		dealerHand.add(Kartenstapel.oberstekarte);
		return dealerHand;
	}
	public static void setDealerHand(ArrayList<Karte> dealerHand) {
		Dealer.dealerHand = dealerHand;
	}
	public void neueRunde(){
		
	}
	
}
