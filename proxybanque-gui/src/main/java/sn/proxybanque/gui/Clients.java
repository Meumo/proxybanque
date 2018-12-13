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

public class Clients extends JPanel {

	/**
	 * Create the panel.
	 */
	public Clients(final Employer employerConnect) {
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		final JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBounds(209, 0, 745, 453);
		add(panelFormulaire);
		panelFormulaire.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\image\\clie.gif"));
		panelFormulaire.add(lblNewLabel_1, BorderLayout.WEST);
		
		JButton buttonCreerUnClient = new JButton("Creer un Client");
		buttonCreerUnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjoutClient ajoutclient=new AjoutClient(employerConnect.getId());
				panelFormulaire.removeAll();
				
				ajoutclient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(ajoutclient);
				panelFormulaire.validate();
				
				
			}
		});
		buttonCreerUnClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonCreerUnClient.setIcon(new ImageIcon("C:\\Users\\image\\hire-me.png"));
		buttonCreerUnClient.setBounds(0, 0, 209, 70);
		add(buttonCreerUnClient);
		
		JButton buttonModifierUnClient = new JButton("Modifier un Client");
		buttonModifierUnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonModifierUnClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonModifierUnClient.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (2).jpg"));
		buttonModifierUnClient.setBounds(0, 71, 209, 70);
		add(buttonModifierUnClient);
		
		JButton buttonSupprimerUnClient = new JButton("Supprimer un Client");
		buttonSupprimerUnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerClient supprimerClient=new SupprimerClient();
				panelFormulaire.removeAll();
				supprimerClient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(supprimerClient);
				panelFormulaire.validate();
			}
		});
		buttonSupprimerUnClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonSupprimerUnClient.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (3).jpg"));
		buttonSupprimerUnClient.setBounds(0, 140, 209, 70);
		add(buttonSupprimerUnClient);
		
		JButton buttonListerLesClients = new JButton("lister les Clients");
		buttonListerLesClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeClient listClient=new ListeClient ();
				panelFormulaire.removeAll();
				listClient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(listClient);
				panelFormulaire.validate();
			}
		});
		buttonListerLesClients.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonListerLesClients.setIcon(new ImageIcon("C:\\Users\\image\\customers.png"));
		buttonListerLesClients.setBounds(0, 209, 209, 70);
		add(buttonListerLesClients);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\image\\images (4).jpg"));
		lblNewLabel.setBounds(0, 278, 209, 175);
		add(lblNewLabel);

	}
}
