package sn.proxybanque.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sn.proxybanque.domaine.Employer;
import javax.swing.SwingConstants;

public class Auditer extends JPanel {

	/**
	 * Create the panel.
	 */
	public Auditer(final Employer employerConnect) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		final JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBounds(0, 70, 954, 394);
		add(panelFormulaire);
		panelFormulaire.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("");
		panelFormulaire.add(lblNewLabel_1, BorderLayout.WEST);

		JButton annalyse = new JButton("Analyse Des Comptes");
		annalyse.setBackground(new Color(102, 153, 255));
		annalyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListeDesTransactionAnormal listeDesTransactionAnormal=new ListeDesTransactionAnormal();
				panelFormulaire.removeAll();
				listeDesTransactionAnormal.setBounds(0, 70, 954, 394);
				panelFormulaire.add(listeDesTransactionAnormal);
				panelFormulaire.validate();

			}
		});
		annalyse.setFont(new Font("Tahoma", Font.BOLD, 15));
		annalyse.setIcon(new ImageIcon("C:\\Users\\image\\aa.jpg"));
		annalyse.setBounds(321, 0, 322, 70);
		add(annalyse);

	}
}
