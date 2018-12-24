package sn.proxybanque.service;

import java.sql.Connection;

import sn.proxybanque.utils.MysqlConnection;

/**
 * Date Decembre 20-2018 # La classe 'Numero' c'est une classe qui permet de
 * generer les differents numeros des classe qui composent notre systeme.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 */
public class Numero {
	Connection con = MysqlConnection.getInstanceConnection();
sn.proxybanque.dao.Numero numero =new sn.proxybanque.dao.Numero();
	public String generateNumeroCarte() {
		return numero.generateNumeroCarte();
	}

	public String generateNumeroCompte() {
		return numero.generateNumeroCompte();
	}

	public String generateNumeroAgence() {
		return numero.generateNumeroAgence();
	}

	public String generateNumeroClient() {
		return numero.generateNumeroClient();
	}

	public String generateNumeroEmploye() {
		return numero.generateNumeroEmploye();
	}

	public String generateNumeroTransaction() {

		return numero.generateNumeroTransaction();
	}
}
