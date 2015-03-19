package JBlackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Gui extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton Karte;
	JButton Einsatz;
	JButton Aufgeben;
	JButton Verlassen;
	JPanel Buttons;
	JPanel Navigation;
	JLabel label;
	JPanel panel;
	JPanel hand;
	int i = 0;

	public Gui() {
		panel = new JPanel();
		label = new JLabel();
		hand = new JPanel();
		// JFrame Eigenschaften
		setSize(1200, 1000);
//		getContentPane().setBackground(new Color(10, 108, 3));
		setTitle("JBlackJack");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Karte = new JButton("Karte nehmen");
		Einsatz = new JButton("Einsatz erhöhen");
		Verlassen = new JButton("Verlassen");
		Aufgeben = new JButton("Aufgeben");

		Karte.addActionListener(this);
		Einsatz.addActionListener(this);
		Aufgeben.addActionListener(this);
		Verlassen.addActionListener(this);

		// panel.setLayout(new Gui());

		panel.add(Karte, BorderLayout.EAST);
		panel.add(Einsatz, BorderLayout.NORTH);
		panel.add(Aufgeben, BorderLayout.SOUTH);
		panel.setBackground(new Color(10, 108, 3));
		panel.add(label);
		this.add(panel, BorderLayout.SOUTH);

		// final Icon newImageIcon =
		// loadIcon(Kartenstapel.obersteKarte.getName()+".jpg");
		// JMenuItem newMenuItem =new JMenuItem(newImageIcon);
		// panel.add(newMenuItem, BorderLayout.CENTER); 
	}

	public static void main(String[] args) {

		Gui bl = new Gui();
		bl.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		
		if (i == 0) {
			Kartenstapel.stapelGenerieren();
			Spieler.spieler_kartenehmen();
			final Icon newImageIcon = loadIcon("Spade 8.jpg");
			JMenuItem newMenuItem = new JMenuItem(newImageIcon);
			panel.add(newMenuItem, BorderLayout.CENTER);
			i++;

		} else {
			
			if (ae.getSource().equals(getKarte())) {
				final Icon oberstekarte = loadIcon("Spade 8.jpg");
				JMenuItem newMenuItem = new JMenuItem(oberstekarte);
				panel.add(newMenuItem, BorderLayout.CENTER);
			}
			if (ae.getSource().equals(getEinsatz())) {
//				Kartenstapel.stapelGenerieren();
				Spieler.spieler_kartenehmen();
			}
			if (ae.getSource().equals(getAufgeben())) {
				System.out.println("test");
			}
		}
	}

	private static Icon loadIcon(String iconName) {
		final URL resource = Gui.class.getResource("/images/" + iconName);

		if (resource == null) {

			// TODO Replace by logger

			System.err.println("Error in " + Gui.class.getName()
					+ ": Icon ../images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

	public JButton getKarte() {
		return Karte;
	}

	public void setKarte(JButton karte) {
		Karte = karte;
	}

	public JButton getEinsatz() {
		return Einsatz;
	}

	public void setEinsatz(JButton einsatz) {
		Einsatz = einsatz;
	}

	public JButton getAufgeben() {
		return Aufgeben;
	}

	public void setAufgeben(JButton aufgeben) {
		Aufgeben = aufgeben;
	}

	public JButton getVerlassen() {
		return Verlassen;
	}

	public void setVerlassen(JButton verlassen) {
		Verlassen = verlassen;
	}

	public JPanel getButtons() {
		return Buttons;
	}

	public void setButtons(JPanel buttons) {
		Buttons = buttons;
	}

	public JPanel getNavigation() {
		return Navigation;
	}

	public void setNavigation(JPanel navigation) {
		Navigation = navigation;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}