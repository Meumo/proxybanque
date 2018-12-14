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
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\image\\clie.gif"));
		panelFormulaire.add(lblNewLabel_1, BorderLayout.WEST);
		
		JButton buttonCreerUnCarte = new JButton("Creer une Carte");
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
		buttonCreerUnCarte.setIcon(new ImageIcon("C:\\Users\\image\\hire-me.png"));
		buttonCreerUnCarte.setBounds(0, 0, 209, 70);
		add(buttonCreerUnCarte);
		
		JButton buttonModifierUneCarte = new JButton("Modifier une Carte");
		buttonModifierUneCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierClient modifierClient =new ModifierClient(employerConnect.getId());
				panelFormulaire.removeAll();
				modifierClient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(modifierClient);
				panelFormulaire.validate();
			}
		});
		buttonModifierUneCarte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonModifierUneCarte.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (2).jpg"));
		buttonModifierUneCarte.setBounds(0, 71, 209, 70);
		add(buttonModifierUneCarte);
		
		JButton buttonSupprimerUneCarte = new JButton("Supprimer une Carte");
		buttonSupprimerUneCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerClient supprimerClient=new SupprimerClient();
				panelFormulaire.removeAll();
				supprimerClient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(supprimerClient);
				panelFormulaire.validate();
			}
		});
		buttonSupprimerUneCarte.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonSupprimerUneCarte.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (3).jpg"));
		buttonSupprimerUneCarte.setBounds(0, 140, 209, 70);
		add(buttonSupprimerUneCarte);
		
		JButton buttonListerLesCartes = new JButton("lister les Cartes");
		buttonListerLesCartes.setToolTipText("lister les Cartes");
		buttonListerLesCartes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeClient listClient=new ListeClient ();
				panelFormulaire.removeAll();
				listClient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(listClient);
				panelFormulaire.validate();
			}
		});
		buttonListerLesCartes.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonListerLesCartes.setIcon(new ImageIcon("C:\\Users\\image\\customers.png"));
		buttonListerLesCartes.setBounds(0, 209, 209, 70);
		add(buttonListerLesCartes);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\image\\images (4).jpg"));
		lblNewLabel.setBounds(0, 278, 209, 175);
		add(lblNewLabel);

	}
}
