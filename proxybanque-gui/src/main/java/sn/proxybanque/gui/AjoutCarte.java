package sn.proxybanque.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.toedter.calendar.JDateChooser;

import sn.proxybanque.domaine.Carte;
import sn.proxybanque.domaine.Client;
import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceCarteImp;
import sn.proxybanque.service.ServiceClientImp;
import sn.proxybanque.service.ServiceCompteImp;

public class AjoutCarte extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField numeroCarte;
	private JTextField codesecret;
	private JTextField dateExpriation;
	// private ButtonGroup buttonGroup;
	Heure heure=new Heure();
	/**
	 * Create the panel.
	 */
	public AjoutCarte() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajout Carte", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(102, 102, 204)));
		panel.setBounds(-42, 11, 773, 453);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero Carte");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBounds(55, 54, 188, 30);
		panel.add(lblNewLabel);

		JLabel lblCodePostal = new JLabel("Numero Client");
		lblCodePostal.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblCodePostal.setBounds(55, 219, 188, 30);
		panel.add(lblCodePostal);

		JLabel lblProfession = new JLabel("Carte Visa");
		lblProfession.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblProfession.setBounds(55, 115, 188, 30);
		panel.add(lblProfession);

		JLabel lblVille = new JLabel("Code Secret");
		lblVille.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVille.setBounds(55, 173, 188, 30);
		panel.add(lblVille);

		JLabel dated = new JLabel("Date D'Expriation");
		dated.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		dated.setBounds(55, 284, 188, 30);
		panel.add(dated);

		numeroCarte = new JTextField();
		numeroCarte.setEditable(false);
		numeroCarte.setBounds(313, 54, 228, 30);
		panel.add(numeroCarte);
		numeroCarte.setColumns(30);
		final Numero numero = new Numero();
		String num = numero.generateNumeroCarte();
		numeroCarte.setText(num);
		final JRadioButton visaElectron = new JRadioButton("Electron");
		visaElectron.setEnabled(false);
		visaElectron.setBounds(314, 116, 109, 30);

		final JRadioButton visaPremier = new JRadioButton("Premier");
		visaPremier.setEnabled(false);
		visaPremier.setBounds(432, 116, 109, 30);

		ButtonGroup groupeCarte = new ButtonGroup();
		groupeCarte.add(visaPremier);
		groupeCarte.add(visaElectron);
		panel.add(visaPremier);
		panel.add(visaElectron);

		final JComboBox listeClient = new JComboBox();
		listeClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceCarteImp serviceCarteImp = new ServiceCarteImp();
				ServiceClientImp serviceClientImp = new ServiceClientImp();
				String numeroClient = (String) listeClient.getSelectedItem();
				Client client = serviceClientImp.rechercherParNumeroClient(numeroClient);
				if (client != null && serviceCarteImp.nbreCarte(client.getId()).size() != 0) {
					Carte carte = serviceCarteImp.nbreCarte(client.getId()).get(0);
					if (carte.getTypeCarte().equals("Premier")) {
						visaElectron.setEnabled(true);
						visaElectron.setSelected(true);
					} else {
						visaPremier.setEnabled(true);
						visaPremier.setSelected(true);
					}
				}
				if (client != null && serviceCarteImp.nbreCarte(client.getId()).size() == 0) {
					visaElectron.setEnabled(true);
					visaPremier.setEnabled(true);
				}
			}
		});
		listeClient.setBounds(313, 220, 228, 30);
		final ServiceClientImp serviceClientImp = new ServiceClientImp();
		listeClient.addItem("");
		for (Iterator iterator = serviceClientImp.lister().iterator(); iterator.hasNext();) {

			ServiceCarteImp serviceCarteImp = new ServiceCarteImp();
			Client client = (Client) iterator.next();
			int nbCarte = serviceCarteImp.nbreCarte(client.getId()).size();
			if (nbCarte < 2) {
				listeClient.addItem(client.getNumeroClient());
			}

		}
		panel.add(listeClient);

		codesecret = new JTextField();
		codesecret.setBounds(313, 173, 228, 26);
		panel.add(codesecret);
		codesecret.setColumns(10);

		JButton buttonValider = new JButton("Valider");
		buttonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeroClient = (String) listeClient.getSelectedItem();
				if (numeroClient.equals("")) {
					JOptionPane.showMessageDialog(null, "Choisir un client");
				}else {
					String code = codesecret.getText();
					Date dateExp = heure.datereExpiration();
					String typeCarte;
					String numcarte = numeroCarte.getText();
					if (visaElectron.isSelected()) {
						typeCarte = new String("Electron");
					} else {
						typeCarte = new String("Premier");
					}
					
					int idClient = serviceClientImp.rechercherParNumeroClient(numeroClient).getId();
					if (code.length() == 0 || dateExp == null || numeroClient.length() == 0) {
						JOptionPane.showMessageDialog(null, "remplire tout les champ");
					} else {
						Carte carteCreer = new Carte(numcarte, typeCarte, code, dateExp, idClient);
						ServiceCarteImp serviceCarteImp = new ServiceCarteImp();
						serviceCarteImp.ajouter(carteCreer);
						JOptionPane.showMessageDialog(null, "Carte Creer");
						String newNumer0 = numero.generateNumeroCarte();
						numeroCarte.setText(newNumer0);
						codesecret.setText("");

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
		
		
		dateExpriation = new JTextField();
		dateExpriation.setEditable(false);
		dateExpriation.setBounds(313, 274, 228, 40);
		panel.add(dateExpriation);
		dateExpriation.setColumns(10);
		dateExpriation.setText(heure.datereExpiration()+"");

	}
}
