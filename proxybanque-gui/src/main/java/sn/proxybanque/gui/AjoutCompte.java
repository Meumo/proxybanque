package sn.proxybanque.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import sn.proxybanque.domaine.Client;
import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceClientImp;
import sn.proxybanque.service.ServiceCompteImp;

public class AjoutCompte extends JPanel {
	private JTextField numeroCompte;
	private JTextField solde;
	private JTextField dateOuverture;
	Heure heure;
	Date dateEntre = null;
	Numero numero;

	/**
	 * Create the panel.
	 */
	public AjoutCompte() {
		setLayout(null);
		Employer employer;
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajout Carte", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(102, 102, 204)));
		panel.setBounds(-36, 11, 773, 453);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero Compte");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBounds(55, 54, 188, 30);
		panel.add(lblNewLabel);

		JLabel lblCodePostal = new JLabel("Numero Client");
		lblCodePostal.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblCodePostal.setBounds(55, 219, 188, 30);
		panel.add(lblCodePostal);

		JLabel lblProfession = new JLabel("Type de Compte");
		lblProfession.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblProfession.setBounds(55, 115, 188, 30);
		panel.add(lblProfession);

		JLabel lblVille = new JLabel("Solde");
		lblVille.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVille.setBounds(55, 173, 188, 30);
		panel.add(lblVille);

		JLabel dated = new JLabel("Date D'Ouverture");
		dated.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		dated.setBounds(55, 284, 188, 30);
		panel.add(dated);

		numeroCompte = new JTextField();
		numeroCompte.setEditable(false);
		numeroCompte.setBounds(313, 54, 228, 30);
		panel.add(numeroCompte);
		numeroCompte.setColumns(30);
		final Numero numero = new Numero();
		String num = numero.generateNumeroCompte();
		numeroCompte.setText(num);
		final JRadioButton compteEpargne = new JRadioButton("Epargne");
		compteEpargne.setEnabled(false);
		compteEpargne.setBounds(314, 116, 109, 30);

		final JRadioButton compteCourant = new JRadioButton("Courant");
		compteCourant.setEnabled(false);
		compteCourant.setBounds(432, 116, 109, 30);

		ButtonGroup groupeCarte = new ButtonGroup();
		groupeCarte.add(compteCourant);
		groupeCarte.add(compteEpargne);
		panel.add(compteCourant);
		panel.add(compteEpargne);

		final JComboBox listeClient = new JComboBox();
		// listeClient.set
		listeClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceCompteImp serviceCompteImp = new ServiceCompteImp();
				ServiceClientImp serviceClientImp = new ServiceClientImp();
				String numeroClient = (String) listeClient.getSelectedItem();
				Client client = serviceClientImp.rechercherParNumeroClient(numeroClient);
				if (client != null && serviceCompteImp.nbreCompte(client.getId()).size() != 0) {
					Compte compte = serviceCompteImp.nbreCompte(client.getId()).get(0);
					if (compte.getTypeDeCompte().equals("Epargne")) {
						compteCourant.setEnabled(true);
						compteCourant.setSelected(true);
					} else {
						compteEpargne.setEnabled(true);
						compteEpargne.setSelected(true);
					}
				}
				if (client != null && serviceCompteImp.nbreCompte(client.getId()).size() == 0) {
					compteEpargne.setEnabled(true);
					compteCourant.setEnabled(true);
				}
			}
		});
		listeClient.setBounds(313, 220, 228, 30);
		final ServiceClientImp serviceClientImp = new ServiceClientImp();
		listeClient.addItem("");
		for (Iterator iterator = serviceClientImp.lister().iterator(); iterator.hasNext();) {
			ServiceCompteImp serviceCompteImp = new ServiceCompteImp();
			Client client = (Client) iterator.next();
			int nbcompte = serviceCompteImp.nbreCompte(client.getId()).size();
			if (nbcompte < 2) {
				listeClient.addItem(client.getNumeroClient());
			}

		}
		panel.add(listeClient);

		solde = new JTextField();
		solde.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char car = evt.getKeyChar();
				if ((car < '0' || car > '9') && solde.getText().contains(".")
						&& (car != (char) KeyEvent.VK_BACK_SPACE)) {
					evt.consume();
					JOptionPane.showMessageDialog(null, "entre seulment des chiffre", "validation  ",
							JOptionPane.INFORMATION_MESSAGE);
				} else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
					evt.consume();
					JOptionPane.showMessageDialog(null, "SVP entrer seulement des chiffre",
							"message de confirmation d'ecrire seulment des numero ", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		solde.setBounds(313, 173, 228, 26);
		panel.add(solde);
		solde.setColumns(10);

		JList list = new JList();
		list.setBounds(388, 26, 1, 1);
		panel.add(list);

		JButton buttonValider = new JButton("Valider");
		buttonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double soldeEntre = 0;
				if (solde.getText().length() > 0) {
					soldeEntre = Double.parseDouble(solde.getText());
				}

				String numeroClient = (String) listeClient.getSelectedItem();
				if (numeroClient.equals("")) {
					JOptionPane.showMessageDialog(null, "Choisir un client pour le compte a creer ");
				} else {
					String typeCompte = "";
					int idClient = 0;
					double caracteristique = 0;
					String numeroCompt;
					numeroCompt = numeroCompte.getText();
					if (compteEpargne.isSelected()) {
						typeCompte = "Epargne";
						caracteristique = 0.03;

					} else {
						typeCompte = "Courant";

						caracteristique = 656510;
					}

					idClient = serviceClientImp.rechercherParNumeroClient(numeroClient).getId();

					if (idClient < 0 || solde.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "remplire tout les champ");

					} else {
						if (compteEpargne.isSelected()) {
							compteEpargne.setEnabled(true);
							compteCourant.setSelected(true);
						} else {
							compteCourant.setEnabled(true);
							compteEpargne.setSelected(true);
						}
						Compte compteCreer = new Compte();
						compteCreer.setDateOuvertureCompte(dateEntre);
						compteCreer.setNumeroCompte(numeroCompt);
						compteCreer.setTypeDeCompte(typeCompte);
						compteCreer.setSoldeCompte(soldeEntre);
						compteCreer.setIdClient(idClient);
						compteCreer.setCaracteristique(caracteristique);
						ServiceCompteImp serviceCompteImp = new ServiceCompteImp();
						serviceCompteImp.ajouter(compteCreer);

						JOptionPane.showMessageDialog(null, "Compte Creer");
						String newNumer0 = numero.generateNumeroCompte();
						numeroCompte.setText(newNumer0);
						solde.setText("");
						
						remove(panel);
						add(panel);
						validate();
						listeClient.setSelectedIndex(1);
					}
				}
			}
		});

		buttonValider.setIcon(new ImageIcon("C:\\Users\\image\\check.png"));
		buttonValider.setBackground(new Color(51, 204, 51));
		buttonValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonValider.setBounds(236, 369, 124, 30);
		panel.add(buttonValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		btnAnnuler.setIcon(new ImageIcon("C:\\Users\\image\\busy.png"));
		btnAnnuler.setBackground(new Color(255, 102, 0));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnnuler.setBounds(402, 369, 128, 30);
		panel.add(btnAnnuler);

		heure = new Heure();

		try {
			dateEntre = heure.daterecup();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		dateOuverture = new JTextField(dateEntre + "");

		dateOuverture.setEditable(false);
		dateOuverture.setBounds(313, 284, 228, 30);
		panel.add(dateOuverture);
		dateOuverture.setColumns(10);

	}
}
