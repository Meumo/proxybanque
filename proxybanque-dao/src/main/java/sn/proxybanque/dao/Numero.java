package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sn.proxybanque.utils.MysqlConnection;

/**
 * Date Decembre 20-2018 # La classe 'Numero' c'est une classe qui permet de
 * generer les differents numeros des classe qui composent notre systeme.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 */
public class Numero {
	Connection con = MysqlConnection.getInstanceConnection();

	/**
	 * La methode 'generateNumeroCarte' permet de generer le numero d'une carte
	 * bancaire.
	 * 
	 * @return Une chaine de caractere composee uniquement de chiffre.
	 */
	public String generateNumeroCarte() {
		long sufCarte = 0;
		String prefCarte = null;
		try {
			String sql = "SELECT * FROM numero";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				prefCarte = rs.getString("numeroCarte");
				sufCarte = rs.getLong("sufCarte");
				String req = "UPDATE numero SET sufCarte=? WHERE id=?";
				PreparedStatement ps = con.prepareStatement(req);
				ps.setLong(1, sufCarte + 1);
				ps.setLong(2, 1);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prefCarte + " " + sufCarte;
	}

	/**
	 * La methode 'generateNumeroCompte' permet de generer le numero d'un compte
	 * bancaire.
	 * 
	 * @return Une chaine de caractere composee uniquement de chiffre.
	 */
	public String generateNumeroCompte() {
		long sufCompte = 0;
		String prefCompte = null;
		try {
			String sql = "SELECT * FROM numero";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				prefCompte = rs.getString("numeroCompte");
				sufCompte = rs.getLong("sufCompte");
				String req = "UPDATE numero SET sufCompte=? WHERE id=?";
				PreparedStatement ps = con.prepareStatement(req);
				ps.setLong(1, sufCompte + 1);
				ps.setLong(2, 1);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prefCompte + " " + sufCompte;
	}

	/**
	 * La methode 'generateNumeroAgence' permet de generer le numero d'une agence.
	 * 
	 * @return Une chaine de caractere composee uniquement de chiffre.
	 */
	public String generateNumeroAgence() {
		long sufAgence = 0;
		long prefAgence = 0;
		try {
			String sql = "SELECT * FROM numero";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				prefAgence = rs.getLong("numeroAgence");
				sufAgence = rs.getLong("sufAgence");
				String req = "UPDATE numero SET sufAgence=? WHERE id=?";
				PreparedStatement ps = con.prepareStatement(req);
				ps.setLong(1, sufAgence + 1);
				ps.setLong(2, 1);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "" + prefAgence + sufAgence;
	}

	/**
	 * La methode 'generateNumeroClient' permet de generer le numero d'un client.
	 * 
	 * @return Une chaine de caractere composee uniquement de chiffre.
	 */
	public String generateNumeroClient() {
		long sufClient = 0;
		long prefClient = 0;
		try {
			String sql = "SELECT * FROM numero";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				prefClient = rs.getLong("numeroClient");
				sufClient = rs.getLong("sufClient");
				String req = "UPDATE numero SET sufClient=? WHERE id=?";
				PreparedStatement ps = con.prepareStatement(req);
				ps.setLong(1, sufClient + 1);
				ps.setLong(2, 1);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "" + prefClient + sufClient;
	}

	/**
	 * La methode 'generateNumeroEmploye' permet de generer le numero d'un employe.
	 * 
	 * @return Une chaine de caractere composee uniquement de chiffre.
	 */
	public String generateNumeroEmploye() {
		long sufEmploye = 0;
		long prefEmploye = 0;
		try {
			String sql = "SELECT * FROM numero";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				prefEmploye = rs.getLong("numeroEmploye");
				sufEmploye = rs.getLong("sufEmploye");
				String req = "UPDATE numero SET sufEmploye=? WHERE id=?";
				PreparedStatement ps = con.prepareStatement(req);
				ps.setLong(1, sufEmploye + 1);
				ps.setLong(2, 1);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "" + prefEmploye + sufEmploye;
	}

	/**
	 * La methode 'generateNumeroTransaction' permet de generer le numero d'une
	 * transaction.
	 * 
	 * @return Une chaine de caractere composee uniquement de chiffre.
	 */
	public String generateNumeroTransaction() {
		long sufTransaction = 0;
		long prefTransaction = 0;
		try {
			String sql = "SELECT * FROM numero";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				prefTransaction = rs.getLong("numeroTransaction");
				sufTransaction = rs.getLong("sufTransaction");
				String req = "UPDATE numero SET sufTransaction=? WHERE id=?";
				PreparedStatement ps = con.prepareStatement(req);
				ps.setLong(1, sufTransaction + 1);
				ps.setLong(2, 1);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "" + prefTransaction + sufTransaction;
	}
}
