package sn.proxybanque.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Log;
import sn.proxybanque.domaine.Transaction;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceCompteImp;
import sn.proxybanque.service.ServiceLog;
import sn.proxybanque.service.ServiceTransaction;

public class Debiter extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField numeroCompte;
	private JTextField typeTansaction;
	private JTextField dateTransaction;
	private JTextField solde;
	private JTextField client;
	Compte compteARetire;
	final JPanel panelHaut;
	private JTextField montant;
	Date dateTrans = null;

	/**
	 * Create the panel.
	 */
	public Debiter(final int idConseiller) {
		setLayout(new BorderLayout(0, 0));
		final JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(176, 196, 222));
		panelCentre.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Compte Trouve",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
		add(panelCentre);
		panelCentre.setLayout(null);
		remove(panelCentre);

		JLabel lblNomt = new JLabel("Type De Transaction");
		lblNomt.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNomt.setBounds(55, 21, 188, 30);
		panelCentre.add(lblNomt);

		JLabel lblPrenomClient = new JLabel("Date de Transaction");
		lblPrenomClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblPrenomClient.setBounds(55, 73, 188, 30);
		panelCentre.add(lblPrenomClient);

		JLabel Visa = new JLabel("Solde");
		Visa.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		Visa.setBounds(55, 125, 188, 30);
		panelCentre.add(Visa);

		JLabel Client = new JLabel("Client");
		Client.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		Client.setBounds(55, 176, 188, 30);
		panelCentre.add(Client);

		typeTansaction = new JTextField();
		typeTansaction.setText("Retrait");
		typeTansaction.setEditable(false);
		typeTansaction.setBounds(313, 24, 228, 27);
		panelCentre.add(typeTansaction);
		typeTansaction.setColumns(30);

		dateTransaction = new JTextField();
		dateTransaction.setEditable(false);
		dateTransaction.setBounds(313, 74, 228, 30);
		panelCentre.add(dateTransaction);
		dateTransaction.setColumns(30);

		solde = new JTextField();
		solde.setEditable(false);
		solde.setBounds(313, 126, 228, 30);
		panelCentre.add(solde);
		solde.setColumns(30);

		client = new JTextField();
		client.setEditable(false);
		client.setBounds(313, 177, 228, 30);
		panelCentre.add(client);
		client.setColumns(30);

		JButton buttonDepot = new JButton("Valider");
		buttonDepot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceTransaction serviceTransaction = new ServiceTransaction();
				ServiceLog serviceLog = new ServiceLog();
				double montantARetire = 0;
				if (montant.getText().length() > 0) {
					montantARetire = Double.parseDouble(montant.getText());
				}
				if (serviceTransaction.retirer(compteARetire, montantARetire)) {
					if (JOptionPane.showConfirmDialog(null, "voulez vous confirmer le Retrait", "Confirmation",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						Transaction transaction;
						// serviceTransaction.retirer(compteARetire, montantARetire);
						Numero numero = new Numero();
						transaction = new Transaction();
						Log log = new Log();
						try {
							Heure heure = new Heure();
							transaction.setDateTransaction(heure.daterecup());
							log.setDateTransaction(heure.daterecup());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						String numeroTrang = numero.generateNumeroTransaction();

						transaction.setIdcompte(compteARetire.getIdCompte());
						transaction.setMontantTransaction(montantARetire);
						transaction.setIdconseiller(idConseiller);
						transaction.setNumeroTransaction(numeroTrang);
						transaction.setTypeTransaction("Retrait");

						log.setIdConseiller(idConseiller);
						log.setNumeroCompte(compteARetire.getNumeroCompte());
						log.setNumeroTransaction(numeroTrang);
						log.setMontantTransaction(montantARetire);
						log.setTypeTransaction("Retrait");
						serviceTransaction.create(transaction);
						serviceLog.creer(log);

						JOptionPane.showMessageDialog(null, "Retrait valider");
						panelCentre.setBounds(0, 53, 745, 412);
						remove(panelCentre);
						add(panelHaut);
						validate();
					}
				} else {
					JOptionPane.showMessageDialog(null, "ce montant ne peut pas etre retire du compte");
				}

			}
		});
		buttonDepot.setIcon(new ImageIcon("C:\\Users\\image\\check.png"));
		buttonDepot.setBackground(new Color(51, 204, 51));
		buttonDepot.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonDepot.setBounds(284, 282, 124, 30);
		panelCentre.add(buttonDepot);

		JButton buttonAnnuler = new JButton("Annuler");
		buttonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCentre.setBounds(0, 53, 745, 412);
				remove(panelCentre);
				add(panelHaut);
				validate();
			}
		});
		buttonAnnuler.setIcon(new ImageIcon("C:\\Users\\image\\busy.png"));
		buttonAnnuler.setBackground(new Color(255, 102, 0));
		buttonAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonAnnuler.setBounds(413, 282, 128, 30);
		panelCentre.add(buttonAnnuler);

		JLabel lblMontantADepose = new JLabel("Montant à Debiter");

		lblMontantADepose.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblMontantADepose.setBounds(55, 232, 188, 30);
		panelCentre.add(lblMontantADepose);

		montant = new JTextField();
		montant.addKeyListener(new KeyAdapter() {
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
		montant.setBounds(313, 227, 228, 30);
		panelCentre.add(montant);
		montant.setColumns(10);

		panelHaut = new JPanel();
		panelHaut.setBackground(new Color(176, 196, 222));
		add(panelHaut);
		panelHaut.setLayout(null);

		JLabel lblNewLabel = new JLabel("Entre Le Numero Du Compte");
		lblNewLabel.setBounds(10, 6, 235, 30);
		panelHaut.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));

		numeroCompte = new JTextField();
		numeroCompte.setBounds(275, 6, 228, 30);
		panelHaut.add(numeroCompte);
		numeroCompte.setColumns(30);

		JButton buttonRechercher = new JButton("Rechercher");
		buttonRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ServiceCompteImp serviceCompteImp = new ServiceCompteImp();
				String numeroEntre = numeroCompte.getText();
				if (numeroEntre.length() == 0) {
					JOptionPane.showMessageDialog(null, "entre le numero du compte pour le retrait");
				} else {
					compteARetire = serviceCompteImp.rechercherParNumeroCompte(numeroEntre);
					if (compteARetire == null) {
						JOptionPane.showMessageDialog(null, "le compte n'existe pas dans la basse de donnee");
					} else {

						typeTansaction.setText("Retrait");
						try {
							Heure heure = new Heure();
							dateTransaction.setText(heure.daterecup() + "");
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						solde.setText(compteARetire.getSoldeCompte() + "");

						client.setText(compteARetire.getIdClient() + "");
						remove(panelHaut);
						add(panelCentre);
						validate();
					}
				}

			}
		});
		buttonRechercher.setBackground(Color.GREEN);
		buttonRechercher.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonRechercher.setIcon(new ImageIcon("C:\\Users\\image\\search.png"));
		buttonRechercher.setBounds(520, 6, 147, 28);
		panelHaut.add(buttonRechercher);

	}
}
