package JBlackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// JButton's
	protected JButton Karte;
	protected JButton Einsatz;
	protected JButton beenden;
	protected JButton Weiter;
	protected JButton Verlassen;
	protected JButton ass;
	// JPanel's
	protected JPanel Buttons;
	protected JPanel Navigation;
	protected JPanel menu;
	protected JPanel Einsatz_Panel;
	protected JPanel Kontostand_Panel;
	protected JPanel hand_spieler;
	protected JPanel hand_dealer;
	protected JPanel info;

	// JLabel's
	protected JLabel Einsatz_Label;
	protected JLabel Kontostand_Label;
	protected JLabel label;
	protected JLabel kartenwert_spieler;
	protected JLabel kartenwert_dealer;
	protected JLabel gewinner;

	// Z�hler initialisierung
	int i = 0;

	// Gui Klasse
	public Gui() {

		// Panel Objekte erstellen
		menu = new JPanel();
		hand_spieler = new JPanel();
		hand_dealer = new JPanel();
		Navigation = new JPanel();
		Kontostand_Panel = new JPanel();
		Einsatz_Panel = new JPanel();
		info = new JPanel();

		// Label Okjekte erstellen
		Kontostand_Label = new JLabel();
		label = new JLabel();
		Einsatz_Label = new JLabel();
		kartenwert_spieler = new JLabel();
		kartenwert_dealer = new JLabel();
		gewinner = new JLabel();

		// Button Objekte erstellen
		Karte = new JButton("Karte nehmen");
		Einsatz = new JButton("Einsatz erhöhen [+20]");
		Verlassen = new JButton("Verlassen");
		beenden = new JButton("Runde beenden");
		Weiter = new JButton("Weiter");

		// JFrame Eigenschaften
		setSize(800, 700);
		setTitle("JBlackJack");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// actionListener den Button's hinzuf�gen
		Karte.addActionListener(this);
		Einsatz.addActionListener(this);
		beenden.addActionListener(this);
		Verlassen.addActionListener(this);
		Weiter.addActionListener(this);
		Weiter.setEnabled(false);

		// Buttons dem BefehleMenu hinzufügen
		menu.add(Karte, BorderLayout.EAST, FlowLayout.LEFT);
		menu.add(Einsatz, BorderLayout.NORTH, FlowLayout.CENTER);
		menu.add(beenden, BorderLayout.SOUTH, FlowLayout.RIGHT);
		menu.add(Weiter, BorderLayout.EAST, FlowLayout.LEFT);
		menu.setBackground(new Color(10, 108, 3));
		menu.add(label);
		this.add(menu, BorderLayout.SOUTH);

		// Eigenschaften des Dealers
		hand_dealer.setBorder(new EmptyBorder(100, 10, 10, 0));
		hand_dealer.setBackground(new Color(10, 108, 3));
		hand_dealer.add(kartenwert_dealer);
		this.add(hand_dealer);

		// Eigenschaften des Spielers
		hand_spieler.setBorder(new EmptyBorder(10, 10, 100, 0));
		hand_spieler.setBackground(new Color(10, 108, 3));
		hand_spieler.add(kartenwert_spieler);
		this.add(hand_spieler);

		// Eigenschaten der Navigation
		Navigation.add(Verlassen, BorderLayout.EAST);
		Navigation.setBackground(new Color(10, 108, 3));
		this.add(Navigation, BorderLayout.EAST);

		// Kontostand Eigenschaften
		Kontostand_Label.setText("Einsatz: "+ String.valueOf(Bank.getEinsatz() + " \n Kontostand: "+ Bank.getKontostand()));
		Kontostand_Panel.add(Kontostand_Label, BorderLayout.EAST);
		Kontostand_Panel.setBackground(new Color(10, 108, 3));
		Kontostand_Panel.add(gewinner);
		this.add(Kontostand_Panel, BorderLayout.WEST);

		// Eigenschaften des Info Panels
		info.add(gewinner, BorderLayout.WEST);
		info.setBackground(new Color(10, 108, 3));
		this.add(info, BorderLayout.NORTH);

		if (Spieler.getspielerKartenwert(0) > 0&& Dealer.getdealerKartenwert(0) > 0) {
			beenden.setEnabled(true);
		}

	}

	public static void main(String[] args) {
		Kartenstapel.stapelGenerieren();
		Gui bl = new Gui();
		bl.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(getKarte())) {
			/*
			 * Das Kartenstapel wird generiert und die Karte die der Spieler
			 * nimmt wird auf dem Frame abgebildet
			 */

			if ((Spieler.getspielerKartenwert(0) <= 20)
					&& (Dealer.getdealerKartenwert(0) <= 21)) {
				if (i == 0) {
					System.out.println("Ihr Einsatz : " + Bank.getEinsatz());
					Kartenstapel.stapelGenerieren();
					Spieler.spieler_kartenehmen();
					final Icon newImageIcon = loadIcon(Kartenstapel.obersteKarte.getName() + ".jpg");
					JMenuItem newMenuItem = new JMenuItem(newImageIcon);
					hand_spieler.add(newMenuItem);
					hand_dealer.setBackground(new Color(10, 108, 3));
					kartenwert_spieler.setText(String.valueOf("Deine Hand hat einen Wert von: "+ Spieler.getspielerKartenwert(0)));
					hand_dealer.setBackground(new Color(10, 108, 3));
					newMenuItem.setBackground(new Color(10, 108, 3));
					this.add(hand_spieler, BorderLayout.SOUTH);
					this.add(hand_dealer);
					hand_spieler.add(kartenwert_spieler, BorderLayout.WEST);
					i++;
					Karte.setEnabled(false);
					if ((Dealer.getdealerKartenwert(0) < 17) || (Spieler.getspielerKartenwert(0) > Dealer.getdealerKartenwert(0))) {
						Weiter.setEnabled(true);
					}
					revalidate();
					repaint();
				}
			} else {
				if (Spieler.getspielerKartenwert() <= 20) {
					Karte.setEnabled(true);
				} else {
					Weiter.setEnabled(false);
					Karte.setEnabled(false);
				}
			}
		}
		if (ae.getSource().equals(getEinsatz())) {
			if (Bank.getKontostand() > Bank.getEinsatz()) {
				Einsatz.setEnabled(true);
				Bank.einsatzErhoehen(20);
				Kontostand_Label.setText("Einsatz: "
						+ String.valueOf(Bank.getEinsatz() + " \n Kontostand: "
								+ Bank.getKontostand()));
			} else {
				Einsatz.setEnabled(false);
			}
		}
		if (ae.getSource().equals(getAufgeben())) {
			gewinner.setText("Der " + Bank.gewinnerErmitteln()
					+ " hat gewonnen");
			Kontostand_Label.setText("Einsatz: "
					+ String.valueOf(Bank.getEinsatz() + " \n Kontostand: "
							+ Bank.getKontostand()));
			Kartenstapel.Kartenstappel.clear();
			Kartenstapel.stapelGenerieren();
			Dealer.dealerHand.clear();
			Spieler.spielerHand.clear();
			
			Container parent = hand_dealer.getParent();
			parent.remove(hand_dealer);
			parent.setBackground(new Color(10, 108, 3));
			
			Container parent_2 = hand_spieler.getParent();
			parent_2.remove(hand_spieler);
			parent_2.setBackground(new Color(10, 108, 3));
			
			
		
			hand_dealer.removeAll();
			hand_spieler.removeAll();
			
			hand_dealer.updateUI();
			hand_spieler.updateUI();
			
			
			
			Spieler.getspielerKartenwert(1);
			Dealer.getdealerKartenwert(1);
			
			kartenwert_spieler = new JLabel();
			kartenwert_dealer = new JLabel();
			
			Weiter.setEnabled(false);
			Karte.setEnabled(true);

		}
		if (ae.getSource().equals(getVerlassen())) {
			int eingabe = JOptionPane.showConfirmDialog(null,
					"Wollen Sie das Spiel wirklich verlassen?", "Verlassen?",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (eingabe == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		/*
		 * Der Dealer nimmt eine Karte, welche auf dem JFrame abgebildet wird
		 */
		if (ae.getSource().equals(getWeiter())) {
			if ((Dealer.getdealerKartenwert(0) <= 16) || (Dealer.getdealerKartenwert(0) <= Spieler.getspielerKartenwert(0))) {

				/*
				 * Wenn Spieler mehr als 21 dann abbrechen
				 */
				if (Spieler.getspielerKartenwert(0) <= 21) {
					Dealer.dealer_kartenehmen();
					final Icon newImageIcon_2 = loadIcon(Kartenstapel.obersteKarte.getName() + ".jpg");
					JMenuItem newMenuItem_2 = new JMenuItem(newImageIcon_2);
					hand_dealer.add(newMenuItem_2);
					newMenuItem_2.setBackground(new Color(10, 108, 3));
					kartenwert_dealer.setText(String.valueOf("Der Dealer hat eine Hand mit dem Wert: "+ Dealer.getdealerKartenwert(0)));
					this.add(hand_dealer);
					hand_dealer.add(kartenwert_dealer);
					revalidate();
					repaint();
					i = 0;
					Weiter.setEnabled(false);
					Karte.setEnabled(true);
				} else {
					if (Spieler.getspielerKartenwert() <= 20) {
						Karte.setEnabled(true);
					} else {
						Weiter.setEnabled(false);
						Karte.setEnabled(true);
					}
				}
			}
		}

	}

	public JButton getWeiter() {
		return Weiter;
	}

	public void setWeiter(JButton weiter) {
		Weiter = weiter;
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
		return beenden;
	}

	public void setAufgeben(JButton aufgeben) {
		beenden = aufgeben;
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
		return menu;
	}

	public void setPanel(JPanel panel) {
		this.menu = panel;
	}

}
