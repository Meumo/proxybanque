package org.proxybanque.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Conseiller extends JPanel {

	/**
	 * Create the panel.
	 */
	public Conseiller() {
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		final JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBounds(209, 0, 745, 453);
		add(panelFormulaire);
		panelFormulaire.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\clie.gif"));
		panelFormulaire.add(lblNewLabel_1, BorderLayout.WEST);
		
		JButton buttonCreerUnConseiller = new JButton("Creer un Conseiller");
		buttonCreerUnConseiller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajoutclient ajoutclient=new Ajoutclient();
				panelFormulaire.removeAll();
				ajoutclient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(ajoutclient);
				panelFormulaire.validate();
				
				
			}
		});
		buttonCreerUnConseiller.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonCreerUnConseiller.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\hire-me.png"));
		buttonCreerUnConseiller.setBounds(0, 0, 209, 70);
		add(buttonCreerUnConseiller);
		
		JButton buttonModifierUnConseiller = new JButton("Modifier un Conseiller");
		buttonModifierUnConseiller.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonModifierUnConseiller.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\téléchargement (2).jpg"));
		buttonModifierUnConseiller.setBounds(0, 71, 209, 70);
		add(buttonModifierUnConseiller);
		
		JButton buttonSupprimerUnConseiller = new JButton("Supprimer un Conseiller");
		buttonSupprimerUnConseiller.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonSupprimerUnConseiller.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\téléchargement (3).jpg"));
		buttonSupprimerUnConseiller.setBounds(0, 140, 209, 70);
		add(buttonSupprimerUnConseiller);
		
		JButton buttonListerLesConseillers = new JButton("lister les Conseillers");
		buttonListerLesConseillers.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonListerLesConseillers.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\customers.png"));
		buttonListerLesConseillers.setBounds(0, 209, 209, 70);
		add(buttonListerLesConseillers);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\images (4).jpg"));
		lblNewLabel.setBounds(0, 278, 209, 175);
		add(lblNewLabel);

	}
}
