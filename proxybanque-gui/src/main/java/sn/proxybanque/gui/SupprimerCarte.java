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
import sn.proxybanque.domaine.Client;
import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceCarteImp;
import sn.proxybanque.service.ServiceClientImp;

public class SupprimerCarte extends JPanel {
	private JTextField numeroCarte;
	private JTextField codeSecret;
	private JTextField dateExpiration;
	private JTextField typeVisa;
	private JTextField client;
	Carte carteASupprimer;
	final JPanel panelHaut;

	/**
	 * Create the panel.
	 */
	public SupprimerCarte() {
		Employer employer;
		setLayout(new BorderLayout(0, 0));
		final JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(176, 196, 222));
		panelCentre.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Carte Trouve", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
		add(panelCentre);
		panelCentre.setLayout(null);
		remove(panelCentre);

		JLabel lblNomt = new JLabel("Code Secret");
		lblNomt.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNomt.setBounds(55, 21, 188, 30);
		panelCentre.add(lblNomt);

		JLabel lblPrenomClient = new JLabel("Date Expiration");
		lblPrenomClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblPrenomClient.setBounds(55, 86, 188, 30);
		panelCentre.add(lblPrenomClient);

		JLabel Visa = new JLabel("Visa");
		Visa.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		Visa.setBounds(55, 146, 188, 30);
		panelCentre.add(Visa);

		JLabel Client = new JLabel("Client");
		Client.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		Client.setBounds(55, 219, 188, 30);
		panelCentre.add(Client);
		Numero numero = new Numero();
		String num = numero.generateNumeroEmploye();

		codeSecret = new JTextField();
		codeSecret.setEditable(false);
		codeSecret.setBounds(313, 24, 228, 27);
		panelCentre.add(codeSecret);
		codeSecret.setColumns(30);

		dateExpiration = new JTextField();
		dateExpiration.setEditable(false);
		dateExpiration.setBounds(313, 87, 228, 30);
		panelCentre.add(dateExpiration);
		dateExpiration.setColumns(30);

		typeVisa = new JTextField();
		typeVisa.setEditable(false);
		typeVisa.setBounds(313, 148, 228, 30);
		panelCentre.add(typeVisa);
		typeVisa.setColumns(30);

		// buttonGroup.add(buttonSexeConseillerFemme);
		// buttonGroup.add(buttonSexeconseillerHomme);

		final JDateChooser dateNaissanceConseiller;

		client = new JTextField();
		client.setEditable(false);
		client.setBounds(313, 220, 228, 30);
		panelCentre.add(client);
		client.setColumns(30);

		JList list = new JList();
		list.setBounds(388, 26, 1, 1);
		panelCentre.add(list);

		JButton buttonSupprimer = new JButton("Supprimer");
		buttonSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "voulez vous confirmer la suppression du Carte",
						"Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String type = "Carte";
					ServiceCarteImp serviceCarteImp=new ServiceCarteImp();
					serviceCarteImp.supprimer(carteASupprimer);
					JOptionPane.showMessageDialog(null, type + " supprimer");
					panelCentre.setBounds(0, 53, 745, 412);
					remove(panelCentre);
					add(panelHaut);
					validate();
				}

			}
		});
		buttonSupprimer.setIcon(new ImageIcon("C:\\Users\\image\\check.png"));
		buttonSupprimer.setBackground(new Color(51, 204, 51));
		buttonSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonSupprimer.setBounds(284, 282, 124, 30);
		panelCentre.add(buttonSupprimer);

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

		panelHaut = new JPanel();
		panelHaut.setBackground(new Color(176, 196, 222));
		add(panelHaut);
		panelHaut.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero Du Carte a Supprimer");
		lblNewLabel.setBounds(10, 6, 235, 30);
		panelHaut.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));

		numeroCarte = new JTextField();
		numeroCarte.setBounds(275, 6, 228, 30);
		panelHaut.add(numeroCarte);
		numeroCarte.setColumns(30);

		JButton buttonRechercher = new JButton("Rechercher");
		buttonRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ServiceCarteImp serviceCarteImp=new ServiceCarteImp();
				String numeroEntre = numeroCarte.getText();
				if (numeroEntre.length() == 0) {
					JOptionPane.showMessageDialog(null, "entre le numero du carte a supprimer");
				} else {
					carteASupprimer=serviceCarteImp.rechercherParNumeroCarte(numeroEntre);
					if (carteASupprimer == null) {
						JOptionPane.showMessageDialog(null, "la carte n'existe pas dans la basse de donnee");
					} else {
                        
						codeSecret.setText(carteASupprimer.getCodeSecretCarte());
						dateExpiration.setText(carteASupprimer.getDateExpirationCarte()+"");
						typeVisa.setText(carteASupprimer.getTypeCarte());
						client.setText(carteASupprimer.getIdClient()+"");
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
