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

public class CartesBanque extends JPanel {

	/**
	 * Create the panel.
	 */
	public CartesBanque(final Employer employerConnect) {
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		final JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBounds(209, 0, 745, 453);
		add(panelFormulaire);
		panelFormulaire.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\image\\bannerfans_20208537.jpg"));
		panelFormulaire.add(lblNewLabel_1, BorderLayout.WEST);
		
		JButton buttonCreerUnCarte = new JButton("Creer une Carte");
		buttonCreerUnCarte.setBackground(new Color(102, 153, 255));
		buttonCreerUnCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AjoutCarte ajoutCarte=new AjoutCarte();
				panelFormulaire.removeAll();
				ajoutCarte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(ajoutCarte);
				panelFormulaire.validate();
				
				
			}
		});
		buttonCreerUnCarte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonCreerUnCarte.setIcon(new ImageIcon("C:\\Users\\image\\carte.jpg"));
		buttonCreerUnCarte.setBounds(0, 0, 209, 70);
		add(buttonCreerUnCarte);
		
		JButton buttonModifierUneCarte = new JButton("Modifier une Carte");
		buttonModifierUneCarte.setBackground(new Color(102, 153, 255));
		buttonModifierUneCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierCarte modifierCarte=new ModifierCarte();
				panelFormulaire.removeAll();
				modifierCarte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(modifierCarte);
				panelFormulaire.validate();
			}
		});
		buttonModifierUneCarte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonModifierUneCarte.setIcon(new ImageIcon("C:\\Users\\image\\modicart.png"));
		buttonModifierUneCarte.setBounds(0, 71, 209, 70);
		add(buttonModifierUneCarte);
		
		JButton buttonSupprimerUneCarte = new JButton("Supprimer une Carte");
		buttonSupprimerUneCarte.setBackground(new Color(102, 153, 255));
		buttonSupprimerUneCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerCarte supprimerCarte=new SupprimerCarte();
				panelFormulaire.removeAll();
				supprimerCarte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(supprimerCarte);
				panelFormulaire.validate();
			}
		});
		buttonSupprimerUneCarte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonSupprimerUneCarte.setIcon(new ImageIcon("C:\\Users\\image\\supcart.png"));
		buttonSupprimerUneCarte.setBounds(0, 140, 209, 70);
		add(buttonSupprimerUneCarte);
		
		JButton buttonListerLesCartes = new JButton("lister les Cartes");
		buttonListerLesCartes.setBackground(new Color(102, 153, 255));
		buttonListerLesCartes.setToolTipText("lister les Cartes");
		buttonListerLesCartes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeCarte listClient=new ListeCarte();
				panelFormulaire.removeAll();
				listClient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(listClient);
				panelFormulaire.validate();
			}
		});
		buttonListerLesCartes.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonListerLesCartes.setIcon(new ImageIcon("C:\\Users\\image\\listecarte.png"));
		buttonListerLesCartes.setBounds(0, 209, 209, 70);
		add(buttonListerLesCartes);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(102, 153, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\image\\images (4).jpg"));
		lblNewLabel.setBounds(0, 278, 209, 175);
		add(lblNewLabel);

	}
}
