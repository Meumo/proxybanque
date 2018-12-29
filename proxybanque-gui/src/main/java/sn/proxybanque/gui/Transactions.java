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
import javax.swing.SwingConstants;

import sn.proxybanque.domaine.Employer;

public class Transactions extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\image\\tansaction.png"));
		panelFormulaire.add(lblNewLabel_1, BorderLayout.WEST);

		JButton buttonDebiter = new JButton("Retrait");
		buttonDebiter.setBackground(new Color(102, 153, 255));
		buttonDebiter.setHorizontalAlignment(SwingConstants.LEFT);
		buttonDebiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Debiter debiter = new Debiter(employerConnect.getId());
				panelFormulaire.removeAll();
				debiter.setBounds(209, 0, 745, 453);
				panelFormulaire.add(debiter);
				panelFormulaire.validate();

			}
		});
		buttonDebiter.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonDebiter.setIcon(new ImageIcon("C:\\Users\\image\\depot.jpg"));
		buttonDebiter.setBounds(0, 0, 209, 70);
		add(buttonDebiter);

		JButton buttonDepot = new JButton("Dépôt");
		buttonDepot.setBackground(new Color(102, 153, 255));
		buttonDepot.setHorizontalAlignment(SwingConstants.LEFT);
		buttonDepot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Depot depot = new Depot(employerConnect.getId());
				panelFormulaire.removeAll();
				depot.setBounds(209, 0, 745, 453);
				panelFormulaire.add(depot);
				panelFormulaire.validate();
			}
		});
		buttonDepot.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonDepot.setIcon(new ImageIcon("C:\\Users\\image\\retrait.jpg"));
		buttonDepot.setBounds(0, 71, 209, 70);
		add(buttonDepot);

		JButton buttonVirement = new JButton("Virement");
		buttonVirement.setBackground(new Color(102, 153, 255));
		buttonVirement.setHorizontalAlignment(SwingConstants.LEFT);
		buttonVirement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Virement virement = new Virement(employerConnect.getId());
				panelFormulaire.removeAll();
				virement.setBounds(209, 0, 745, 453);
				panelFormulaire.add(virement);
				panelFormulaire.validate();
			}
		});
		buttonVirement.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonVirement.setIcon(new ImageIcon("C:\\Users\\image\\virement.png"));
		buttonVirement.setBounds(0, 140, 209, 70);
		add(buttonVirement);

		JButton buttonListeTransaction = new JButton("Liste des  Transaction");
		buttonListeTransaction.setBackground(new Color(102, 153, 255));
		buttonListeTransaction.setToolTipText("lister les Cartes");
		buttonListeTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeTransaction listeTransaction = new ListeTransaction();
				panelFormulaire.removeAll();
				listeTransaction.setBounds(209, 0, 745, 453);
				panelFormulaire.add(listeTransaction);
				panelFormulaire.validate();
			}
		});
		buttonListeTransaction.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonListeTransaction.setIcon(new ImageIcon("C:\\Users\\image\\listetran.jpg"));
		buttonListeTransaction.setBounds(0, 209, 209, 70);
		add(buttonListeTransaction);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(102, 153, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\image\\images (4).jpg"));
		lblNewLabel.setBounds(0, 401, 209, 52);
		add(lblNewLabel);

		JButton buttonPlacement = new JButton("Gestion Placements");
		buttonPlacement.setBackground(new Color(102, 153, 255));
		buttonPlacement.setIcon(new ImageIcon("C:\\Users\\image\\placement.jpg"));
		buttonPlacement.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonPlacement.setBounds(0, 279, 209, 63);
		add(buttonPlacement);

		JButton buttonGestionPatrimoine = new JButton("Gestion Gatrimoine");
		buttonGestionPatrimoine.setBackground(new Color(102, 153, 255));
		buttonGestionPatrimoine.setIcon(new ImageIcon("C:\\Users\\image\\gestionpa.jpg"));
		buttonGestionPatrimoine.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGestionPatrimoine.setBounds(0, 341, 209, 63);
		add(buttonGestionPatrimoine);

	}
}
