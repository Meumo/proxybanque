package sn.proxybanque.service;

import java.sql.Connection;

import sn.proxybanque.utils.MysqlConnection;

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
