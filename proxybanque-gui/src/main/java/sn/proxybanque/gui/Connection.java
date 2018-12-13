package sn.proxybanque.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.ServiceEmployerImp;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import sn.proxybanque.dao.IDaoEmployerImp;
import sn.proxybanque.domaine.Employer;


public class Connection extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JPasswordField passwordField;
	public Employer employerConnecter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection frame = new Connection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Connection() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(10, 0, 649, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBienvenue = new JLabel("");

		lblBienvenue.setIcon(new ImageIcon("C:\\Users\\image\\pp.gif"));

		lblBienvenue.setIcon(new ImageIcon("C:\\users\\image\\pp.gif"));

		lblBienvenue.setFont(new Font("Bernard MT Condensed", Font.BOLD | Font.ITALIC, 56));
		lblBienvenue.setBounds(0, 5, 661, 57);
		panel.add(lblBienvenue);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Connection", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_1.setBounds(10, 59, 649, 166);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\user.png"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(222, 21, 143, 30);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\images.png"));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(222, 62, 155, 30);
		panel_1.add(lblNewLabel_1);
		
		login = new JTextField();
		login.setBounds(399, 23, 211, 30);
		panel_1.add(login);
		login.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String loginSaisie=login.getText();
				String passWordSaisie=passwordField.getText();
				if(loginSaisie.length()==0 || passWordSaisie.length()==0) {
					JOptionPane.showMessageDialog(null,"Entre le login ou le mot de passe");
				}else {
					ServiceEmployerImp serviceEmployerImp=new ServiceEmployerImp();
					employerConnecter=serviceEmployerImp.authentification(loginSaisie, passWordSaisie);
					if(employerConnecter!=null)
					{
						String type=employerConnecter.getTypeEmploye();
						dispose();
						if(type.equals("gerant"))
						{
							EspaceGerant espaceGerant=new EspaceGerant(employerConnecter);
							
							espaceGerant.setVisible(true);
						}else {
							EspaceConseiller espaceConseiller=new EspaceConseiller(employerConnecter);
						
							espaceConseiller.setVisible(true);
						}
					}else {
						JOptionPane.showMessageDialog(null,"login ou mots de passe incorrecte");
					}
				}
					

			}
		});
		btnValider.setBackground(new Color(102, 255, 0));
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnValider.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\check.png"));
		btnValider.setBounds(362, 125, 124, 30);
		panel_1.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login.setText("");
				passwordField.setText("");
				
			}
		});
		btnAnnuler.setBackground(new Color(255, 0, 0));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnnuler.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\81927424-annuler-isolé-sur-orange-vitreux-rond-illustration-abstraite-de-bouton.jpg"));
		btnAnnuler.setBounds(496, 125, 143, 30);
		panel_1.add(btnAnnuler);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\image\\grouep.png"));
		lblNewLabel_2.setBounds(10, 11, 149, 144);
		panel_1.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(399, 62, 211, 30);
		panel_1.add(passwordField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(10, 226, 649, 44);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		btnNewButton.setBackground(new Color(255, 0, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon("C:\\developpement\\outil\\workpace\\proxibank\\proxybanque-gui\\image\\logout.png"));
		btnNewButton.setBounds(31, 11, 101, 22);
		panel_2.add(btnNewButton);
	}
}
