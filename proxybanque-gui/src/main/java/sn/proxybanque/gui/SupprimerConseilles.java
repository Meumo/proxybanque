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

public class SupprimerConseilles extends JPanel {
	private JTextField numeroConseiller;
	private JTextField nomConseiller;
	private JTextField prenomConseiller;
	private JTextField adresseConseiller;
	private JTextField typeConseiller;
	private JTextField loginConseiller;
	private JTextField telConseiller;
	private JTextField emailConseiller;
	private JPasswordField passwordConseiller;
	private JTextField dateDeNaissance;
	Employer employerASupprime;
	final JPanel panelHaut;
	/**
	 * Create the panel.
	 */
	public SupprimerConseilles() {
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
		nomConseiller.setEditable(false);
		nomConseiller.setBounds(313, 21, 228, 26);
		panelCentre.add(nomConseiller);
		nomConseiller.setColumns(30);
		
		prenomConseiller = new JTextField();
		prenomConseiller.setEditable(false);
		prenomConseiller.setBounds(313, 55, 228, 30);
		panelCentre.add(prenomConseiller);
		prenomConseiller.setColumns(30);
		
		adresseConseiller = new JTextField();
		adresseConseiller.setEditable(false);
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
		loginConseiller.setEditable(false);
		loginConseiller.setBounds(313, 219, 228, 30);
		panelCentre.add(loginConseiller);
		loginConseiller.setColumns(30);
		
		telConseiller = new JTextField();
		telConseiller.setEditable(false);
		telConseiller.setBounds(313, 178, 228, 30);
		panelCentre.add(telConseiller);
		telConseiller.setColumns(30);
		
		emailConseiller = new JTextField();
		emailConseiller.setEditable(false);
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

		
		JButton buttonSupprimer = new JButton("Supprimer");
		buttonSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "voulez vous confirmer la suppression", "Confirmation",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					ServiceEmployerImp serviceEmployerImp=new ServiceEmployerImp();
					String type=employerASupprime.getTypeEmploye();
					serviceEmployerImp.supprimer(employerASupprime);
					JOptionPane.showMessageDialog(null,type+" supprimer");
				}
			    
			}
		});
		buttonSupprimer.setIcon(new ImageIcon("C:\\Users\\image\\check.png"));
		buttonSupprimer.setBackground(new Color(51, 204, 51));
		buttonSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonSupprimer.setBounds(272, 378, 124, 30);
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
		buttonAnnuler.setBounds(406, 378, 128, 30);
		panelCentre.add(buttonAnnuler);
		
		passwordConseiller = new JPasswordField();
		passwordConseiller.setEditable(false);
		passwordConseiller.setBounds(313, 260, 228, 30);
		panelCentre.add(passwordConseiller);
		
		dateDeNaissance = new JTextField();
		dateDeNaissance.setEditable(false);
		dateDeNaissance.setBounds(313, 336, 228, 26);
		panelCentre.add(dateDeNaissance);
		dateDeNaissance.setColumns(10);
		
		  panelHaut = new JPanel();
		panelHaut.setBackground(new Color(176, 196, 222));
		add(panelHaut);
		panelHaut.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero Du Conseiller a Supprimer");
		lblNewLabel.setBounds(10, 6, 235, 30);
		panelHaut.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		
		numeroConseiller = new JTextField();
		numeroConseiller.setBounds(275, 6, 228, 30);
		panelHaut.add(numeroConseiller);
		numeroConseiller.setColumns(30);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceEmployerImp serviceEmployerImp=new ServiceEmployerImp();
				String numeroEntre=numeroConseiller.getText();
				if(numeroEntre.length()==0)
				{
					JOptionPane.showMessageDialog(null,"entre le numero a supprimer");
				}else {
					employerASupprime=serviceEmployerImp.rechercherParNumeroEmployer(numeroEntre);
					if(employerASupprime==null) {
						JOptionPane.showMessageDialog(null,"l'employer n'existe pas dans la basse de donnee");
					}else {
						nomConseiller.setText(employerASupprime.getNom());
						prenomConseiller.setText(employerASupprime.getPrenom());
						adresseConseiller.setText(employerASupprime.getAdresse());
						emailConseiller.setText(employerASupprime.getEmail());
						loginConseiller.setText(employerASupprime.getLoginEmploye());
						passwordConseiller.setText(employerASupprime.getPasswordEmploye());
						telConseiller.setText(employerASupprime.getTelephone());
				        dateDeNaissance.setText(employerASupprime.getDateDenaissance()+"");
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
		btnRechercher.setBounds(520, 6, 147, 28);
		panelHaut.add(btnRechercher);
		
		
	}
}
