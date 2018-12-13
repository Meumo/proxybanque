package sn.proxybanque.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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

public class AjoutConseilles extends JPanel {
	private JTextField numeroConseiller;
	private JTextField nomConseiller;
	private JTextField prenomConseiller;
	private JTextField adresseConseiller;
	private JTextField typeConseiller;
	private JTextField loginConseiller;
	private JTextField telConseiller;
	private JTextField emailConseiller;
	private JPasswordField passwordConseiller;
	//private ButtonGroup buttonGroup;

	/**
	 * Create the panel.
	 */
	public AjoutConseilles() {
		setLayout(null);
		Employer employer;
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajout Conseiller", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
		panel.setBounds(-28, 11, 773, 453);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero Conseiller");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBounds(55, 18, 188, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNomClient = new JLabel("Nom  ");
		lblNomClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNomClient.setBounds(55, 54, 188, 30);
		panel.add(lblNomClient);
		
		JLabel lblPrenomClient = new JLabel("Prenom  ");
		lblPrenomClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblPrenomClient.setBounds(55, 84, 188, 30);
		panel.add(lblPrenomClient);
		
		JLabel lblAdresseClient = new JLabel("Adresse  ");
		lblAdresseClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblAdresseClient.setBounds(55, 120, 188, 30);
		panel.add(lblAdresseClient);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblSexe.setBounds(574, 156, 36, 30);
		panel.add(lblSexe);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblEmail.setBounds(55, 156, 188, 30);
		panel.add(lblEmail);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblTelephone.setBounds(55, 197, 188, 30);
		panel.add(lblTelephone);
		
		JLabel lblCodePostal = new JLabel("Login");
		lblCodePostal.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblCodePostal.setBounds(55, 238, 188, 30);
		panel.add(lblCodePostal);
		
		JLabel lblProfession = new JLabel("type ");
		lblProfession.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblProfession.setBounds(55, 319, 188, 30);
		panel.add(lblProfession);
		
		JLabel lblVille = new JLabel("Password");
		lblVille.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVille.setBounds(55, 279, 188, 30);
		panel.add(lblVille);
		
		JLabel lblDateDeNaissance = new JLabel("Date de Naissance");
		lblDateDeNaissance.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblDateDeNaissance.setBounds(55, 360, 188, 30);
		panel.add(lblDateDeNaissance);
		
		numeroConseiller = new JTextField();
		numeroConseiller.setEditable(false);
		numeroConseiller.setBounds(313, 18, 228, 30);
		panel.add(numeroConseiller);
		numeroConseiller.setColumns(30);
		Numero numero=new Numero();
		String num=numero.generateNumeroEmploye();
		numeroConseiller.setText(num);
		
		nomConseiller = new JTextField();
		nomConseiller.setBounds(313, 54, 228, 26);
		panel.add(nomConseiller);
		nomConseiller.setColumns(30);
		
		prenomConseiller = new JTextField();
		prenomConseiller.setBounds(313, 85, 228, 30);
		panel.add(prenomConseiller);
		prenomConseiller.setColumns(30);
		
		adresseConseiller = new JTextField();
		adresseConseiller.setBounds(313, 121, 228, 30);
		panel.add(adresseConseiller);
		adresseConseiller.setColumns(30);
		
		
		//buttonGroup.add(buttonSexeConseillerFemme);
		//buttonGroup.add(buttonSexeconseillerHomme);
		
		final JDateChooser dateNaissanceConseiller = new JDateChooser();
		dateNaissanceConseiller.setDateFormatString("yyyy-M-d ");
		dateNaissanceConseiller.setBounds(313, 360, 228, 30);
		panel.add(dateNaissanceConseiller);
		
		typeConseiller = new JTextField();
		typeConseiller.setEditable(false);
		typeConseiller.setText("Conseiller");
		typeConseiller.setBounds(313, 320, 228, 30);
		panel.add(typeConseiller);
		typeConseiller.setColumns(30);
		
		loginConseiller = new JTextField();
		loginConseiller.setBounds(313, 239, 228, 30);
		panel.add(loginConseiller);
		loginConseiller.setColumns(30);
		
		telConseiller = new JTextField();
		telConseiller.setBounds(313, 198, 228, 30);
		panel.add(telConseiller);
		telConseiller.setColumns(30);
		
		emailConseiller = new JTextField();
		emailConseiller.setBounds(313, 157, 228, 30);
		panel.add(emailConseiller);
		emailConseiller.setColumns(30);
		
		JList list = new JList();
		list.setBounds(388, 26, 1, 1);
		panel.add(list);
		
		final JComboBox comboBoxSexe = new JComboBox();
		comboBoxSexe.setModel(new DefaultComboBoxModel(new String[] {"Femme", "Homme"}));
		//comboBoxSexe.setModel(new DefaultComboBoxModel(new String[] {"Homme"}));
		comboBoxSexe.addItem("Femme");
		comboBoxSexe.addItem("Homme");
		comboBoxSexe.setMaximumRowCount(2);
		comboBoxSexe.setBounds(627, 156, 94, 30);
		panel.add(comboBoxSexe);

		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idAgence=1;
				String nom=nomConseiller.getText();
				String prenom=prenomConseiller.getText();
				String adresse=adresseConseiller.getText();
				String email=emailConseiller.getText();
				String login =loginConseiller.getText();
				String passWord=passwordConseiller.getText();
				String telephone=telConseiller.getText();
				String type=typeConseiller.getText();
				Date date=dateNaissanceConseiller.getDate();
				String numero=numeroConseiller.getText();
				String sexeChoise=(String) comboBoxSexe.getSelectedItem();
				ServiceEmployerImp serviceEmployerImp=new ServiceEmployerImp();
				if(nom.length()==0 || prenom.length()==0 ||adresse.length()==0 || email.length()==0 ||login.length()==0 || passWord.length()==0 ||telephone.length()==0 ||type.length()==0 ||sexeChoise.length()==0 ||numero.length()==0 ||date==null )
				{
					JOptionPane.showMessageDialog(null,"veuillez remplire tout les champs");
				}else {
					Employer employerCree=new Employer(nom, prenom, adresse, telephone, date, email, sexeChoise, numero,type, login, passWord, idAgence);
					serviceEmployerImp.ajouter(employerCree);
					JOptionPane.showMessageDialog(null,"insertion reussit");
					nomConseiller.setText("");
					prenomConseiller.setText("");
					adresseConseiller.setText("");
					emailConseiller.setText("");
					loginConseiller.setText("");
					passwordConseiller.setText("");
					telConseiller.setText("");
				
					Numero nouveauNumero=new Numero();
					String num=nouveauNumero.generateNumeroEmploye();
					numeroConseiller.setText(num);
				}
					
			    
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\image\\check.png"));
		btnNewButton.setBackground(new Color(51, 204, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(279, 401, 124, 30);
		panel.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomConseiller.setText("");
				prenomConseiller.setText("");
				adresseConseiller.setText("");
				emailConseiller.setText("");
				loginConseiller.setText("");
				passwordConseiller.setText("");
				telConseiller.setText("");
				//dateNaissanceConseiller=new JDateChooser();
			}
			
		});
		btnAnnuler.setIcon(new ImageIcon("C:\\Users\\image\\busy.png"));
		btnAnnuler.setBackground(new Color(255, 102, 0));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnnuler.setBounds(413, 401, 128, 30);
		panel.add(btnAnnuler);
		
		passwordConseiller = new JPasswordField();
		passwordConseiller.setBounds(313, 279, 228, 30);
		panel.add(passwordConseiller);
		
		
	}
}
