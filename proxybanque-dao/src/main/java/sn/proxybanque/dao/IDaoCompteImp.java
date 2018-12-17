package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.proxybanque.domaine.Compte;
import sn.proxybanque.utils.MysqlConnection;

public class IDaoCompteImp implements IDaoCompte {
	Connection con = MysqlConnection.getInstanceConnection();

	public void create(Compte t) {
		String sql = "INSERT INTO compte(numeroCompte, soldeCompte, typeDeCompte, dateOuvetureCompte, idClient) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNumeroCompte());
			ps.setDouble(2, t.getSoldeCompte());
			ps.setString(3, t.getTypeDeCompte());
			java.sql.Date date_sql = new java.sql.Date(t.getDateOuvetureCompte().getTime());
			ps.setDate(4, date_sql);
			ps.setInt(5, t.getIdClient());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Compte t) {
		String sql = "UPDATE compte SET numeroCompte=?,soldeCompte?=,typeDeCompte=?,dateOuvetureCompte=?,idClient=? WHERE numeroCompte";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getNumeroCompte());
			ps.setDouble(2, t.getSoldeCompte());
			ps.setString(3, t.getTypeDeCompte());
			java.sql.Date date_sql = new java.sql.Date(t.getDateOuvetureCompte().getTime());
			ps.setDate(4, date_sql);
			ps.setString(5, t.getNumeroCompte());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Compte> read() {
		List<Compte> listCompte = new ArrayList<Compte>();
		try {
			String sql = "SELECT * FROM compte";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Compte compte = new Compte();

				compte.setIdCompte(rs.getInt("idCompte"));
				compte.setNumeroCompte(rs.getString("numeroCompte"));
				compte.setSoldeCompte(rs.getDouble("soldeCompte"));
				compte.setTypeDeCompte(rs.getString("typeDeCompte"));
				compte.setDateOuvetureCompte(rs.getDate("dateOuvetureCompte"));
				compte.setIdClient(rs.getInt("idClient"));
				listCompte.add(compte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCompte;
	}

	public void delete(Compte t) {
		try {
			String sql = "DELETE FROM compte WHERE numeroCompte=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNumeroCompte());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void display(Compte t) {
		// TODO Auto-generated method stub

	}

	public Compte findByNumberCompte(String numberCompte) {
		Compte compteRecup = null;
		try {
			String sql = "SELECT * FROM compte WHERE numeroCompte=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, numberCompte);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				compteRecup = new Compte(rs.getInt("idCompte"), rs.getString("numeroCompte"),
						rs.getDouble("soldeCompte"), rs.getString("typeDeCompte"), rs.getDate("dateOuvetureCompte"),
						rs.getInt("idClient"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return compteRecup;
	}

	public boolean audit(Compte compte) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Compte> nbreCompte(int idClient) {
		List<Compte> listCompte = new ArrayList<Compte>();
		try {
			String sql = "SELECT * FROM compte WHERE idClient=idClient";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Compte compte = new Compte();

				compte.setIdCompte(rs.getInt("idCompte"));
				compte.setNumeroCompte(rs.getString("numeroCompte"));
				compte.setSoldeCompte(rs.getDouble("soldeCompte"));
				compte.setTypeDeCompte(rs.getString("typeDeCompte"));
				compte.setDateOuvetureCompte(rs.getDate("dateOuvetureCompte"));
				compte.setIdClient(rs.getInt("idClient"));
				listCompte.add(compte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCompte;
	}

}
