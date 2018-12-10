package sn.proxybanque.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sn.proxybanque.domaine.Employer;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class EspaceGerant extends JFrame {

	private JPanel contentPane;
	JPanel panelBody =  new Accueille();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employer employer =new Employer();
					EspaceGerant frame = new EspaceGerant(employer);
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
	public EspaceGerant(Employer employer) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnParamettrage = new JMenu("Paramettrage");
		mnParamettrage.setIcon(new ImageIcon("C:\\Users\\image\\settings.png"));
		menuBar.add(mnParamettrage);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		mnParamettrage.add(menuItem);
		
		JMenu mnApropos = new JMenu("Apropos");
		mnApropos.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement.png"));
		menuBar.add(mnApropos);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.setIcon(new ImageIcon("C:\\Users\\image\\word-895582_960_720.png"));
		mnApropos.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 11, 964, 45);
		contentPane.add(toolBar);
		
		JButton btnAccueille = new JButton("Accueille");
		btnAccueille.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueille accueille=new Accueille();
				panelBody.removeAll();
				panelBody.add(accueille);
				validate();
			
			}
		});
		btnAccueille.setFont(new Font("Tahoma", Font.BOLD, 11));


		btnAccueille.setIcon(new ImageIcon("C:\\Users\\image\\home.png"));

		toolBar.add(btnAccueille);
		
		JButton buttonConseillers = new JButton("Conseillers  ");
		buttonConseillers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conseiller conseiller=new Conseiller();
				panelBody.removeAll();
				conseiller.setBounds(10, 67, 964, 453);
				panelBody.add(conseiller,BorderLayout.CENTER);
				getContentPane().validate();
			}
			
		});
		buttonConseillers.setFont(new Font("Tahoma", Font.BOLD, 11));


		buttonConseillers.setIcon(new ImageIcon("C:\\Users\\image\\special-offer.png"));

		buttonConseillers.setToolTipText("Gestion des conseillers clientelle");
		toolBar.add(buttonConseillers);
		
		JButton buttonClients = new JButton("Clients");
		buttonClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clients clients=new Clients();
				panelBody.removeAll();
				clients.setBounds(10, 67, 964, 453);
				panelBody.add(clients,BorderLayout.CENTER);
				getContentPane().validate();
			}
		});
		buttonClients.setFont(new Font("Tahoma", Font.BOLD, 11));

		buttonClients.setToolTipText("Gestion des clients");

		buttonClients.setIcon(new ImageIcon("C:\\Users\\image\\user.png"));
		buttonClients.setToolTipText("Gestion des ");

		toolBar.add(buttonClients);
		
		JButton buttonComptes = new JButton("Comptes");
		buttonComptes.setFont(new Font("Tahoma", Font.BOLD, 11));

		buttonComptes.setToolTipText("Gestion des comptes");

		buttonComptes.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (1).jpg"));
		buttonComptes.setToolTipText("Gestion des ");

		toolBar.add(buttonComptes);
		
		JButton buttonCartesBancaires = new JButton("Cartes  ");
		buttonCartesBancaires.setFont(new Font("Tahoma", Font.BOLD, 11));

		buttonCartesBancaires.setToolTipText("Gestion des cartes");

		buttonCartesBancaires.setIcon(new ImageIcon("C:\\Users\\image\\carte.jpg"));
		buttonCartesBancaires.setToolTipText("Gestion des ");

		toolBar.add(buttonCartesBancaires);
		
		JButton buttonSimulationCredit = new JButton("Simulation ");
		buttonSimulationCredit.setFont(new Font("Tahoma", Font.BOLD, 11));


		buttonSimulationCredit.setIcon(new ImageIcon("C:\\Users\\image\\simitation.jpg"));

		buttonSimulationCredit.setToolTipText("Gestion de la simulation de credit ");
		toolBar.add(buttonSimulationCredit);
		
		JButton buttonAuditer = new JButton("Auditer");
		buttonAuditer.setFont(new Font("Tahoma", Font.BOLD, 11));


		buttonAuditer.setIcon(new ImageIcon("C:\\Users\\image\\images.jpg"));
		buttonAuditer.setToolTipText("Gestion de l'audit");
		toolBar.add(buttonAuditer);
		
		JButton buttonJournalisation = new JButton("Journalisation");
		buttonJournalisation.setFont(new Font("Tahoma", Font.BOLD, 11));


		buttonJournalisation.setIcon(new ImageIcon("C:\\Users\\image\\images (1).jpg"));
		buttonJournalisation.setToolTipText("Gestion de la journalisation des transactions ");
		toolBar.add(buttonJournalisation);
		
		JButton buttonPatrimoinePlacement = new JButton("Patrimoine et Placement");
		buttonPatrimoinePlacement.setFont(new Font("Tahoma", Font.BOLD, 11));

		buttonPatrimoinePlacement.setIcon(new ImageIcon("C:\\Users\\image\\images (2).jpg"));
		buttonPatrimoinePlacement.setToolTipText("Gestion du patrimoine et du placement");
		toolBar.add(buttonPatrimoinePlacement);
		panelBody.setBackground(new Color(255, 255, 255));
		
		//Accueille accueille=new Accueille();
		
		
		panelBody.setBounds(10, 111, 964, 409);
		contentPane.add(panelBody);
		panelBody.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 964, 453);
		label.setIcon(new ImageIcon("C:\\Users\\image\\acc.gif"));
		panelBody.add(label);
		
		JPanel panelBas = new JPanel();
		panelBas.setBackground(new Color(102, 102, 153));
		panelBas.setBounds(10, 531, 964, 46);
		contentPane.add(panelBas);
		
		JButton buttonDeconne = new JButton("Deconnexion");
		buttonDeconne.setIcon(new ImageIcon("C:\\Users\\image\\logout.png"));
		buttonDeconne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "voulez vous confirmer la deconnexion", "Confirmation",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					Connection connection=new Connection();
					dispose();
					connection.setVisible(true);
				}
				
			}
			
			
		});
		panelBas.add(buttonDeconne);
		
		JLabel Profil = new JLabel("En ligne");
		Profil.setFont(new Font("Tahoma", Font.BOLD, 17));
		Profil.setBounds(10, 67, 116, 33);
		contentPane.add(Profil);
		
		JLabel nomEmployer = new JLabel("nomEmployer");
		nomEmployer.setBounds(156, 79, 46, 14);
		nomEmployer.setText(employer.getNom());
		contentPane.add(nomEmployer);
		
		JLabel prenomEmployer = new JLabel("New label");
		prenomEmployer.setBounds(267, 79, 46, 14);
		prenomEmployer.setText(employer.getPrenom());
		contentPane.add(prenomEmployer);
	}
}
