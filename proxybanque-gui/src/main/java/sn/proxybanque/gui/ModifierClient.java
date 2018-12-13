package sn.proxybanque.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import sn.proxybanque.domaine.Client;
import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceClientImp;
import sn.proxybanque.service.ServiceEmployerImp;
import java.awt.BorderLayout;

public class ModifierClient extends JPanel {
	private JTextField numeroClient;
	private JTextField nomClient;
	private JTextField prenomClient;
	private JTextField adresseClient;
	private JTextField codepostalClient;
	private JTextField professionClient;
	private JTextField telClient;
	private JTextField emailClient;
	private JTextField villeClient;
	Client clientAModifer;
	final JPanel panelHaut;
	String sexe;

	/**
	 * Create the panel.
	 */
	public ModifierClient(final int idConseiller) {
		ButtonGroup groupeSexe=new ButtonGroup();
		final JRadioButton homme=new JRadioButton("homme");
		homme.setSelected(true);
		homme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		final  JRadioButton femme=new JRadioButton("femme");
		femme.setSelected(true);
		femme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		femme.setBounds(547, 180, 96, 23);
		homme.setBounds(656, 180, 83, 23);
		groupeSexe.add(homme);
		groupeSexe.add(femme);
		
		Employer employer;
		setLayout(new BorderLayout(0, 0));
		final JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(176, 196, 222));
		panelCentre.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Conseiller Trouve",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
		add(panelCentre);
		panelCentre.setLayout(null);
		remove(panelCentre);

		JLabel lblNomClient = new JLabel("Nom  ");
		lblNomClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNomClient.setBounds(55, 21, 188, 30);
		panelCentre.add(lblNomClient);

		JLabel lblPrenomClient = new JLabel("Prenom  ");
		lblPrenomClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblPrenomClient.setBounds(55, 62, 188, 30);
		panelCentre.add(lblPrenomClient);

		JLabel lblAdresseClient = new JLabel("Adresse  ");
		lblAdresseClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblAdresseClient.setBounds(55, 103, 188, 30);
		panelCentre.add(lblAdresseClient);

		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblSexe.setBounds(620, 144, 36, 30);
		panelCentre.add(lblSexe);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblEmail.setBounds(55, 144, 188, 30);
		panelCentre.add(lblEmail);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblTelephone.setBounds(55, 185, 188, 30);
		panelCentre.add(lblTelephone);

		JLabel lblCodePostal = new JLabel("Profession");
		lblCodePostal.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblCodePostal.setBounds(55, 226, 188, 30);
		panelCentre.add(lblCodePostal);

		JLabel lblProfession = new JLabel("Code Postal");
		lblProfession.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblProfession.setBounds(55, 295, 188, 30);
		panelCentre.add(lblProfession);
		
		JLabel ville = new JLabel("Ville");
		ville.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		ville.setBounds(55, 267, 188, 30);
		panelCentre.add(ville);

		JLabel lblDateDeNaissance = new JLabel("Date de Naissance");
		lblDateDeNaissance.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblDateDeNaissance.setBounds(55, 336, 188, 30);
		panelCentre.add(lblDateDeNaissance);
		Numero numero = new Numero();
		String num = numero.generateNumeroEmploye();

		nomClient = new JTextField();
		nomClient.setBounds(313, 21, 228, 26);
		panelCentre.add(nomClient);
		nomClient.setColumns(30);

		prenomClient = new JTextField();
		prenomClient.setBounds(313, 55, 228, 30);
		panelCentre.add(prenomClient);
		prenomClient.setColumns(30);

		adresseClient = new JTextField();
		adresseClient.setBounds(313, 96, 228, 30);
		panelCentre.add(adresseClient);
		adresseClient.setColumns(30);

		// buttonGroup.add(buttonSexeConseillerFemme);
		// buttonGroup.add(buttonSexeconseillerHomme);

		final JDateChooser dateNaissanceConseiller;

		codepostalClient = new JTextField();
		codepostalClient.setBounds(313, 296, 228, 30);
		panelCentre.add(codepostalClient);
		codepostalClient.setColumns(30);

		professionClient = new JTextField();
		professionClient.setBounds(313, 219, 228, 30);
		panelCentre.add(professionClient);
		professionClient.setColumns(30);

		telClient = new JTextField();
		telClient.setBounds(313, 178, 228, 30);
		panelCentre.add(telClient);
		telClient.setColumns(30);

