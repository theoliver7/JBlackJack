package JBlackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
	JPanel Einsatz_Panel;
	JLabel Einsatz_Label;
	static JPanel hand_spieler;
	static JPanel hand_dealer;
	JLabel label;
	int i = 0;

	public Gui() {
		panel = new JPanel();
		label = new JLabel();
		hand_spieler = new JPanel();
		hand_dealer = new JPanel();
		Navigation = new JPanel();

		// JFrame Eigenschaften

		setSize(1200, 1000);
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

		panel.add(Karte, BorderLayout.EAST, FlowLayout.LEFT);
		panel.add(Einsatz, BorderLayout.NORTH, FlowLayout.CENTER);
		panel.add(Aufgeben, BorderLayout.SOUTH, FlowLayout.RIGHT);
		panel.setBackground(new Color(10, 108, 3));
		panel.add(label);
		this.add(panel, BorderLayout.SOUTH);

		Navigation.add(Verlassen, BorderLayout.EAST);
		Navigation.setBackground(new Color(10, 108, 3));
		this.add(Navigation, BorderLayout.EAST);

		hand_spieler.setBackground(new Color(10, 108, 3));
		this.add(hand_spieler, BorderLayout.CENTER);

		hand_dealer.setBackground(new Color(10, 108, 3));
		this.add(hand_dealer, BorderLayout.NORTH);

		Einsatz_Panel = new JPanel();
		Einsatz_Label = new JLabel();
		Einsatz_Label.setText(String.valueOf("Einsatz: " + Bank.getEinsatz()));
		Einsatz_Panel.add(Einsatz_Label, BorderLayout.EAST);
		Einsatz_Panel.setBackground(new Color(10, 108, 3));
		this.add(Einsatz_Panel, BorderLayout.WEST);
		
	}

	public static void main(String[] args) {
		Gui bl = new Gui();
		bl.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(getKarte())) {

			/*
			 * Das Kartenstapel wird generiert und die Karte die der Spieler
			 * nimmt wird auf dem Frame abgebildet
			 */
			System.out.println("Ihr Einsatz : " + Bank.getEinsatz());
			Kartenstapel.stapelGenerieren();
			Spieler.spieler_kartenehmen();
			final Icon newImageIcon = loadIcon(Kartenstapel.obersteKarte.getName() + ".jpg");
			JMenuItem newMenuItem = new JMenuItem(newImageIcon);
			hand_spieler.add(newMenuItem);
			newMenuItem.setBackground(new Color(10, 108, 3));
			panel.add(hand_spieler, BorderLayout.NORTH);
			revalidate();
			repaint();
			/*
			 * Der Dealer nimmt eine Karte, welche auf dem JFrame abgebildet
			 * wird
			 */
			Dealer.dealer_kartenehmen();
			final Icon newImageIcon_2 = loadIcon(Kartenstapel.obersteKarte.getName() + ".jpg");
			JMenuItem newMenuItem_2 = new JMenuItem(newImageIcon_2);
			hand_spieler.add(newMenuItem_2);
			newMenuItem_2.setBackground(new Color(10, 108, 3));
			this.add(hand_dealer, FlowLayout.CENTER);
			revalidate();
			repaint();
		}

		if (ae.getSource().equals(getEinsatz())) {
			Bank.einsatzErhoehen(20);
			Einsatz_Label.setText("Einsatz: "+ String.valueOf(Bank.getEinsatz()));
		}
		if (ae.getSource().equals(getAufgeben())) {
			System.out.println("Aufgeben");
		}
		if (ae.getSource().equals(getVerlassen())) {
			int eingabe = JOptionPane.showConfirmDialog(null,
					"Wollen Sie das Spiel wirklich verlassen?", "Verlassen?",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (eingabe == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
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
