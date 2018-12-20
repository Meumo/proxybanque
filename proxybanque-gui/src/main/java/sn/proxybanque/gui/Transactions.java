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
		
		JButton buttonDebiter = new JButton("Retrait");
		buttonDebiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Debiter debiter=new Debiter(employerConnect.getId());
				panelFormulaire.removeAll();
				debiter.setBounds(209, 0, 745, 453);
				panelFormulaire.add(debiter);
				panelFormulaire.validate();
				
				
			}
		});
		buttonDebiter.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonDebiter.setIcon(new ImageIcon("C:\\Users\\image\\hire-me.png"));
		buttonDebiter.setBounds(0, 0, 209, 70);
		add(buttonDebiter);
		
		JButton buttonDepot = new JButton("Dépôt");
		buttonDepot.setHorizontalAlignment(SwingConstants.LEFT);
		buttonDepot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Depot depot=new Depot(employerConnect.getId());
				panelFormulaire.removeAll();
				depot.setBounds(209, 0, 745, 453);
				panelFormulaire.add(depot);
				panelFormulaire.validate();
			}
		});
		buttonDepot.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonDepot.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (2).jpg"));
		buttonDepot.setBounds(0, 71, 209, 70);
		add(buttonDepot);
		
		JButton buttonVirement = new JButton("Virement");
		buttonVirement.setHorizontalAlignment(SwingConstants.LEFT);
		buttonVirement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Virement virement=new Virement(employerConnect.getId());
				panelFormulaire.removeAll();
				virement.setBounds(209, 0, 745, 453);
				panelFormulaire.add(virement);
				panelFormulaire.validate();
			}
		});
		buttonVirement.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonVirement.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (3).jpg"));
		buttonVirement.setBounds(0, 140, 209, 70);
		add(buttonVirement);
		
		JButton buttonListeTransaction = new JButton("Liste des  Transaction");
		buttonListeTransaction.setToolTipText("lister les Cartes");
		buttonListeTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeTransaction listeTransaction=new ListeTransaction();
				panelFormulaire.removeAll();
				listeTransaction.setBounds(209, 0, 745, 453);
				panelFormulaire.add(listeTransaction);
				panelFormulaire.validate();
			}
		});
		buttonListeTransaction.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonListeTransaction.setIcon(new ImageIcon("C:\\Users\\image\\customers.png"));
		buttonListeTransaction.setBounds(0, 209, 209, 70);
		add(buttonListeTransaction);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\image\\images (4).jpg"));
		lblNewLabel.setBounds(0, 401, 209, 52);
		add(lblNewLabel);
		
		JButton buttonPlacement = new JButton("Gestion Placements");
		buttonPlacement.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonPlacement.setBounds(0, 279, 209, 63);
		add(buttonPlacement);
		
		JButton buttonGestionPatrimoine = new JButton("Gestion Gatrimoine");
		buttonGestionPatrimoine.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGestionPatrimoine.setBounds(0, 341, 209, 63);
		add(buttonGestionPatrimoine);

	}
}
