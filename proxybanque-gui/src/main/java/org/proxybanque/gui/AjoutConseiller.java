package org.proxybanque.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class AjoutConseiller extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public AjoutConseiller() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajout Client", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
		panel.setBounds(-28, 11, 773, 453);
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
		lblSexe.setBounds(630, 120, 188, 30);
		panel.add(lblSexe);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblEmail.setBounds(55, 156, 188, 30);
		panel.add(lblEmail);
		
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
		
		textField = new JTextField();
		textField.setBounds(313, 18, 228, 30);
		panel.add(textField);
		textField.setColumns(30);
		
		textField_1 = new JTextField();
		textField_1.setBounds(313, 54, 228, 26);
		panel.add(textField_1);
		textField_1.setColumns(30);
		
		textField_2 = new JTextField();
		textField_2.setBounds(313, 85, 228, 30);
		panel.add(textField_2);
		textField_2.setColumns(30);
		
		textField_3 = new JTextField();
		textField_3.setBounds(313, 121, 228, 30);
		panel.add(textField_3);
		textField_3.setColumns(30);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Femme");
		rdbtnNewRadioButton.setBounds(547, 161, 82, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnHomme = new JRadioButton("Homme");
		rdbtnHomme.setBounds(671, 161, 96, 23);
		panel.add(rdbtnHomme);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(313, 360, 228, 30);
		panel.add(dateChooser);
		
		textField_4 = new JTextField();
		textField_4.setBounds(313, 320, 228, 30);
		panel.add(textField_4);
		textField_4.setColumns(30);
		
		textField_5 = new JTextField();
		textField_5.setBounds(313, 280, 228, 30);
		panel.add(textField_5);
		textField_5.setColumns(30);
		
		textField_6 = new JTextField();
		textField_6.setBounds(313, 239, 228, 30);
		panel.add(textField_6);
		textField_6.setColumns(30);
		
		textField_7 = new JTextField();
		textField_7.setBounds(313, 198, 228, 30);
		panel.add(textField_7);
		textField_7.setColumns(30);
		
		textField_8 = new JTextField();
		textField_8.setBounds(313, 157, 228, 30);
		panel.add(textField_8);
		textField_8.setColumns(30);
		
		JList list = new JList();
		list.setBounds(388, 26, 1, 1);
		panel.add(list);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\check.png"));
		btnNewButton.setBackground(new Color(51, 204, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(279, 401, 124, 30);
		panel.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\busy.png"));
		btnAnnuler.setBackground(new Color(255, 102, 0));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnnuler.setBounds(413, 401, 128, 30);
		panel.add(btnAnnuler);

	}
}
