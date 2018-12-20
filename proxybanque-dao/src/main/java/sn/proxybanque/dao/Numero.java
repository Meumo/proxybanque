package sn.proxybanque.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Numero {
	private String url = "jdbc:mysql://localhost:3306/proxibanque";
	private String user = "objis";
	private String passwd = "objis";

	public String generateNumeroCarte() {
		long sufCarte = 0;
		String prefCarte = null;
		try {
			Connection con = DriverManager.getConnection(url, user, passwd);
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

	public String generateNumeroCompte() {
		long sufCompte = 0;
		String prefCompte = null;
		try {
			Connection con = DriverManager.getConnection(url, user, passwd);
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

	public String generateNumeroAgence() {
		long sufAgence = 0;
		long prefAgence = 0;
		try {
			Connection con = DriverManager.getConnection(url, user, passwd);
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

	public String generateNumeroClient() {
		long sufClient = 0;
		long prefClient = 0;
		try {
			Connection con = DriverManager.getConnection(url, user, passwd);
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

	public String generateNumeroEmploye() {
		long sufEmploye = 0;
		long prefEmploye = 0;
		try {
			Connection con = DriverManager.getConnection(url, user, passwd);
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

	public String generateNumeroTransaction() {
		long sufTransaction = 0;
		long prefTransaction = 0;
		try {
			Connection con = DriverManager.getConnection(url, user, passwd);
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
