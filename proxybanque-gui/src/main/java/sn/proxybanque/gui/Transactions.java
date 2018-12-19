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

public class Transactions extends JPanel {

	/**
	 * Create the panel.
	 */
	public Transactions(final Employer employerConnect) {
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		final JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBounds(209, 0, 745, 453);
		add(panelFormulaire);
		panelFormulaire.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelFormulaire.add(lblNewLabel_1, BorderLayout.WEST);
		
		JButton buttonDebiter = new JButton("Débiter Un Compte");
		buttonDebiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AjoutCarte ajoutCarte=new AjoutCarte();
				panelFormulaire.removeAll();
				
				ajoutCarte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(ajoutCarte);
				panelFormulaire.validate();
				
				
			}
		});
		buttonDebiter.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonDebiter.setIcon(new ImageIcon("C:\\Users\\image\\hire-me.png"));
		buttonDebiter.setBounds(0, 0, 209, 70);
		add(buttonDebiter);
		
		JButton buttonDepot = new JButton("Dépôt");
		buttonDepot.setHorizontalAlignment(SwingConstants.LEFT);
		buttonDepot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Depot depot=new Depot();
				panelFormulaire.removeAll();
				depot.setBounds(209, 0, 745, 453);
				panelFormulaire.add(depot);
				panelFormulaire.validate();
			}
		});
		buttonDepot.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonDepot.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (2).jpg"));
		buttonDepot.setBounds(0, 71, 209, 70);
		add(buttonDepot);
		
		JButton buttonVirement = new JButton("Virement");
		buttonVirement.setHorizontalAlignment(SwingConstants.LEFT);
		buttonVirement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerCarte supprimerCarte=new SupprimerCarte();
				panelFormulaire.removeAll();
				supprimerCarte.setBounds(209, 0, 745, 453);
				panelFormulaire.add(supprimerCarte);
				panelFormulaire.validate();
			}
		});
		buttonVirement.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonVirement.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (3).jpg"));
		buttonVirement.setBounds(0, 140, 209, 70);
		add(buttonVirement);
		
		JButton buttonGestionPatrimoine = new JButton("Gestion Gatrimoine");
		buttonGestionPatrimoine.setToolTipText("lister les Cartes");
		buttonGestionPatrimoine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeCarte listClient=new ListeCarte();
				panelFormulaire.removeAll();
				listClient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(listClient);
				panelFormulaire.validate();
			}
		});
		buttonGestionPatrimoine.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonGestionPatrimoine.setIcon(new ImageIcon("C:\\Users\\image\\customers.png"));
		buttonGestionPatrimoine.setBounds(0, 209, 209, 70);
		add(buttonGestionPatrimoine);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\image\\images (4).jpg"));
		lblNewLabel.setBounds(0, 341, 209, 112);
		add(lblNewLabel);
		
		JButton buttonPlacement = new JButton("Gestion Placements");
		buttonPlacement.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonPlacement.setBounds(0, 279, 209, 63);
		add(buttonPlacement);

	}
}
