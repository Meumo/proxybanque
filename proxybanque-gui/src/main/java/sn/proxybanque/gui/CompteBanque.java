package sn.proxybanque.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import sn.proxybanque.domaine.Employer;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		panelFormulaire.add(lblNewLabel_1, BorderLayout.WEST);
		
		JButton buttonCreerUnCompte = new JButton("Creer un Compte");
		buttonCreerUnCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AjoutCompte ajoutCompte=new AjoutCompte();
				panelFormulaire.removeAll();
				
				ajoutCompte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(ajoutCompte);
				panelFormulaire.validate();
				
				
			}
		});
		buttonCreerUnCompte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonCreerUnCompte.setIcon(new ImageIcon("C:\\Users\\image\\hire-me.png"));
		buttonCreerUnCompte.setBounds(0, 0, 209, 70);
		add(buttonCreerUnCompte);
		
		JButton buttonModifierUnCompte = new JButton("Modifier un Compte");
		buttonModifierUnCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierCarte modifierCarte=new ModifierCarte();
				panelFormulaire.removeAll();
				modifierCarte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(modifierCarte);
				panelFormulaire.validate();
			}
		});
		buttonModifierUnCompte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonModifierUnCompte.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (2).jpg"));
		buttonModifierUnCompte.setBounds(0, 71, 209, 70);
		add(buttonModifierUnCompte);
		
		JButton buttonSupprimerUnCompte = new JButton("Supprimer un Compte");
		buttonSupprimerUnCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerCarte supprimerCarte=new SupprimerCarte();
				panelFormulaire.removeAll();
				supprimerCarte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(supprimerCarte);
				panelFormulaire.validate();
			}
		});
		buttonSupprimerUnCompte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonSupprimerUnCompte.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (3).jpg"));
		buttonSupprimerUnCompte.setBounds(0, 140, 209, 70);
		add(buttonSupprimerUnCompte);
		
		JButton buttonListerLesCompte = new JButton("lister les Compte");
		buttonListerLesCompte.setToolTipText("lister les Cartes");
		buttonListerLesCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeCarte listClient=new ListeCarte();
				panelFormulaire.removeAll();
				listClient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(listClient);
				panelFormulaire.validate();
			}
		});
		buttonListerLesCompte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonListerLesCompte.setIcon(new ImageIcon("C:\\Users\\image\\customers.png"));
		buttonListerLesCompte.setBounds(0, 209, 209, 70);
		add(buttonListerLesCompte);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\image\\images (4).jpg"));
		lblNewLabel.setBounds(0, 278, 209, 175);
		add(lblNewLabel);

	}
}
