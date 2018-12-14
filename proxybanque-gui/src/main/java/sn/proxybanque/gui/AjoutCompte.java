package sn.proxybanque.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;

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

import sn.proxybanque.domaine.Carte;
import sn.proxybanque.domaine.Client;
import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Employer;
import sn.proxybanque.service.Numero;
import sn.proxybanque.service.ServiceCarteImp;
import sn.proxybanque.service.ServiceClientImp;
import sn.proxybanque.service.ServiceCompteImp;
import sn.proxybanque.service.ServiceEmployerImp;
import javax.swing.JRadioButton;

public class AjoutCompte extends JPanel {
	private JTextField numeroCompte;
	private JTextField solde;
	

	/**
	 * Create the panel.
	 */
	public AjoutCompte() {
		setLayout(null);
		Employer employer;
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajout Carte", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 102, 204)));
		panel.setBounds(-28, 11, 773, 453);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero Compte");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBounds(55, 54, 188, 30);
		panel.add(lblNewLabel);
		
		JLabel lblCodePostal = new JLabel("Numero Client");
		lblCodePostal.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblCodePostal.setBounds(55, 219, 188, 30);
		panel.add(lblCodePostal);
		
		JLabel lblProfession = new JLabel("Type de Compte");
		lblProfession.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblProfession.setBounds(55, 115, 188, 30);
		panel.add(lblProfession);
		
		JLabel lblVille = new JLabel("Solde");
		lblVille.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVille.setBounds(55, 173, 188, 30);
		panel.add(lblVille);
		
		JLabel dated = new JLabel("Date D'Ouverture");
		dated.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		dated.setBounds(55, 284, 188, 30);
		panel.add(dated);
		
		numeroCompte = new JTextField();
		numeroCompte.setEditable(false);
		numeroCompte.setBounds(313, 54, 228, 30);
		panel.add(numeroCompte);
		numeroCompte.setColumns(30);
		final Numero numero=new Numero();
		String num=numero.generateNumeroCompte();
		numeroCompte.setText(num);
		final JRadioButton compteEpargne = new JRadioButton("Epargne");
		compteEpargne.setBounds(314, 116, 109, 30);
		
		
		final JRadioButton compteourant = new JRadioButton("Courant");
		compteourant.setBounds(432, 116, 109, 30);
		
		ButtonGroup groupeCarte=new ButtonGroup();
		groupeCarte.add(compteourant);
		groupeCarte.add(compteEpargne);
		panel.add(compteourant);
		panel.add(compteEpargne);
		
		final JComboBox listeClient = new JComboBox();
		listeClient.setBounds(313, 220, 228, 30);
		final ServiceClientImp serviceClientImp=new ServiceClientImp();
		for (Iterator iterator = serviceClientImp.lister().iterator(); iterator.hasNext();) {
			Client client= (Client) iterator.next();
			listeClient.addItem(client.getNumeroClient());
			
		}
		panel.add(listeClient);
		
		solde = new JTextField();
		solde.setBounds(313, 173, 228, 26);
		panel.add(solde);
		solde.setColumns(10);
		
		final JDateChooser dateOuverture = new JDateChooser();
		dateOuverture.setDateFormatString("yyyy-M-d ");
		dateOuverture.setBounds(313, 284, 228, 30);
		panel.add(dateOuverture);
		
		JList list = new JList();
		list.setBounds(388, 26, 1, 1);
		panel.add(list);
         
		JButton buttonValider = new JButton("Valider");
		buttonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double soldeEntre;
				String testmont=null;
				do {

					try {
						 soldeEntre=Double.parseDouble(solde.getText());
						 testmont="valide";
						break;
					} catch (Exception ex) {
						
					}
				} while (true);
				
				
				Date dateEntre=dateOuverture.getDate();
				String typeCompte;
				String numeroCompt=numeroCompte.getText();
				if(compteEpargne.isSelected())
				{
					typeCompte=new String("Epargne");
				}else
				{
					typeCompte=new String("Courant");
				}
				String numeroClient=(String) listeClient.getSelectedItem();
			    int idClient=serviceClientImp.rechercherParNumeroClient(numeroClient).getId();
		
			    	 if(dateEntre==null ||numeroCompt.length()==0)
					    {
					    	JOptionPane.showMessageDialog(null,"remplire tout les champ");
					    
			    }else
			    {
			    	Compte compteCreer= new Compte();
			    	compteCreer.setDateOuvetureCompte(dateEntre);
			    	compteCreer.setNumeroCompte(numeroCompt);
			    	compteCreer.setTypeDeCompte(typeCompte);
			    	compteCreer.setSoldeCompte(soldeEntre);
			    	compteCreer.setIdClient(idClient);
			       ServiceCompteImp serviceCompteImp =new ServiceCompteImp();
			        serviceCompteImp.ajouter(compteCreer);
			        JOptionPane.showMessageDialog(null,"Compte Creer");
			        String newNumer0=numero.generateNumeroCompte();
			        numeroCompte.setText(newNumer0);
			        solde.setText("");
			        
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
