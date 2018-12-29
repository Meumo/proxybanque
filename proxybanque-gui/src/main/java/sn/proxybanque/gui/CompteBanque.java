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

public class CompteBanque extends JPanel {

	/**
	 * Create the panel.
	 */
	public CompteBanque(final Employer employerConnect) {
		setBackground(new Color(0, 191, 255));
		setLayout(null);

		final JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBounds(209, 0, 745, 453);
		add(panelFormulaire);
		panelFormulaire.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\image\\compte.png"));
		panelFormulaire.add(lblNewLabel_1, BorderLayout.WEST);

		JButton buttonCreerUnCompte = new JButton("Creer un Compte");
		buttonCreerUnCompte.setBackground(new Color(102, 153, 255));
		buttonCreerUnCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AjoutCompte ajoutCompte = new AjoutCompte();
				panelFormulaire.removeAll();

				ajoutCompte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(ajoutCompte);
				panelFormulaire.validate();

			}
		});
		buttonCreerUnCompte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonCreerUnCompte.setIcon(new ImageIcon("C:\\Users\\image\\aa.jpg"));
		buttonCreerUnCompte.setBounds(0, 0, 209, 70);
		add(buttonCreerUnCompte);

		JButton buttonModifierUnCompte = new JButton("Modifier un Compte");
		buttonModifierUnCompte.setBackground(new Color(102, 153, 255));
		buttonModifierUnCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierCompte modifierCompte = new ModifierCompte();
				panelFormulaire.removeAll();
				modifierCompte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(modifierCompte);
				panelFormulaire.validate();
			}
		});
		buttonModifierUnCompte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonModifierUnCompte.setIcon(new ImageIcon("C:\\Users\\image\\moco.jpg"));
		buttonModifierUnCompte.setBounds(0, 71, 209, 70);
		add(buttonModifierUnCompte);

		JButton buttonSupprimerUnCompte = new JButton("Supprimer un Compte");
		buttonSupprimerUnCompte.setBackground(new Color(102, 153, 255));
		buttonSupprimerUnCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerCompte supprimerCompte = new SupprimerCompte();
				panelFormulaire.removeAll();
				supprimerCompte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(supprimerCompte);
				panelFormulaire.validate();
			}
		});
		buttonSupprimerUnCompte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonSupprimerUnCompte.setIcon(new ImageIcon("C:\\Users\\image\\suppri.jpg"));
		buttonSupprimerUnCompte.setBounds(0, 140, 209, 70);
		add(buttonSupprimerUnCompte);

		JButton buttonListerLesCompte = new JButton("lister les Compte");
		buttonListerLesCompte.setBackground(new Color(102, 153, 255));
		buttonListerLesCompte.setToolTipText("lister les Cartes");
		buttonListerLesCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeCompte listeCompte = new ListeCompte();
				panelFormulaire.removeAll();
				listeCompte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(listeCompte);
				panelFormulaire.validate();
			}
		});
		buttonListerLesCompte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonListerLesCompte.setIcon(new ImageIcon("C:\\Users\\image\\liscomp.jpg"));
		buttonListerLesCompte.setBounds(0, 209, 209, 70);
		add(buttonListerLesCompte);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(102, 153, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\image\\images (4).jpg"));
		lblNewLabel.setBounds(0, 332, 209, 121);
		add(lblNewLabel);
		
		JButton releveButton = new JButton("Releve bancaire");
		releveButton.setBackground(new Color(102, 153, 255));
		releveButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		releveButton.setHorizontalAlignment(SwingConstants.LEFT);
		releveButton.setVerticalAlignment(SwingConstants.TOP);
		releveButton.setIcon(new ImageIcon("C:\\Users\\image\\releve.jpg"));
		releveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReleverBancaire releveBancaire = new ReleverBancaire();
			panelFormulaire.removeAll();
			releveBancaire.setBounds(209, 0, 745, 453);
			panelFormulaire.add(releveBancaire);
			panelFormulaire.validate();
			}
		});
		releveButton.setBounds(0, 278, 209, 48);
		add(releveButton);

	}
}
