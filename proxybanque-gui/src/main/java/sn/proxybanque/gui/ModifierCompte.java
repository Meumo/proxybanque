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
import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceCarteImp;
import sn.proxybanque.service.ServiceClientImp;
import sn.proxybanque.service.ServiceCompteImp;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ModifierCompte extends JPanel {
	private JTextField numeroCompte;
	private JTextField solde;
	private JTextField client;
	Compte compteAModifier;
	final JPanel panelHaut;
	String numeroEntre;
	private JTextField dateExpiration;
	/**
	 * Create the panel.
	 */
	public ModifierCompte() {
		Employer employer;
		setLayout(new BorderLayout(0, 0));
		final JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(176, 196, 222));
		panelCentre.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Compte Trouve", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
		add(panelCentre);
		panelCentre.setLayout(null);
		remove(panelCentre);

		JLabel lblNomt = new JLabel("Solde Compte");
		lblNomt.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNomt.setBounds(55, 21, 188, 30);
		panelCentre.add(lblNomt);

		JLabel lblPrenomClient = new JLabel("Date D'ouverture");
		lblPrenomClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblPrenomClient.setBounds(55, 86, 188, 30);
		panelCentre.add(lblPrenomClient);

		JLabel Visa = new JLabel("Type De Compte");
		Visa.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		Visa.setBounds(55, 146, 188, 30);
		panelCentre.add(Visa);

		JLabel Client = new JLabel("Client");
		Client.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		Client.setBounds(55, 219, 188, 30);
		panelCentre.add(Client);
		Numero numero = new Numero();
		String num = numero.generateNumeroEmploye();

		solde = new JTextField();
		solde.addKeyListener(new KeyAdapter() {
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
		solde.setBounds(313, 24, 228, 27);
		panelCentre.add(solde);
		solde.setColumns(30);

		final JRadioButton Epargne = new JRadioButton("Epargne");
		Epargne.setEnabled(false);
		Epargne.setBounds(313, 146, 109, 30);
		
		
		final JRadioButton Courant = new JRadioButton("Courant");
		Courant.setEnabled(false);
		Courant.setBounds(432, 147, 109, 30);
		
		ButtonGroup groupeCarte=new ButtonGroup();
		groupeCarte.add(Courant);
		groupeCarte.add(Epargne);
		panelCentre.add(Courant);
		panelCentre.add(Epargne);

		final JDateChooser dateNaissanceConseiller;

		client = new JTextField();
		client.setEditable(false);
		client.setBounds(313, 220, 228, 30);
		panelCentre.add(client);
		client.setColumns(30);


		JButton buttonModifer = new JButton("Modifer");
		buttonModifer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type;
				if(compteAModifier.getTypeDeCompte().equals("Epargne"))
				 {
					type=new String("Epargne");
				 }else
				 {
					 type=new String("Courant");
				 }
				String code=solde.getText();
				int idClient=Integer.parseInt(client.getText());
				
				double soldeEntre=0;
				if(solde.getText().length()>0)
				{
					 soldeEntre =Double.parseDouble(solde.getText());
				}
				if(code.length()==0 || soldeEntre<0)
			    {
			    	JOptionPane.showMessageDialog(null,"remplire tout les champ");
			    }else {
			    	if (JOptionPane.showConfirmDialog(null, "voulez vous confirmer les modifcation du Carte",
							"Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						String typec = "Compte";
						ServiceCompteImp serviceCompteImp=new ServiceCompteImp();
						compteAModifier=new Compte();
						compteAModifier.setNumeroCompte(numeroCompte.getText());
						compteAModifier.setSoldeCompte(soldeEntre);
						compteAModifier.setTypeDeCompte(type);
						compteAModifier.setIdClient(idClient);
						serviceCompteImp.misAJour(compteAModifier);
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
		
		dateExpiration = new JTextField();
		dateExpiration.setEditable(false);
		dateExpiration.setBounds(313, 86, 228, 30);
		panelCentre.add(dateExpiration);
		dateExpiration.setColumns(10);
		
		
		panelHaut = new JPanel();
		panelHaut.setBackground(new Color(176, 196, 222));
		add(panelHaut);
		panelHaut.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero Du Carte a Modifier");
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
				numeroEntre = numeroCompte.getText();
				if (numeroEntre.length() == 0) {
					JOptionPane.showMessageDialog(null, "entre le numero du compte a supprimer");
				} else {
					compteAModifier=serviceCompteImp.rechercherParNumeroCompte(numeroEntre);
					if (compteAModifier == null) {
						JOptionPane.showMessageDialog(null, "le compte n'existe pas dans la basse de donnee");
					} else {
                        
						solde.setText(compteAModifier.getSoldeCompte()+"");
						dateExpiration.setText(compteAModifier.getDateOuvertureCompte()+"");
						 if(compteAModifier.getTypeDeCompte().equals("Epargne"))
						 {
							Epargne.setSelected(true); 
						 }else
						 {
							 Courant.setSelected(true);
						 }
						 ServiceClientImp serviceClientImp=new ServiceClientImp();
						 Client clientt=serviceClientImp.findByIdClient(compteAModifier.getIdClient());
						client.setText(clientt.getNom()+" "+ clientt.getPrenom());
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
