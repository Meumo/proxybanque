package sn.proxybanque.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import sn.proxybanque.domaine.Client;
import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.ServiceClientImp;
import sn.proxybanque.service.ServiceCompteImp;
import sn.proxybanque.utils.MysqlConnection;

public class ReleverBancaire extends JPanel {
	private JTextField numeroCompte;
	Compte compteARelever;
	final JPanel panelHaut;
	String numeroEntre;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public ReleverBancaire() {
		Employer employer;
		setLayout(new BorderLayout(0, 0));
		final JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(176, 196, 222));
		panelCentre.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Relever Bancaire", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
		add(panelCentre);
		panelCentre.setLayout(null);
		remove(panelCentre);

		JLabel lblNomt = new JLabel("Nom");
		lblNomt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNomt.setBounds(55, 21, 134, 30);
		panelCentre.add(lblNomt);
		
		final JLabel nom = new JLabel("New label");
		nom.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		nom.setBounds(178, 21, 168, 30);
		panelCentre.add(nom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrenom.setBounds(55, 57, 134, 30);
		panelCentre.add(lblPrenom);
		
		final JLabel prenom = new JLabel("pp");
		prenom.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		prenom.setBounds(180, 62, 150, 30);
		panelCentre.add(prenom);
		
		JLabel lblDateDeNaissance = new JLabel("Date de Naissance");
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateDeNaissance.setBounds(421, 21, 150, 30);
		panelCentre.add(lblDateDeNaissance);
		
		final JLabel date = new JLabel("New label");
		date.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		date.setBounds(609, 21, 113, 30);
		panelCentre.add(date);
		
		final JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdresse.setBounds(455, 64, 93, 30);
		panelCentre.add(lblAdresse);
		
		final JLabel adresse = new JLabel("adersse");
		adresse.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		adresse.setBounds(609, 57, 93, 30);
		panelCentre.add(adresse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 725, 253);
		panelCentre.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		final JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob printerJob=PrinterJob.getPrinterJob();
				printerJob.setJobName("Relever Bancaire");
				printerJob.setPrintable(new Printable() {
					 
					public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
						btnImprimer.setVisible(false);
						 if(pageIndex>0)
						 {
							 return Printable.NO_SUCH_PAGE;
						 }
						 Graphics2D g2= (Graphics2D) graphics;
						 g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
						 panelCentre.paintAll(g2);
						 btnImprimer.setVisible(true);
						return Printable.PAGE_EXISTS;
					}
				});
				boolean ok=printerJob.printDialog();
				if(ok)
				{
					try {
						printerJob.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnImprimer.setBounds(324, 383, 89, 23);
		panelCentre.add(btnImprimer);
		
		
		
		
		panelHaut = new JPanel();
		panelHaut.setBackground(new Color(176, 196, 222));
		add(panelHaut);
		panelHaut.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero Du Compte a Modifier");
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
					JOptionPane.showMessageDialog(null, "entre le numero du compte ");
				} else {
					compteARelever=serviceCompteImp.rechercherParNumeroCompte(numeroEntre);
					if (compteARelever == null) {
						JOptionPane.showMessageDialog(null, "le compte n'existe pas dans la basse de donnee");
					} else {
                               ServiceClientImp serviceClientImp=new ServiceClientImp();
                               Client client=serviceClientImp.findByIdClient(compteARelever.getIdClient());
                               nom.setText(client.getNom());
                               prenom.setText(client.getPrenom());
                               date.setText(client.getDateDenaissance()+"");
                               adresse.setText(client.getAdresse());
						remove(panelHaut);
						add(panelCentre);
						update();
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
	
	public void update() {
		try {
			numeroEntre=compteARelever.getNumeroCompte();
			Connection con = MysqlConnection.getInstanceConnection();
			String sql = "SELECT DISTINCT numeroCompte,montantTransaction ,dateTransaction, typeTransaction ,idConseiller FROM  compte,transaction where compte.idCompte=transaction.idCompte and transaction.idCompte="+compteARelever.getIdCompte();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
