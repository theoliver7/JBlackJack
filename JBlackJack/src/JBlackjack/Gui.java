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
	JPanel panel;
	static JPanel hand_spieler;
	JLabel label;
	int i = 0;

	public Gui() {
		panel = new JPanel();
		label = new JLabel();
		hand_spieler = new JPanel();
		Navigation = new JPanel();
		// JFrame Eigenschaften
		setSize(1200, 1000);
		// getContentPane().setBackground(new Color(10, 108, 3));
		setTitle("JBlackJack");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Karte = new JButton("Karte nehmen");
		Einsatz = new JButton("Einsatz erhöhen [+20]");
		Verlassen = new JButton("Verlassen");
		Aufgeben = new JButton("Aufgeben");

		Karte.addActionListener(this);
		Einsatz.addActionListener(this);
		Aufgeben.addActionListener(this);
		Verlassen.addActionListener(this);
		
		panel.add(Karte, BorderLayout.EAST);
		panel.add(Einsatz, BorderLayout.NORTH);
		panel.add(Aufgeben, BorderLayout.SOUTH);
		panel.setBackground(new Color(10, 108, 3));
		panel.add(label);
		this.add(panel, BorderLayout.SOUTH);

		Navigation.add(Verlassen, BorderLayout.EAST);
		Navigation.setBackground(new Color(10, 108, 3));
		this.add(Navigation, BorderLayout.EAST);

		

		hand_spieler.setBackground(new Color(10, 108, 3));
		this.add(hand_spieler, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		Kartenstapel.stapelGenerieren();
		Gui bl = new Gui();
		bl.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource().equals(getKarte())) {
			if (i == 0) {
				System.out.println("Ihr Einsatz : " + Bank.getEinsatz());
				Kartenstapel.stapelGenerieren();
				Spieler.spieler_kartenehmen();
				final Icon newImageIcon = loadIcon(Kartenstapel.obersteKarte
						.getName() + ".jpg");
				JMenuItem newMenuItem = new JMenuItem(newImageIcon);
				hand_spieler.add(newMenuItem, BorderLayout.CENTER);
				newMenuItem.setBackground(new Color(10, 108, 3));
				this.add(hand_spieler, BorderLayout.CENTER);
				revalidate();
				repaint();

				i++;
			} else {
				System.out.println("Ihr Einsatz : " + Bank.getEinsatz());
				Spieler.spieler_kartenehmen();
				final Icon newImageIcon = loadIcon(Kartenstapel.obersteKarte
						.getName() + ".jpg");
				JMenuItem newMenuItem = new JMenuItem(newImageIcon);
				hand_spieler.add(newMenuItem, BorderLayout.CENTER);
				newMenuItem.setBackground(new Color(10, 108, 3));
				this.add(hand_spieler, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		}
		if (ae.getSource().equals(getEinsatz())) {
			Bank.einsatzErhoehen(20);
			System.out.println("Ihr Einsatz : " + Bank.getEinsatz());
		}
		if (ae.getSource().equals(getAufgeben())) {
			System.out.println("Aufgeben");
		}
		if (ae.getSource().equals(getVerlassen())) {
			System.exit(0);
		}
	}

	private static Icon loadIcon(String iconName) {
		final URL resource = Gui.class.getResource("/images/" + iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println("Error in " + Gui.class.getName()
					+ ": Icon /images/" + iconName + " could not be loaded.");
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