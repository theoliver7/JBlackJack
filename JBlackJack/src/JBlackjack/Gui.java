package JBlackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	public Gui() {
		panel = new JPanel();
		label = new JLabel();
		// JFrame Eigenschaften
		setSize(1200, 1000);
		getContentPane().setBackground(new Color(10, 108, 3));
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

		panel.setLayout(new FlowLayout());
		
		panel.add(Karte,BorderLayout.EAST);
		panel.add(Einsatz,BorderLayout.NORTH);
		panel.add(Aufgeben,BorderLayout.SOUTH);

		panel.add(label);
		this.add(panel);
	}

	public void actionPermormed(ActionEvent e) {
		if (e.getSource().equals("Karte nehmen")) {
			System.out.println("HI");
		}
	}

	public static void main(String[] args) {
		Gui bl = new Gui();
		bl.setVisible(true);
	}

	// private static Icon loadIcon(String iconName) {
	// final URL resource = Gui.class.getResource("/images/" + iconName);
	//
	// if (resource == null) {
	//
	// // TODO Replace by logger
	//
	// System.err.println("Error in " + Gui.class.getName()
	// + ": Icon /images/" + iconName + " could not be loaded.");
	// return new ImageIcon();
	// }
	// return new ImageIcon(resource);
	// }

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == this.Karte) {
			System.out.println("Peter");
		} else if (ae.getSource().equals(getEinsatz())) {
			label.setText("Button 2 wurde betätigt");
			Spieler.spieler_kartenehmen();
		} else if (ae.getSource() == this.Aufgeben) {
			label.setText(("Button 3 wurde betätigt"));
			Spieler.spieler_kartenehmen();
		}
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