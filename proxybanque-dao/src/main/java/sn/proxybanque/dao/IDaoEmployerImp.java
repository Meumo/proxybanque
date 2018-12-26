package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.proxybanque.domaine.Employer;
import sn.proxybanque.utils.MysqlConnection;

/**
 * Date Decembre 20-2018 # La classe 'IDaoEmployerImp' c'est une classe qui
 * etend notre interface 'IDaoEmployer'.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @see IDaoEmployer
 */
public class IDaoEmployerImp implements IDaoEmployer {

	Connection con = MysqlConnection.getInstanceConnection();

	public void create(Employer t) {
		String sql = "INSERT INTO  employe (numeroEmploye, nomEmploye, prenomEmploye, dateDenaissanceEmploye, TelephoneEmploye, EmailEmploye, loginEmploye, passwordEmploye, adresseEmploye, sexeEmploye, typeEmploye, idAgence) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNumeroEmploye());
			ps.setString(2, t.getNom());
			ps.setString(3, t.getPrenom());
			java.sql.Date date_sql = new java.sql.Date(t.getDateDenaissance().getTime());
			ps.setDate(4, date_sql);
			ps.setString(5, t.getTelephone());
			ps.setString(6, t.getEmail());
			ps.setString(7, t.getLoginEmploye());
			ps.setString(8, t.getPasswordEmploye());
			ps.setString(9, t.getAdresse());
			ps.setString(10, t.getSexe());
			ps.setString(11, t.getTypeEmploye());
			ps.setInt(12, t.getIdAgence());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Employer t) {
		String sql = "UPDATE employe SET nomEmploye=?,prenomEmploye=?,dateDenaissanceEmploye=?,TelephoneEmploye=?,EmailEmploye=?,loginEmploye=?,passwordEmploye=?,adresseEmploye=?,sexeEmploye=?,typeEmploye=?,idAgence=? WHERE numeroEmploye=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getNom());
			ps.setString(2, t.getPrenom());
			java.sql.Date date_sql = new java.sql.Date(t.getDateDenaissance().getTime());
			ps.setDate(3, date_sql);
			ps.setString(4, t.getTelephone());
			ps.setString(5, t.getEmail());
			ps.setString(6, t.getLoginEmploye());
			ps.setString(7, t.getPasswordEmploye());
			ps.setString(8, t.getAdresse());
			ps.setString(9, t.getSexe());
			ps.setString(10, t.getTypeEmploye());
			ps.setInt(11, t.getIdAgence());
			ps.setString(12, t.getNumeroEmploye());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employer> read() {

		List<Employer> listEmploye = new ArrayList<Employer>();
		try {
			String sql = "SELECT * FROM employe";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Employer employe = new Employer();

				employe.setId(rs.getInt("idEmploye"));
				employe.setNumeroEmploye("numeroEmploye");
				employe.setNom(rs.getString("nomEmploye"));
				employe.setPrenom(rs.getString("prenomEmploye"));
				employe.setDateDenaissance(rs.getDate("dateDenaissanceEmploye"));
				employe.setTelephone(rs.getString("TelephoneEmploye"));
				employe.setEmail(rs.getString("EmailEmploye"));
				employe.setLoginEmploye(rs.getString("loginEmploye"));
				employe.setPasswordEmploye(rs.getString("passwordEmploye"));
				employe.setAdresse(rs.getString("adresseEmploye"));
				employe.setSexe(rs.getString("sexeEmploye"));
				employe.setTypeEmploye(rs.getString("typeEmploye"));
				employe.setIdAgence(rs.getInt("idAgence"));
				listEmploye.add(employe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEmploye;
	}

	public void delete(Employer t) {
		try {
			String sql = "DELETE FROM employe WHERE numeroEmploye=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNumeroEmploye());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void display(Employer t) {
		// A faire after
	}

	public Employer findByNumberEmployer(String numberEmployer) {
		Employer employeRecup = null;
		try {
			String sql = "SELECT * FROM employe WHERE numeroEmploye=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, numberEmployer);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employeRecup = new Employer(rs.getString("nomEmploye"), rs.getString("prenomEmploye"),
						rs.getString("adresseEmploye"), rs.getString("TelephoneEmploye"),
						rs.getDate("dateDenaissanceEmploye"), rs.getString("EmailEmploye"), rs.getString("sexeEmploye"),
						rs.getString("numeroEmploye"), rs.getString("typeEmploye"), rs.getString("loginEmploye"),
						rs.getString("passwordEmploye"), rs.getInt("idAgence"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employeRecup;
	}

	public Employer authentification(String login, String password) {
		Employer employerRecup = null;

		try {
			String sql = "SELECT * FROM employe WHERE loginEmploye=? AND passwordEmploye=?";
			PreparedStatement ps = null;

			ps = con.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = null;

			rs = ps.executeQuery();
			while (rs.next()) {
				int idRecup = rs.getInt("idEmploye");
				String loginRecup = rs.getString("loginEmploye");
				String passwordRecup = rs.getString("passwordEmploye");
				String nomRecup = rs.getString("nomEmploye");
				String prenomRecup = rs.getString("prenomEmploye");
				String typeEmployeRecup = rs.getString("typeEmploye");
				if (password.equals(passwordRecup) && login.equals(loginRecup)) {
					// confirm = true;
					employerRecup = new Employer(nomRecup, prenomRecup, typeEmployeRecup, idRecup);
					break;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return employerRecup;
	}

	public Employer findByEmploye(int idEmploye) {
		Employer employeRecup = null;
		try {
			String sql = "SELECT * FROM employe WHERE numeroEmploye=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idEmploye);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employeRecup = new Employer(rs.getString("nomEmploye"), rs.getString("prenomEmploye"),
						rs.getString("adresseEmploye"), rs.getString("TelephoneEmploye"),
						rs.getDate("dateDenaissanceEmploye"), rs.getString("EmailEmploye"), rs.getString("sexeEmploye"),
						rs.getString("numeroEmploye"), rs.getString("typeEmploye"), rs.getString("loginEmploye"),
						rs.getString("passwordEmploye"), rs.getInt("idAgence"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employeRecup;
	}

}
