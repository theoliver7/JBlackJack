package JBlackjack;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Blackjack extends JFrame {

	public static void main(String[] args) {
		Blackjack Spiel = new Blackjack();
		Spiel.getContentPane().setBackground(new Color(8,138,8)); 
	}

	public Blackjack() {
		setTitle("JBlackJack");
		setBackground(Color.green);
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		

	}
}
