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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceEmployerImp;
import java.awt.BorderLayout;

public class ModifierConseilles extends JPanel {
	private JTextField numeroConseiller;
	private JTextField nomConseiller;
	private JTextField prenomConseiller;
	private JTextField adresseConseiller;
	private JTextField typeConseiller;
	private JTextField loginConseiller;
	private JTextField telConseiller;
	private JTextField emailConseiller;
	private JPasswordField passwordConseiller;
	Employer employerMiseAjour;
	final JPanel panelHaut;
	JDateChooser dateDeNaissance;
	/**
	 * Create the panel.
	 */
	public ModifierConseilles() {
		Employer employer;
		setLayout(new BorderLayout(0, 0));
		final JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(176, 196, 222));
		panelCentre.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Conseiller Trouve", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
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
		lblSexe.setBounds(574, 156, 36, 30);
		panelCentre.add(lblSexe);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblEmail.setBounds(55, 144, 188, 30);
		panelCentre.add(lblEmail);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblTelephone.setBounds(55, 185, 188, 30);
		panelCentre.add(lblTelephone);
		
		JLabel lblCodePostal = new JLabel("Login");
		lblCodePostal.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblCodePostal.setBounds(55, 226, 188, 30);
		panelCentre.add(lblCodePostal);
		
		JLabel lblProfession = new JLabel("type ");
		lblProfession.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblProfession.setBounds(55, 295, 188, 30);
		panelCentre.add(lblProfession);
		
		JLabel lblVille = new JLabel("Password");
		lblVille.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVille.setBounds(55, 267, 188, 30);
		panelCentre.add(lblVille);
		
		JLabel lblDateDeNaissance = new JLabel("Date de Naissance");
		lblDateDeNaissance.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblDateDeNaissance.setBounds(55, 336, 188, 30);
		panelCentre.add(lblDateDeNaissance);
		Numero numero=new Numero();
		String num=numero.generateNumeroEmploye();
		
		nomConseiller = new JTextField();
		nomConseiller.setBounds(313, 21, 228, 26);
		panelCentre.add(nomConseiller);
		nomConseiller.setColumns(30);
		
		prenomConseiller = new JTextField();
		prenomConseiller.setBounds(313, 55, 228, 30);
		panelCentre.add(prenomConseiller);
		prenomConseiller.setColumns(30);
		
		adresseConseiller = new JTextField();
		adresseConseiller.setBounds(313, 96, 228, 30);
		panelCentre.add(adresseConseiller);
		adresseConseiller.setColumns(30);
		
		
		//buttonGroup.add(buttonSexeConseillerFemme);
		//buttonGroup.add(buttonSexeconseillerHomme);
		
		final JDateChooser dateNaissanceConseiller ;
		
		
		typeConseiller = new JTextField();
		typeConseiller.setEditable(false);
		typeConseiller.setText("Conseiller");
		typeConseiller.setBounds(313, 296, 228, 30);
		panelCentre.add(typeConseiller);
		typeConseiller.setColumns(30);
		
		loginConseiller = new JTextField();
		loginConseiller.setBounds(313, 219, 228, 30);
		panelCentre.add(loginConseiller);
		loginConseiller.setColumns(30);
		
		telConseiller = new JTextField();
		telConseiller.setBounds(313, 178, 228, 30);
		panelCentre.add(telConseiller);
		telConseiller.setColumns(30);
		
		emailConseiller = new JTextField();
		emailConseiller.setBounds(313, 137, 228, 30);
		panelCentre.add(emailConseiller);
		emailConseiller.setColumns(30);
		
		JList list = new JList();
		list.setBounds(388, 26, 1, 1);
		panelCentre.add(list);
		
		final JComboBox comboBoxSexe = new JComboBox();
		comboBoxSexe.setModel(new DefaultComboBoxModel(new String[] {"Femme", "Homme"}));
		//comboBoxSexe.setModel(new DefaultComboBoxModel(new String[] {"Homme"}));
		comboBoxSexe.addItem("Femme");
		comboBoxSexe.addItem("Homme");
		comboBoxSexe.setMaximumRowCount(2);
		comboBoxSexe.setBounds(627, 156, 94, 30);
		panelCentre.add(comboBoxSexe);

		
		JButton buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "voulez vous confirmer les mise a jours", "Confirmation",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					ServiceEmployerImp serviceEmployerImp=new ServiceEmployerImp();
					 
