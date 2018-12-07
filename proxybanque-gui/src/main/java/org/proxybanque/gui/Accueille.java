package org.proxybanque.gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Accueille extends JPanel {

	/**
	 * Create the panel.
	 */
	public Accueille() {
		setBackground(new Color(245, 245, 245));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\acc.gif"));
		add(label);

	}

}
