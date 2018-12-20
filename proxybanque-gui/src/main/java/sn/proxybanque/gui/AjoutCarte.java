package sn.proxybanque.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import sn.proxybanque.domaine.Carte;
import sn.proxybanque.domaine.Client;
import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceCarteImp;
import sn.proxybanque.service.ServiceClientImp;

public class AjoutCarte extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField numeroCarte;
	private JTextField codesecret;
	// private ButtonGroup buttonGroup;

	/**
	 * Create the panel.
	 */
	public AjoutCarte() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajout Carte", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(102, 102, 204)));
		panel.setBounds(-42, 11, 773, 453);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero Carte");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBounds(55, 54, 188, 30);
		panel.add(lblNewLabel);

		JLabel lblCodePostal = new JLabel("Numero Client");
		lblCodePostal.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblCodePostal.setBounds(55, 219, 188, 30);
		panel.add(lblCodePostal);

		JLabel lblProfession = new JLabel("Carte Visa");
		lblProfession.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblProfession.setBounds(55, 115, 188, 30);
		panel.add(lblProfession);

		JLabel lblVille = new JLabel("Code Secret");
		lblVille.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVille.setBounds(55, 173, 188, 30);
		panel.add(lblVille);

		JLabel dated = new JLabel("Date D'Expriation");
		dated.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		dated.setBounds(55, 284, 188, 30);
		panel.add(dated);

		numeroCarte = new JTextField();
		numeroCarte.setEditable(false);
		numeroCarte.setBounds(313, 54, 228, 30);
		panel.add(numeroCarte);
		numeroCarte.setColumns(30);
		final Numero numero = new Numero();
		String num = numero.generateNumeroCarte();
		numeroCarte.setText(num);
		final JRadioButton visaElectron = new JRadioButton("Electron");
		visaElectron.setBounds(314, 116, 109, 30);

		final JRadioButton visaPremier = new JRadioButton("Premier");
		visaPremier.setBounds(432, 116, 109, 30);

		ButtonGroup groupeCarte = new ButtonGroup();
		groupeCarte.add(visaPremier);
		groupeCarte.add(visaElectron);
		panel.add(visaPremier);
		panel.add(visaElectron);

		final JComboBox listeClient = new JComboBox();
		listeClient.setBounds(313, 220, 228, 30);
		final ServiceClientImp serviceClientImp = new ServiceClientImp();
		for (Iterator iterator = serviceClientImp.lister().iterator(); iterator.hasNext();) {
			Client client = (Client) iterator.next();
			listeClient.addItem(client.getNumeroClient());

		}
		panel.add(listeClient);

		codesecret = new JTextField();
		codesecret.setBounds(313, 173, 228, 26);
		panel.add(codesecret);
		codesecret.setColumns(10);

		final JDateChooser dateExpriation = new JDateChooser();
		dateExpriation.setDateFormatString("yyyy-M-d ");
		dateExpriation.setBounds(313, 284, 228, 30);
		panel.add(dateExpriation);

		JButton buttonValider = new JButton("Valider");
		buttonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = codesecret.getText();
				Date dateExp = dateExpriation.getDate();
				String typeCarte;
				String numcarte = numeroCarte.getText();
				if (visaElectron.isSelected()) {
					typeCarte = new String("Electron");
				} else {
					typeCarte = new String("Premier");
				}
				String numeroClient = (String) listeClient.getSelectedItem();
				int idClient = serviceClientImp.rechercherParNumeroClient(numeroClient).getId();
				if (code.length() == 0 || dateExp == null || numeroClient.length() == 0) {
					JOptionPane.showMessageDialog(null, "remplire tout les champ");
				} else {
					Carte carteCreer = new Carte(numcarte, typeCarte, code, dateExp, idClient);
					ServiceCarteImp serviceCarteImp = new ServiceCarteImp();
					serviceCarteImp.ajouter(carteCreer);
					JOptionPane.showMessageDialog(null, "Carte Creer");
					String newNumer0 = numero.generateNumeroCarte();
					numeroCarte.setText(newNumer0);
					codesecret.setText("");

				}

			}
		});
		buttonValider.setIcon(new ImageIcon("C:\\Users\\image\\check.png"));
		buttonValider.setBackground(new Color(51, 204, 51));
		buttonValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonValider.setBounds(236, 369, 124, 30);
		panel.add(buttonValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		btnAnnuler.setIcon(new ImageIcon("C:\\Users\\image\\busy.png"));
		btnAnnuler.setBackground(new Color(255, 102, 0));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnnuler.setBounds(402, 369, 128, 30);
		panel.add(btnAnnuler);

	}
}
