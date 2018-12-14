package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.proxybanque.domaine.Carte;
import sn.proxybanque.utils.MysqlConnection;

public class IDaoCarteImp implements IDaoCarte {

	Connection con = MysqlConnection.getInstanceConnection();

	public void create(Carte t) {
		String sql = "INSERT INTO carte(numeroCarte, typeDeCarte, codeSecretCarte, dateExpirationCarte, idClient) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNumeroCarte());
			ps.setString(2, t.getTypeCarte());
			ps.setString(3, t.getCodeSecretCarte());
			java.sql.Date date_sql = new java.sql.Date(t.getDateExpirationCarte().getTime());
			ps.setDate(4, date_sql);
			ps.setInt(5, t.getIdClient());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Carte t) {
		String sql = "UPDATE carte SET typeDeCarte=?,codeSecretCarte=?,dateExpirationCarte=?,idClient=? WHERE numeroCarte=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getTypeCarte());
			ps.setString(2, t.getCodeSecretCarte());
			java.sql.Date date_sql = new java.sql.Date(t.getDateExpirationCarte().getTime());
			ps.setDate(3, date_sql);
			ps.setInt(4, t.getIdClient());
			ps.setString(5, t.getNumeroCarte());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Carte> read() {
		List<Carte> listCarte = new ArrayList<Carte>();
		try {
			String sql = "SELECT * FROM carte";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Carte carte = new Carte();

				carte.setNumeroCarte("numeroCarte");
				carte.setTypeCarte(rs.getString("typeDeCarte"));
				carte.setCodeSecretCarte(rs.getString("codeSecretCarte"));
				carte.setDateExpirationCarte(rs.getDate("dateExpirationCarte"));
				carte.setIdClient(rs.getInt("idClient"));

				listCarte.add(carte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCarte;
	}

	public void delete(Carte t) {
		try {
			String sql = "DELETE FROM carte WHERE numeroCarte=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNumeroCarte());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void display(Carte t) {
		// TODO Auto-generated method stub

	}

	public boolean disableCarte(Carte carte) {
		// TODO Auto-generated method stub
		return false;
	}

	public Carte findByNumberCarte(String Numbercarte) {
		Carte carteRecup = null;
		try {
			String sql = "SELECT * FROM carte WHERE numeroCarte=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Numbercarte);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				carteRecup = new Carte(rs.getString("numeroCarte"), rs.getString("typeDeCarte"),
						rs.getString("codeSecretCarte"), rs.getDate("dateExpirationCarte"), rs.getInt("idClient"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carteRecup;
	}

	public List<Carte> nbreCarte(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

}