					int idAgence=1;
					String nom=nomConseiller.getText();
					String prenom=prenomConseiller.getText();
					String adresse=adresseConseiller.getText();
					String email=emailConseiller.getText();
					String login =loginConseiller.getText();
					String passWord=passwordConseiller.getText();
					String telephone=telConseiller.getText();
					String type=typeConseiller.getText();
    				Date date=dateDeNaissance.getDate();
					String numero=numeroConseiller.getText();
					String sexeChoise=(String) comboBoxSexe.getSelectedItem();
					
					if(nom.length()==0 || prenom.length()==0 ||adresse.length()==0 || email.length()==0 ||login.length()==0 || passWord.length()==0 ||telephone.length()==0 ||type.length()==0 ||sexeChoise.length()==0 ||numero.length()==0 ||date==null )
					{
						JOptionPane.showMessageDialog(null,"veuillez remplire tout les champs");
					}else {
						Employer employerMiseAjour=new Employer(nom, prenom, adresse, telephone, date, email, sexeChoise, numero,type, login, passWord, idAgence);
						serviceEmployerImp.misAJour(employerMiseAjour);
						nomConseiller.setText("");
						prenomConseiller.setText("");
						adresseConseiller.setText("");
						emailConseiller.setText("");
						loginConseiller.setText("");
						passwordConseiller.setText("");
						telConseiller.setText("");
						JOptionPane.showMessageDialog(null,type+"mise a jours");
						panelCentre.setBounds(0, 53, 745, 412);
						remove(panelCentre);
						add(panelHaut);
						validate();
					}
				}
			    
			}
		});
		buttonUpdate.setIcon(new ImageIcon("C:\\Users\\image\\check.png"));
		buttonUpdate.setBackground(new Color(51, 204, 51));
		buttonUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonUpdate.setBounds(272, 378, 124, 30);
		panelCentre.add(buttonUpdate);
		
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
		
		passwordConseiller = new JPasswordField();		passwordConseiller.setBounds(313, 260, 228, 30);
		panelCentre.add(passwordConseiller);
		 dateDeNaissance = new JDateChooser();
		
		 dateDeNaissance.setDateFormatString("yyyy-M-d");
		dateDeNaissance.setBounds(313, 336, 228, 30);
		panelCentre.add(dateDeNaissance);
		
		  panelHaut = new JPanel();
		panelHaut.setBackground(new Color(176, 196, 222));
		add(panelHaut);
		panelHaut.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero Du Conseiller a Modifer");
		lblNewLabel.setBounds(10, 13, 235, 30);
		panelHaut.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		
		numeroConseiller = new JTextField();
		numeroConseiller.setBounds(275, 13, 228, 30);
		panelHaut.add(numeroConseiller);
		numeroConseiller.setColumns(30);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceEmployerImp serviceEmployerImp=new ServiceEmployerImp();
				String numeroEntre=numeroConseiller.getText();
				if(numeroEntre.length()==0)
				{
					JOptionPane.showMessageDialog(null,"entre le numero a modifier");
				}else {
					employerMiseAjour=serviceEmployerImp.rechercherParNumeroEmployer(numeroEntre);
					if(employerMiseAjour==null) {
						JOptionPane.showMessageDialog(null,"l'employer n'existe pas dans la basse de donnee");
					}else {
						nomConseiller.setText(employerMiseAjour.getNom());
						prenomConseiller.setText(employerMiseAjour.getPrenom());
						adresseConseiller.setText(employerMiseAjour.getAdresse());
						emailConseiller.setText(employerMiseAjour.getEmail());
						loginConseiller.setText(employerMiseAjour.getLoginEmploye());
						passwordConseiller.setText(employerMiseAjour.getPasswordEmploye());
						telConseiller.setText(employerMiseAjour.getTelephone());
				    
						panelCentre.setBounds(0, 53, 745, 412);
						remove(panelHaut);
						add(panelCentre);
						validate();
					}
				}
				
			}
		});
		btnRechercher.setBackground(Color.GREEN);
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRechercher.setIcon(new ImageIcon("C:\\Users\\image\\search.png"));
		btnRechercher.setBounds(513, 13, 147, 28);
		panelHaut.add(btnRechercher);
		
		
	}
}
