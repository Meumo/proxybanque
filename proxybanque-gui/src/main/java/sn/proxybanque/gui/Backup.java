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

public class Backup extends JPanel {

	/**
	 * Create the panel.
	 */
	public Backup(final Employer employerConnect) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		final JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBounds(0, 70, 954, 394);
		add(panelFormulaire);
		panelFormulaire.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("");
		panelFormulaire.add(lblNewLabel_1, BorderLayout.WEST);

		JButton buttonListerLesCompte = new JButton("Liste des transaction  ");
		buttonListerLesCompte.setBackground(new Color(102, 153, 255));
		buttonListerLesCompte.setToolTipText("lister les Cartes");
		buttonListerLesCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeLog listeLog=new ListeLog();
				panelFormulaire.removeAll();
				listeLog.setBounds(0, 70, 954, 394);
				panelFormulaire.add(listeLog);
				panelFormulaire.validate();
			}
		});
		buttonListerLesCompte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonListerLesCompte.setIcon(new ImageIcon("C:\\Users\\image\\liscomp.jpg"));
		buttonListerLesCompte.setBounds(326, 0, 313, 70);
		add(buttonListerLesCompte);

	}
}
