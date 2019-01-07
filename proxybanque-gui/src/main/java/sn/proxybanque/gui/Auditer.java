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
		setBackground(new Color(0, 191, 255));
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
		annalyse.setBounds(0, 0, 322, 70);
		add(annalyse);

		JButton transactionSupprimer = new JButton("Liste des transaction supprimé");
		transactionSupprimer.setBackground(new Color(102, 153, 255));
		transactionSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeTransactionSupprimer listeTransactionSupprimer=new ListeTransactionSupprimer();
				panelFormulaire.removeAll();
				listeTransactionSupprimer.setBounds(0, 70, 954, 394);
				panelFormulaire.add(listeTransactionSupprimer);
				panelFormulaire.validate();
			} 
		});
		transactionSupprimer.setFont(new Font("Tahoma", Font.BOLD, 15));
		transactionSupprimer.setIcon(new ImageIcon("C:\\Users\\image\\moco.jpg"));
		transactionSupprimer.setBounds(320, 0, 322, 70);
		add(transactionSupprimer);

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
		buttonListerLesCompte.setBounds(641, 0, 313, 70);
		add(buttonListerLesCompte);

	}
}
