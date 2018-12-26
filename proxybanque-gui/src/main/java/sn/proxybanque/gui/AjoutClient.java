package sn.proxybanque.gui;

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

import sn.proxybanque.domaine.Client;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceClientImp;

public class AjoutClient extends JPanel {
	private JTextField numeroClient;
	private JTextField nomClient;
	private JTextField prenomClient;
	private JTextField adresseClient;
	private JTextField professionClient;
	private JTextField villeClient;
	private JTextField codePostal;
	private JTextField telephoneClient;
	private JTextField emailClient;

	/**
	 * Create the panel.
	 */
	public AjoutClient(final int idConseillerConnecter) {
		setLayout(null);
		ButtonGroup groupeSexe=new ButtonGroup();
		final JRadioButton homme=new JRadioButton("homme");
		homme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		final  JRadioButton femme=new JRadioButton("femme");
		femme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		femme.setBounds(547, 180, 96, 23);
		homme.setBounds(656, 180, 83, 23);
		groupeSexe.add(homme);
		groupeSexe.add(femme);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajout Client", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
		panel.setBounds(-28, 11, 745, 453);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero Client");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBounds(55, 18, 188, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNomClient = new JLabel("Nom Client");
		lblNomClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNomClient.setBounds(55, 54, 188, 30);
		panel.add(lblNomClient);
		
		JLabel lblPrenomClient = new JLabel("Prenom Client");
		lblPrenomClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblPrenomClient.setBounds(55, 84, 188, 30);
		panel.add(lblPrenomClient);
		
		JLabel lblAdresseClient = new JLabel("Adresse Client");
		lblAdresseClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblAdresseClient.setBounds(55, 120, 188, 30);
		panel.add(lblAdresseClient);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblSexe.setBounds(627, 143, 188, 30);
		panel.add(lblSexe);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblEmail.setBounds(55, 156, 188, 30);
		panel.add(lblEmail);
		panel.add(femme);
		panel.add(homme);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblTelephone.setBounds(55, 197, 188, 30);
		panel.add(lblTelephone);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblCodePostal.setBounds(55, 238, 188, 30);
		panel.add(lblCodePostal);
		
		JLabel lblProfession = new JLabel("Profession");
		lblProfession.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblProfession.setBounds(55, 319, 188, 30);
		panel.add(lblProfession);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVille.setBounds(55, 279, 188, 30);
		panel.add(lblVille);
		
		JLabel lblDateDeNaissance = new JLabel("Date de Naissance");
		lblDateDeNaissance.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblDateDeNaissance.setBounds(55, 360, 188, 30);
		panel.add(lblDateDeNaissance);
		
		numeroClient = new JTextField();
		numeroClient.setEditable(false);
		numeroClient.setBounds(313, 18, 228, 30);
		panel.add(numeroClient);
		numeroClient.setColumns(30);
		Numero numero =new Numero();
		String num=numero.generateNumeroClient();
		numeroClient.setText(num);
		
		nomClient = new JTextField();
		nomClient.setBounds(313, 54, 228, 26);
		panel.add(nomClient);
		nomClient.setColumns(30);
		
		prenomClient = new JTextField();
		prenomClient.setBounds(313, 85, 228, 30);
		panel.add(prenomClient);
		prenomClient.setColumns(30);
		
		adresseClient = new JTextField();
		adresseClient.setBounds(313, 121, 228, 30);
		panel.add(adresseClient);
		adresseClient.setColumns(30);
		
		final JDateChooser dateNaissanceClient = new JDateChooser();
		dateNaissanceClient.setDateFormatString("yyyy-M-dd");
		dateNaissanceClient.setBounds(313, 360, 228, 30);
		panel.add(dateNaissanceClient);
		
		professionClient = new JTextField();
		professionClient.setBounds(313, 320, 228, 30);
		panel.add(professionClient);
		professionClient.setColumns(30);
		
		villeClient = new JTextField();
		villeClient.setBounds(313, 280, 228, 30);
		panel.add(villeClient);
		villeClient.setColumns(30);
		
		codePostal = new JTextField();
		codePostal.setBounds(313, 239, 228, 30);
		panel.add(codePostal);
		codePostal.setColumns(30);
		
		telephoneClient = new JTextField();
		telephoneClient.setBounds(313, 198, 228, 30);
		panel.add(telephoneClient);
		telephoneClient.setColumns(30);
		
		emailClient = new JTextField();
		emailClient.setBounds(313, 157, 228, 30);
		panel.add(emailClient);
		emailClient.setColumns(30);
		
		JList list = new JList();
		list.setBounds(388, 26, 1, 1);
		panel.add(list);
		
		JButton buttonValider = new JButton("Valider");
		buttonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sexeSelection=null;
				if(homme.isSelected())
				{
					sexeSelection="Homme";
					
				}
				if(femme.isSelected()){
					sexeSelection="Femme";
				}
				
				String numero=numeroClient.getText();
				String nom=nomClient.getText();
				String prenom=prenomClient.getText();
				String adresse=adresseClient.getText();
				String email=emailClient.getText();
				String ville=villeClient.getText();
				String codepost=codePostal.getText();
				String professeion=professionClient.getText();
				String telephone=telephoneClient.getText();
				Date date=dateNaissanceClient.getDate();
				int idConseiller=idConseillerConnecter;
				if(sexeSelection==null || nom.length()==0 || prenom.length()==0 || adresse.length()==0 || email.length()==0 ||ville.length()==0 ||codepost.length()==0 ||professeion.length()==0 ||date==null)
				{
					JOptionPane.showMessageDialog(null,"veuillez remplire tout les champs");
				}else {
					Client clientAjouter=new Client(nom, prenom, adresse, telephone, date, email, sexeSelection, numero, codepost, ville, professeion, idConseiller);
					ServiceClientImp serviceClientImp=new ServiceClientImp();
					serviceClientImp.ajouter(clientAjouter);
					System.out.println(clientAjouter);
					JOptionPane.showMessageDialog(null,"insertion reussit");
					nomClient.setText("");
					prenomClient.setText("");
					adresseClient.setText("");
					emailClient.setText("");
					villeClient.setText("");
					codePostal.setText("");
					professionClient.setText("");
					telephoneClient.setText("");
					Numero nouveauNumero=new Numero();
					numeroClient.setText(nouveauNumero.generateNumeroClient()+"");
					}
			}
		});
		buttonValider.setIcon(new ImageIcon("C:\\Users\\image\\check.png"));
		buttonValider.setBackground(new Color(51, 204, 51));
		buttonValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonValider.setBounds(279, 401, 124, 30);
		panel.add(buttonValider);
		
		JButton buttonAnnuler = new JButton("Annuler");
		buttonAnnuler.setIcon(new ImageIcon("C:\\Users\\image\\busy.png"));
		buttonAnnuler.setBackground(new Color(255, 102, 0));
		buttonAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonAnnuler.setBounds(413, 401, 128, 30);
		panel.add(buttonAnnuler);
		
		

	}
}
