package JBlackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
	// JPanel
	JPanel Button = new JPanel();
	JPanel Navigation = new JPanel();
	JPanel Karten = new JPanel();
	// Buttons
	JButton Karte = new JButton("Karte nehmen");
	JButton Einsatz = new JButton("Einsatz erhöhen");
	JButton Aufgeben = new JButton("Aufgeben");
	JButton Verlassen = new JButton("Verlassen");
	// Karten
	protected static final Icon newImageIcon = loadIcon("Spade Ace.jpg");
	JMenuItem newMenuItem = new JMenuItem(newImageIcon);

	public Gui() {
		// Elemente zu dem JFrame hinzufügen
		Button.add(Einsatz, BorderLayout.SOUTH);
		Button.add(Karte, BorderLayout.SOUTH);
		Button.add(Aufgeben, BorderLayout.SOUTH);
		Navigation.add(Verlassen, BorderLayout.NORTH);
		Karten.add(newMenuItem, BorderLayout.CENTER);
		add(Button, BorderLayout.SOUTH);
		add(Navigation, BorderLayout.EAST);
		add(Karten,BorderLayout.CENTER);

		// JFrame Eigenschaften
		setSize(1000, 1000);
		getContentPane().setBackground(new Color(10, 108, 3));
		setTitle("JBlackJack");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Gui();
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

}


