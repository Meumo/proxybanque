package sn.proxybanque.gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Accueille extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Accueille() {
		setBackground(new Color(245, 245, 245));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\image\\acc.gif"));
		add(label);

	}

}
