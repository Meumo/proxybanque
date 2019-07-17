package sn.proxybanque.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import sn.proxybanque.domaine.Employer;

public class EspaceConseiller extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel panelBody = new Accueille();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection connection = new Connection();
					connection.setVisible(true);
					// Employer employer =new Employer();
					// EspaceGerant frame = new EspaceGerant(employer);
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EspaceConseiller(final Employer employer) {
		requestFocus(false);
		// setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 668);
		setLocationRelativeTo(null);
		setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(102, 153, 255));
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
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		mntmHelp.setIcon(new ImageIcon("C:\\Users\\image\\word-895582_960_720.png"));
		mnApropos.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(121, 11, 760, 45);
		contentPane.add(toolBar);

		JButton btnAccueille = new JButton("Accueille");
		btnAccueille.setBackground(new Color(0, 191, 255));
		btnAccueille.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueille accueille = new Accueille();
				panelBody.removeAll();
				panelBody.add(accueille);
				validate();

			}
		});
		btnAccueille.setFont(new Font("Tahoma", Font.BOLD, 15));

		btnAccueille.setIcon(new ImageIcon("C:\\Users\\image\\home.png"));

		toolBar.add(btnAccueille);

		JButton buttonClients = new JButton("Clients");
		buttonClients.setBackground(new Color(0, 191, 255));
		buttonClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clients clients = new Clients(employer);
				panelBody.removeAll();
				clients.setBounds(10, 67, 964, 453);
				panelBody.add(clients, BorderLayout.CENTER);
				getContentPane().validate();
			}
		});
		buttonClients.setFont(new Font("Tahoma", Font.BOLD, 15));

		buttonClients.setToolTipText("Gestion des clients");

		buttonClients.setIcon(new ImageIcon("C:\\Users\\image\\user.png"));
		buttonClients.setToolTipText("Gestion des ");

		toolBar.add(buttonClients);

		JButton buttonComptes = new JButton("Comptes");
		buttonComptes.setBackground(new Color(0, 191, 255));
		buttonComptes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompteBanque compteBanque = new CompteBanque(employer);
				panelBody.removeAll();
				compteBanque.setBounds(10, 67, 964, 453);
				panelBody.add(compteBanque, BorderLayout.CENTER);
				getContentPane().validate();
			}
		});
		buttonComptes.setFont(new Font("Tahoma", Font.BOLD, 15));

		buttonComptes.setToolTipText("Gestion des comptes");

		buttonComptes.setIcon(new ImageIcon("C:\\Users\\image\\téléchargement (1).jpg"));
		buttonComptes.setToolTipText("Gestion des ");

		toolBar.add(buttonComptes);

		JButton buttonCartesBancaires = new JButton("Cartes  ");
		buttonCartesBancaires.setBackground(new Color(0, 191, 255));
		buttonCartesBancaires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CartesBanque cartesBanque = new CartesBanque(employer);
				panelBody.removeAll();
				cartesBanque.setBounds(10, 67, 964, 453);
				panelBody.add(cartesBanque, BorderLayout.CENTER);
				getContentPane().validate();
			}
		});
		buttonCartesBancaires.setFont(new Font("Tahoma", Font.BOLD, 15));

		buttonCartesBancaires.setToolTipText("Gestion des cartes");

		buttonCartesBancaires.setIcon(new ImageIcon("C:\\Users\\image\\carte.jpg"));
		buttonCartesBancaires.setToolTipText("Gestion des ");

		toolBar.add(buttonCartesBancaires);

		JButton buttonTransaction = new JButton("Transactions");
		buttonTransaction.setBackground(new Color(0, 191, 255));
		buttonTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transactions transactions = new Transactions(employer);
				panelBody.removeAll();
				transactions.setBounds(10, 67, 964, 453);
				panelBody.add(transactions, BorderLayout.CENTER);
				getContentPane().validate();
			}

		});
		buttonTransaction.setFont(new Font("Tahoma", Font.BOLD, 15));

		buttonTransaction.setIcon(new ImageIcon("C:\\Users\\image\\images (2).jpg"));
		buttonTransaction.setToolTipText("Gestion des Transactions");
		toolBar.add(buttonTransaction);

		JButton buttonSimulationCredit = new JButton("Simulation ");
		buttonSimulationCredit.setBackground(new Color(0, 191, 255));
		buttonSimulationCredit.setFont(new Font("Tahoma", Font.BOLD, 15));

		buttonSimulationCredit.setIcon(new ImageIcon("C:\\Users\\image\\simitation.jpg"));

		buttonSimulationCredit.setToolTipText("Gestion de la simulation de credit ");
		toolBar.add(buttonSimulationCredit);
		panelBody.setBackground(new Color(255, 255, 255));

		// Accueille accueille=new Accueille();

		panelBody.setBounds(10, 55, 964, 465);
		contentPane.add(panelBody);
		panelBody.setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("");
		label.setBackground(new Color(102, 153, 255));
		label.setIcon(new ImageIcon("C:\\Users\\image\\acc.gif"));
		panelBody.add(label);

		JPanel panelBas = new JPanel();
		panelBas.setBackground(Color.WHITE);
		panelBas.setBounds(10, 531, 964, 49);
		contentPane.add(panelBas);

		JButton buttonDeconne = new JButton("Deconnexion");
		buttonDeconne.setIcon(new ImageIcon("C:\\Users\\image\\logout.png"));
		buttonDeconne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "voulez vous confirmer la deconnexion", "Confirmation",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					Connection connection = new Connection();
					dispose();
					connection.setVisible(true);
				}

			}

		});
		panelBas.add(buttonDeconne);

		panelBas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel Profil = new JLabel("En ligne");
		panelBas.add(Profil);
		Profil.setForeground(Color.GREEN);
		Profil.setFont(new Font("Tahoma", Font.BOLD, 17));

		JLabel nomEmployer = new JLabel("nomEmployer");
		panelBas.add(nomEmployer);
		nomEmployer.setFont(new Font("Tahoma", Font.ITALIC, 16));
		nomEmployer.setText(employer.getNom());

		JLabel prenomEmployer = new JLabel("New label");
		panelBas.add(prenomEmployer);
		prenomEmployer.setFont(new Font("Tahoma", Font.ITALIC, 16));
		prenomEmployer.setText(employer.getPrenom());

	}
}