		emailClient = new JTextField();
		emailClient.setBounds(313, 137, 228, 30);
		panelCentre.add(emailClient);
		emailClient.setColumns(30);

		JList list = new JList();
		list.setBounds(388, 26, 1, 1);
		panelCentre.add(list);

		final JDateChooser dateDeNaissanceClient = new JDateChooser();
		dateDeNaissanceClient.setBounds(313, 336, 228, 26);
		panelCentre.add(dateDeNaissanceClient);

		JButton buttonModifier = new JButton("Modifier");
		buttonModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero=numeroClient.getText();
				String nom=nomClient.getText();
				String prenom=prenomClient.getText();
				String adresse=adresseClient.getText();
				String email=emailClient.getText();
				String ville=villeClient.getText();
				String codepost=codepostalClient.getText();
				String professeion=professionClient.getText();
				String telephone=telClient.getText();
			    Date date=dateDeNaissanceClient.getDate();
			    if(homme.isSelected())
				{
					sexe=new String("Homme");
					
				}else
				{
					sexe=new String("Femme");
				}
			    
			    if( nom.length()==0 || prenom.length()==0 ||adresse.length()==0 || email.length()==0 ||ville.length()==0 ||codepost.length()==0 ||professeion.length()==0 ||date==null)
				{
					JOptionPane.showMessageDialog(null,"veuillez remplire tout les champs");
				}else {
					clientAModifer=new Client(nom, prenom, adresse, telephone, date, email, sexe, numero, codepost, ville, professeion, idConseiller);
					ServiceClientImp serviceClientImp=new ServiceClientImp();
					if (JOptionPane.showConfirmDialog(null, "voulez vous confirmer les modification du Client",
							"Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						String type = "Client";
						serviceClientImp.misAJour(clientAModifer);
						JOptionPane.showMessageDialog(null, type + " modifier");
						panelCentre.setBounds(0, 53, 745, 412);
						remove(panelCentre);
						add(panelHaut);
						validate();
					}
					
					
				}
			        panelCentre.setBounds(0, 53, 745, 412);
					remove(panelCentre);
					add(panelHaut);
					validate();
				

			}
		});
		buttonModifier.setIcon(new ImageIcon("C:\\Users\\image\\check.png"));
		buttonModifier.setBackground(new Color(51, 204, 51));
		buttonModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonModifier.setBounds(272, 378, 124, 30);
		panelCentre.add(buttonModifier);

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
		buttonAnnuler.setBounds(406, 378, 128, 30);
		panelCentre.add(buttonAnnuler);

		villeClient = new JTextField();
		villeClient.setBounds(313, 260, 228, 30);
		panelCentre.add(villeClient);

		panelCentre.add(femme);
		panelCentre.add(homme);
		
		

		panelHaut = new JPanel();
		panelHaut.setBackground(new Color(176, 196, 222));
		add(panelHaut);
		panelHaut.setLayout(null);

		
		
		JLabel lblNewLabel = new JLabel("Numero Du Client a Supprimer");
		lblNewLabel.setBounds(10, 6, 235, 30);
		panelHaut.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));

		numeroClient = new JTextField();
		numeroClient.setBounds(275, 6, 228, 30);
		panelHaut.add(numeroClient);
		numeroClient.setColumns(30);

		JButton buttonRechercher = new JButton("Rechercher");
		buttonRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ServiceClientImp serviceClientImp = new ServiceClientImp();
				String numeroEntre = numeroClient.getText();
				if (numeroEntre.length() == 0) {
					JOptionPane.showMessageDialog(null, "entre le numero du client a supprimer");
				} else {
					clientAModifer = serviceClientImp.rechercherParNumeroClient(numeroEntre);
					System.out.println(clientAModifer);
					if (clientAModifer == null) {
						JOptionPane.showMessageDialog(null, "le Client n'existe pas dans la basse de donnee");
					} else {
                   
						nomClient.setText(clientAModifer.getNom());
						prenomClient.setText(clientAModifer.getPrenom());
						adresseClient.setText(clientAModifer.getAdresse());
						emailClient.setText(clientAModifer.getEmail());
						telClient.setText(clientAModifer.getTelephone());
						codepostalClient.setText(clientAModifer.getEmail());
						villeClient.setText(clientAModifer.getVileClient());
						professionClient.setText(clientAModifer.getProfessionClient());
						if(clientAModifer.getSexe().equals("Femme"))
						{
							homme.setSelected(true);
							
						}else
						{
							femme.setSelected(true);
						}
						panelCentre.setBounds(0, 53, 745, 412);
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
