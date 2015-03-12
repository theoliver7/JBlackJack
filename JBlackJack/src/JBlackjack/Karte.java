package JBlackjack;

import java.util.ArrayList;

public class Karte {
	public Karte(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	ArrayList<Karte> Stapel = new ArrayList<Karte>();
	String suit[] = { "Spade", "Hearts", "Clubs", "Diamonds" };
	String number[] = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King" };
	{
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < number.length; j++) {
				Stapel.add(new Karte(suit[i], number[j]));
			}
		}
	}
}