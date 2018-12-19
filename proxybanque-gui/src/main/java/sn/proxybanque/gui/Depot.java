package sn.proxybanque.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import sn.proxybanque.domaine.Carte;
import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceCarteImp;
import sn.proxybanque.service.ServiceCompteImp;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Depot extends JPanel {
	private JTextField numeroCompte;
	private JTextField typeCompte;
	private JTextField dateOuverture;
	private JTextField solde;
	private JTextField client;
	Compte compteADeposer;
	final JPanel panelHaut;
	private JTextField montant;

	/**
	 * Create the panel.
	 */
	public Depot() {
		Employer employer;
		setLayout(null);
		final JPanel panelCentre = new JPanel();
		panelCentre.setBounds(0, 46, 755, 407);
		panelCentre.setBackground(new Color(176, 196, 222));
		panelCentre.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Compte Trouve", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
		add(panelCentre);
		panelCentre.setLayout(null);
		remove(panelCentre);

		JLabel lblNomt = new JLabel("Type De Compte");
		lblNomt.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNomt.setBounds(55, 21, 188, 30);
		panelCentre.add(lblNomt);

		JLabel lblPrenomClient = new JLabel("Date D'ouverture");
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
		Numero numero = new Numero();
		String num = numero.generateNumeroEmploye();

		typeCompte = new JTextField();
		typeCompte.setEditable(false);
		typeCompte.setBounds(313, 24, 228, 27);
		panelCentre.add(typeCompte);
		typeCompte.setColumns(30);

		dateOuverture = new JTextField();
		dateOuverture.setEditable(false);
		dateOuverture.setBounds(313, 74, 228, 30);
		panelCentre.add(dateOuverture);
		dateOuverture.setColumns(30);

		solde = new JTextField();
		solde.setEditable(false);
		solde.setBounds(313, 126, 228, 30);
		panelCentre.add(solde);
		solde.setColumns(30);

		// buttonGroup.add(buttonSexeConseillerFemme);
		// buttonGroup.add(buttonSexeconseillerHomme);

		final JDateChooser dateNaissanceConseiller;

		client = new JTextField();
		client.setEditable(false);
		client.setBounds(313, 177, 228, 30);
		panelCentre.add(client);
		client.setColumns(30);

		JList list = new JList();
		list.setBounds(388, 26, 1, 1);
		panelCentre.add(list);

		JButton buttonDepot = new JButton("Valider");
		buttonDepot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "voulez vous confirmer le Depot",
						"Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					ServiceCompteImp serviceCompteImp=new ServiceCompteImp();
					serviceCompteImp.supprimer(compteADeposer);
					JOptionPane.showMessageDialog(null, "depot valider");
					panelCentre.setBounds(0, 53, 745, 412);
					remove(panelCentre);
					add(panelHaut);
					validate();
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
		
		JLabel lblMontantADepose = new JLabel("Montant a Depose");
		lblMontantADepose.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblMontantADepose.setBounds(55, 232, 188, 30);
		panelCentre.add(lblMontantADepose);
		
		montant = new JTextField();
		montant.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char car= evt.getKeyChar();
		        if((car<'0' || car>'9' ) && solde.getText().contains(".")
		            && (car!=(char)KeyEvent.VK_BACK_SPACE))
		        {
		            evt.consume();
		            JOptionPane.showMessageDialog(null,"entre seulment des chiffre","validation  "
		                ,JOptionPane.INFORMATION_MESSAGE);
		        } else if((car<'0' ||car>'9')&&(car!='.')
		            &&(car!=(char)KeyEvent.VK_BACK_SPACE)){
		            evt.consume();
		            JOptionPane.showMessageDialog(null,"SVP entrer seulement des chiffre","message de confirmation d'ecrire seulment des numero "
		                ,JOptionPane.INFORMATION_MESSAGE); }
			}
		});
		montant.setBounds(313, 227, 228, 30);
		panelCentre.add(montant);
		montant.setColumns(10);

		panelHaut = new JPanel();
		panelHaut.setBounds(0, 0, 745, 46);
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

				ServiceCompteImp serviceCompteImp=new ServiceCompteImp();
				String numeroEntre = numeroCompte.getText();
				if (numeroEntre.length() == 0) {
					JOptionPane.showMessageDialog(null, "entre le numero du compte pour le depot");
				} else {
					compteADeposer=serviceCompteImp.rechercherParNumeroCompte(numeroEntre);
					if (compteADeposer == null) {
						JOptionPane.showMessageDialog(null, "le compte n'existe pas dans la basse de donnee");
					} else {
                        
						typeCompte.setText(compteADeposer.getTypeDeCompte());
						dateOuverture.setText(compteADeposer.getDateOuvetureCompte()+"");
						solde.setText(compteADeposer.getSoldeCompte()+"");
						client.setText(compteADeposer.getIdClient()+"");
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
