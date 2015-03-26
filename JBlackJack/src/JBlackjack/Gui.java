package JBlackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// JButton's
	protected JButton Karte;

	protected JButton beenden;

	protected JButton Verlassen;
	protected JButton ass;
	protected JButton starten;
	protected JButton einsatzButton;

	// Jtextfields
	static JTextField einsatzt_feld;
	// JPanel's
	protected JPanel Buttons;
	protected JPanel Navigation;
	protected JPanel menu;
	protected JPanel Einsatz_Panel;
	protected JPanel Kontostand_Panel;
	protected JPanel hand_spieler;
	protected JPanel hand_dealer;
	protected JPanel info;
	protected JPanel einsatz_panel = new JPanel();

	// JLabel's
	protected JLabel Einsatz_Label;
	protected JLabel Kontostand_Label;
	protected JLabel label;
	protected JLabel kartenwert_spieler;
	protected JLabel kartenwert_dealer;
	protected JLabel befehle;

	// Zähler Initialisierung
	int assHand = 0;
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
		befehle = new JLabel();

		// Button Objekte erstellen
		Karte = new JButton("Karte nehmen [K]");

		Verlassen = new JButton("Verlassen [ESC]");
		beenden = new JButton("Keine Karten nehmen[SPACE]");

		starten = new JButton("Neue Runde starten[ENTER]");
		ass = new JButton("Ass wert verändern[A]");
		einsatzButton = new JButton("Einsetzen[E]");

		// JFrame Eigenschaften
		setSize(1000, 900);
		setTitle("JBlackJack");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// actionListener den Button's hinzuf�gen
		Karte.addActionListener(this);
		beenden.addActionListener(this);
		Verlassen.addActionListener(this);
		ass.addActionListener(this);
		starten.addActionListener(this);
		einsatzButton.addActionListener(this);
		this.setFocusable(true);
		this.addKeyListener(new KeyListener() {
			@Override public void keyPressed(KeyEvent a) {
				// TODO Auto-generated method stub
				int key = a.getKeyCode();
				if (key == KeyEvent.VK_K) {
					if (Karte.isEnabled() == false) {
						befehle.setText("Bitte mache zuerst einen Einsatz");
					} else {
						karteZiehen();
					}
				}
				if (key == KeyEvent.VK_SPACE) {
					if (beenden.isEnabled() == true) {
						keineKarteZiehen();
					} else {
						befehle.setText("Nimm zuerst eine Karte");
					}
				}
				if (key == KeyEvent.VK_ESCAPE) {
					spielVerlassen();
				}
				if (key == KeyEvent.VK_ENTER) {
					if (starten.isEnabled() == true) {
						neueRunde();
					}
				}
				if (key == KeyEvent.VK_E) {
					if (einsatzButton.isEnabled() == true) {
						einsetzen();
					}
				}
				if (key == KeyEvent.VK_A) {
					if (ass.isVisible() == true) {
						assWertAendern();
					}
				}
			}

			@Override public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});

		// Buttons dem BefehleMenu hinzuf�gen

		menu.add(einsatz_panel);
		menu.add(Karte, BorderLayout.EAST, FlowLayout.LEFT);
		menu.add(beenden, BorderLayout.SOUTH, FlowLayout.RIGHT);
		menu.add(starten, BorderLayout.EAST);
		menu.add(ass, BorderLayout.EAST);
		menu.setBackground(new Color(10, 108, 3));
		menu.add(label);
		ass.setVisible(false);
		this.add(menu, BorderLayout.SOUTH);

		einsatz_panel.setLayout(new BoxLayout(einsatz_panel, BoxLayout.X_AXIS));
		einsatz_panel.setOpaque(false);
		einsatzt_feld = new JTextField(5);
		einsatz_panel.add(einsatzt_feld);
		einsatz_panel.add(einsatzButton);

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
		Kontostand_Label.setText("Einsatz: " + String.valueOf(Bank.getEinsatz() + "$" + " \n Kontostand: " + Bank.getKontostand()) + "$");
		Kontostand_Panel.add(Kontostand_Label, BorderLayout.EAST);
		Kontostand_Panel.setBackground(new Color(10, 108, 3));
		befehle.setText("Mach einen Einsatz und nimm dannach eine Karte um das Spiel zu beginnen");
		Kontostand_Panel.add(befehle);

		this.add(Kontostand_Panel, BorderLayout.WEST);

		// Eigenschaften des Info Panels
		info.add(befehle);
		info.setBackground(new Color(255, 0, 0));
		this.add(info, BorderLayout.NORTH);

		if (Spieler.getspielerKartenwert(0) > 0 && Dealer.getdealerKartenwert(0) > 0) {
			beenden.setEnabled(true);
		}

		starten.setEnabled(false);
		beenden.setEnabled(false);
		Karte.setEnabled(false);
	}

	public static void main(String[] args) {
		Kartenstapel.stapelGenerieren();
		Gui bl = new Gui();
		bl.setVisible(true);
	}

	public void assWertAendern() {
		Spieler.setspielerKartenwert(-10);
		kartenwert_spieler.setText(String.valueOf("Deine Hand hat einen Wert von: " + Spieler.getspielerKartenwert(0)));
		ass.setVisible(false);
		Karte.setEnabled(true);
		beenden.setEnabled(true);
		i = 0;
	}

	public void einsetzen() {
		if (Bank.getKontostand() >= Bank.getEinsatz()) {
			einsatzButton.setEnabled(true);
			try {
				int einsatz = Integer.parseInt(einsatzt_feld.getText());
				if (einsatz > Bank.getKontostand()) {
					befehle.setText("Du hast zu wenig Geld");
				} else if (einsatz < 10) {

					befehle.setText("Du musst mindestens 10$ setzen");
				} else {
					Karte.setEnabled(true);
					einsatzButton.setEnabled(false);
					befehle.setText("Nimm eine Karte");
					Bank.einsatzErhoehen(einsatz);
					Kontostand_Label.setText("Einsatz: " + String.valueOf(Bank.getEinsatz() + "$" + " \n Kontostand: " + Bank.getKontostand()) + "$");

				}
			} catch (NumberFormatException e) {
				befehle.setText("Dein Einsatz muss eine Zahl sein");
				return;
			}
		} else {
			einsatzButton.setEnabled(false);
		}
	}

	public void neueRunde() {
		if (starten.isEnabled() == true) {
			Bank.setEinsatz(0);
			befehle.setText(Bank.gewinnerErmitteln());
			Kontostand_Label.setText("Einsatz: " + String.valueOf(Bank.getEinsatz() + "$" + " \n Kontostand: " + Bank.getKontostand() + "$"));
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

			einsatzButton.setEnabled(true);
			Karte.setEnabled(false);
			beenden.setEnabled(false);
			starten.setEnabled(false);
			info.setVisible(true);
			kartenwert_spieler = new JLabel();
			kartenwert_dealer = new JLabel();
			Karte.setEnabled(false);
			einsatzButton.setEnabled(true);

			ass.setVisible(false);
			i = 0;
			if (Bank.getKontostand() == 0) {
				int checker = JOptionPane.showConfirmDialog(null, "Sie haben verloren, wollen sie ein neues Spiel starten?", "Verloren", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (checker == JOptionPane.YES_OPTION) {
					System.out.println("5000");
					Bank.setKontostand(500);
					Kontostand_Label.setText("Einsatz: " + String.valueOf(Bank.getEinsatz() + "$" + " \n Kontostand: " + Bank.getKontostand() + "$"));
					befehle.setText("Nimm eine Karte");

					this.add(Kontostand_Panel, BorderLayout.WEST);
				} else {
					System.exit(0);
				}
			}
		}
	}

	public void spielVerlassen() {
		int eingabe = JOptionPane.showConfirmDialog(null, "Wollen Sie das Spiel wirklich verlassen?", "Verlassen?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (eingabe == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	public void keineKarteZiehen() {
		while (Dealer.getdealerKartenwert(0) <= 17) {
			Dealer.dealer_kartenehmen();
			final Icon newImageIcon_2 = loadIcon(Kartenstapel.obersteKarte.getName() + ".png");
			JMenuItem newMenuItem_2 = new JMenuItem(newImageIcon_2);
			hand_dealer.add(newMenuItem_2);
			newMenuItem_2.setBackground(new Color(10, 108, 3));
			kartenwert_dealer.setText(String.valueOf("Der Dealer hat eine Hand mit dem Wert: " + Dealer.getdealerKartenwert(0)));
			this.add(hand_dealer);
			hand_dealer.add(kartenwert_dealer);
			ass.setVisible(false);
			revalidate();
			repaint();
		}

		starten.setEnabled(true);
		beenden.setEnabled(false);
		einsatzButton.setEnabled(false);
		Karte.setEnabled(false);
	}

	public void karteZiehen() {

		befehle.setText("Entscheide ob du noch eine Karte nehmen willst oder nicht");
		/*
		 * Das Kartenstapel wird generiert und die Karte die der Spieler nimmt
		 * wird auf dem Frame abgebildet
		 */

		if (Spieler.getspielerKartenwert(0) <= 21) {
			if (i == 0) {
				System.out.println("Ihr Einsatz : " + Bank.getEinsatz());
				Kartenstapel.stapelGenerieren();
				Spieler.spieler_kartenehmen();
				final Icon newImageIcon = loadIcon(Kartenstapel.obersteKarte.getName() + ".png");
				JMenuItem newMenuItem = new JMenuItem(newImageIcon);
				hand_spieler.add(newMenuItem);
				hand_dealer.setBackground(new Color(10, 108, 3));
				kartenwert_spieler.setText(String.valueOf("Deine Hand hat einen Wert von: " + Spieler.getspielerKartenwert(0)));
				hand_dealer.setBackground(new Color(10, 108, 3));
				newMenuItem.setBackground(new Color(10, 108, 3));
				this.add(hand_spieler, BorderLayout.SOUTH);
				this.add(hand_dealer);
				hand_spieler.add(kartenwert_spieler, BorderLayout.WEST);
				i++;
				Karte.setEnabled(false);

				if (Kartenstapel.obersteKarte.getName().equals("ace_of_clubs") || Kartenstapel.obersteKarte.getName().equals("ace_of_diamonds")
						|| Kartenstapel.obersteKarte.getName().equals("ace_of_hearts") || Kartenstapel.obersteKarte.getName().equals("ace_of_spades")) {
					ass.setVisible(true);
					menu.add(ass);

				}
				revalidate();
				repaint();

				if (Spieler.getspielerKartenwert(0) <= 21) {
					Karte.setEnabled(true);
					beenden.setEnabled(true);
					i = 0;
					starten.setEnabled(false);
				} else {

					Karte.setEnabled(false);
					beenden.setEnabled(false);
					starten.setEnabled(true);

				}

				einsatzButton.setEnabled(false);
			}
			info.setVisible(true);

		}
		if (Dealer.getdealerKartenwert(0) <= 20) {
			Dealer.dealer_kartenehmen();
			if (Kartenstapel.obersteKarte.getName().equals("ace_of_clubs") || Kartenstapel.obersteKarte.getName().equals("ace_of_diamonds")
					|| Kartenstapel.obersteKarte.getName().equals("ace_of_hearts") || Kartenstapel.obersteKarte.getName().equals("ace_of_spades")) {
				assHand++;
			}
			if (Dealer.getdealerKartenwert(0) > 21 && assHand > 0) {
				System.out.println("Ass detected");
				Dealer.setdealerkKartenwert(-10);
				assHand--;
			}
			final Icon newImageIcon_2 = loadIcon(Kartenstapel.obersteKarte.getName() + ".png");
			JMenuItem newMenuItem_2 = new JMenuItem(newImageIcon_2);
			hand_dealer.add(newMenuItem_2);
			newMenuItem_2.setBackground(new Color(10, 108, 3));
			kartenwert_dealer.setText(String.valueOf("Der Dealer hat eine Hand mit dem Wert: " + Dealer.getdealerKartenwert(0)));
			this.add(hand_dealer);
			hand_dealer.add(kartenwert_dealer);
			revalidate();
			repaint();
			i = 0;

			if (Spieler.getspielerKartenwert(0) > 21 || Dealer.getdealerKartenwert(0) > 21) {
				Karte.setEnabled(false);
				beenden.setEnabled(false);
				einsatzButton.setEnabled(false);
				starten.setEnabled(true);
			} else {
				Karte.setEnabled(true);

			}

			// if (Spieler.getspielerKartenwert(0)==21){
			// URL url = null;
			// try {
			// url = new
			// URL("http://www.picgifs.com/graphics/f/fireworks/graphics-fireworks-432653.gif");
			// } catch (MalformedURLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// Icon icon = new ImageIcon(url);
			// JLabel label = new JLabel(icon);
			//
			//
			// this.getContentPane().add(label);
			// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// this.pack();
			// this.setLocationRelativeTo(null);
			// this.setVisible(true);
			// }
			i = 0;
		}

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(getKarte())) {
			karteZiehen();

		}
		if (ae.getSource().equals(getAufgeben())) {
			keineKarteZiehen();
		}

		if (ae.getSource().equals(getEinsatzButton())) {
			einsetzen();
		}

		if (ae.getSource().equals(getStarten())) {
			neueRunde();
		}
		if (ae.getSource().equals(getVerlassen())) {
			spielVerlassen();
		}
		if (ae.getSource().equals(getAss())) {
			assWertAendern();
		}
	}

	public JButton getStarten() {
		return starten;
	}

	public void setStarten(JButton starten) {
		this.starten = starten;
	}

	private static Icon loadIcon(String iconName) {
		final URL resource = Gui.class.getResource("/images/" + iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println("Error in " + Gui.class.getName() + ": Icon /images/" + iconName + " could not be loaded.");
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

	public JButton getBeenden() {
		return beenden;
	}

	public void setBeenden(JButton beenden) {
		this.beenden = beenden;
	}

	public JButton getAss() {
		return ass;
	}

	public void setAss(JButton ass) {
		this.ass = ass;
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public JPanel getEinsatz_Panel() {
		return Einsatz_Panel;
	}

	public void setEinsatz_Panel(JPanel einsatz_Panel) {
		Einsatz_Panel = einsatz_Panel;
	}

	public JPanel getKontostand_Panel() {
		return Kontostand_Panel;
	}

	public void setKontostand_Panel(JPanel kontostand_Panel) {
		Kontostand_Panel = kontostand_Panel;
	}

	public JPanel getHand_spieler() {
		return hand_spieler;
	}

	public void setHand_spieler(JPanel hand_spieler) {
		this.hand_spieler = hand_spieler;
	}

	public JPanel getHand_dealer() {
		return hand_dealer;
	}

	public void setHand_dealer(JPanel hand_dealer) {
		this.hand_dealer = hand_dealer;
	}

	public JPanel getInfo() {
		return info;
	}

	public void setInfo(JPanel info) {
		this.info = info;
	}

	public JLabel getEinsatz_Label() {
		return Einsatz_Label;
	}

	public void setEinsatz_Label(JLabel einsatz_Label) {
		Einsatz_Label = einsatz_Label;
	}

	public JLabel getKontostand_Label() {
		return Kontostand_Label;
	}

	public void setKontostand_Label(JLabel kontostand_Label) {
		Kontostand_Label = kontostand_Label;
	}

	public JLabel getKartenwert_spieler() {
		return kartenwert_spieler;
	}

	public void setKartenwert_spieler(JLabel kartenwert_spieler) {
		this.kartenwert_spieler = kartenwert_spieler;
	}

	public JLabel getKartenwert_dealer() {
		return kartenwert_dealer;
	}

	public void setKartenwert_dealer(JLabel kartenwert_dealer) {
		this.kartenwert_dealer = kartenwert_dealer;
	}

	public JLabel getGewinner() {
		return befehle;
	}

	public void setGewinner(JLabel gewinner) {
		this.befehle = gewinner;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTextField getEinsatzt_feld() {
		return einsatzt_feld;
	}

	public void setEinsatzt_feld(JTextField einsatzt_feld) {
		Gui.einsatzt_feld = einsatzt_feld;
	}

	public JButton getEinsatzButton() {
		return einsatzButton;
	}

	public void setEinsatzButton(JButton einsatzButton) {
		this.einsatzButton = einsatzButton;
	}

}
