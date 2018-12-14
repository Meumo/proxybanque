package sn.proxybanque.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceCarteImp;
import sn.proxybanque.service.ServiceClientImp;

public class ModifierCarte extends JPanel {
	private JTextField numeroCarte;
	private JTextField codeSecret;
	private JTextField client;
	Carte cartAModifer;
	final JPanel panelHaut;
	String numeroEntre;
	/**
	 * Create the panel.
	 */
	public ModifierCarte() {
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
		codeSecret.setBounds(313, 24, 228, 27);
		panelCentre.add(codeSecret);
		codeSecret.setColumns(30);

		final JRadioButton visaElectron = new JRadioButton("Electron");
		visaElectron.setBounds(313, 146, 109, 30);
		
		
		final JRadioButton visaPremier = new JRadioButton("Premier");
		visaPremier.setBounds(432, 147, 109, 30);
		
		ButtonGroup groupeCarte=new ButtonGroup();
		groupeCarte.add(visaPremier);
		groupeCarte.add(visaElectron);
		panelCentre.add(visaPremier);
		panelCentre.add(visaElectron);

		final JDateChooser dateNaissanceConseiller;

		client = new JTextField();
		client.setBounds(313, 220, 228, 30);
		panelCentre.add(client);
		client.setColumns(30);

		final JDateChooser dateExpiration = new JDateChooser();
		dateExpiration.setBounds(313, 86, 228, 30);
		panelCentre.add(dateExpiration);


		JButton buttonModifer = new JButton("Modifer");
		buttonModifer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type;
				if(cartAModifer.getTypeCarte().equals("Electron"))
				 {
					type=new String("Electron");
				 }else
				 {
					 type=new String("Premier");
				 }
				String code=codeSecret.getText();
				int idClient=Integer.parseInt(client.getText());
				Date dateExp=dateExpiration.getDate();
				if(code.length()==0 || dateExp==null ||dateExp==null)
			    {
			    	JOptionPane.showMessageDialog(null,"remplire tout les champ");
			    }else {
			    	if (JOptionPane.showConfirmDialog(null, "voulez vous confirmer les modifcation du Carte",
							"Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						String typec = "Carte";
						ServiceCarteImp serviceCarteImp=new ServiceCarteImp();
						cartAModifer=new Carte(numeroEntre, type, code, dateExp, idClient);
						serviceCarteImp.misAJour(cartAModifer);
						JOptionPane.showMessageDialog(null, typec + "modifer");
						panelCentre.setBounds(0, 53, 745, 412);
						remove(panelCentre);
						add(panelHaut);
						validate();
					}

				}
				
			}
		});
		buttonModifer.setIcon(new ImageIcon("C:\\Users\\image\\check.png"));
		buttonModifer.setBackground(new Color(51, 204, 51));
		buttonModifer.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonModifer.setBounds(284, 282, 124, 30);
		panelCentre.add(buttonModifer);

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

		JLabel lblNewLabel = new JLabel("Numero Du Carte a Modifier");
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
				numeroEntre = numeroCarte.getText();
				if (numeroEntre.length() == 0) {
					JOptionPane.showMessageDialog(null, "entre le numero du carte a supprimer");
				} else {
					cartAModifer=serviceCarteImp.rechercherParNumeroCarte(numeroEntre);
					if (cartAModifer == null) {
						JOptionPane.showMessageDialog(null, "la carte n'existe pas dans la basse de donnee");
					} else {
                        
						codeSecret.setText(cartAModifer.getCodeSecretCarte());
						//dateExpiration=new JDateChooser(carteASupprimer.getDateExpirationCarte());
						 if(cartAModifer.getTypeCarte().equals("Electron"))
						 {
							visaElectron.setSelected(true); 
						 }else
						 {
							 visaPremier.setSelected(true);
						 }
						client.setText(cartAModifer.getIdClient()+"");
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
