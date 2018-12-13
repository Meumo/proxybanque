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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\image\\co.gif"));
		panelFormulaire.add(label, BorderLayout.WEST);
		
		JButton buttonCreerUnConseiller = new JButton("Creer un Conseiller");
		buttonCreerUnConseiller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjoutConseilles ajoutclient=new AjoutConseilles();
				panelFormulaire.removeAll();
				ajoutclient.setBounds(209, 0, 745, 453);
				panelFormulaire.add(ajoutclient);
				panelFormulaire.validate();
				
				
			}
		});
		buttonCreerUnConseiller.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonCreerUnConseiller.setIcon(new ImageIcon("C:\\Users\\image\\hire-me.png"));
		buttonCreerUnConseiller.setBounds(0, 0, 209, 70);
		add(buttonCreerUnConseiller);
		
		JButton buttonModifierUnConseiller = new JButton("Modifier un Conseiller");
		buttonModifierUnConseiller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierConseilles modifierConseilles =new ModifierConseilles ();
				panelFormulaire.removeAll();
				modifierConseilles .setBounds(209, 0, 745, 453);
				panelFormulaire.add(modifierConseilles );
				panelFormulaire.validate();
			}
			
		});
		buttonModifierUnConseiller.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonModifierUnConseiller.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (2).jpg"));
		buttonModifierUnConseiller.setBounds(0, 71, 209, 70);
		add(buttonModifierUnConseiller);
		
		JButton buttonSupprimerUnConseiller = new JButton("Supprimer un Conseiller");
		buttonSupprimerUnConseiller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerConseilles supprimerConseilles=new SupprimerConseilles();
				panelFormulaire.removeAll();
				supprimerConseilles.setBounds(209, 0, 745, 453);
				panelFormulaire.add(supprimerConseilles);
				panelFormulaire.validate();
			}
		});
		buttonSupprimerUnConseiller.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonSupprimerUnConseiller.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (3).jpg"));
		buttonSupprimerUnConseiller.setBounds(0, 140, 209, 70);
		add(buttonSupprimerUnConseiller);
		
		JButton buttonListerLesConseillers = new JButton("lister les Conseillers");
		buttonListerLesConseillers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeConseiller listeConseiller=new ListeConseiller();
				panelFormulaire.removeAll();
				listeConseiller.setBounds(209, 0, 745, 453);
				panelFormulaire.add(listeConseiller);
				panelFormulaire.validate();
			}
		});
		buttonListerLesConseillers.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonListerLesConseillers.setIcon(new ImageIcon("C:\\Users\\image\\customers.png"));
		buttonListerLesConseillers.setBounds(0, 209, 209, 70);
		add(buttonListerLesConseillers);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\image\\images (4).jpg"));
		lblNewLabel.setBounds(0, 278, 209, 175);
		add(lblNewLabel);

	}
	}
