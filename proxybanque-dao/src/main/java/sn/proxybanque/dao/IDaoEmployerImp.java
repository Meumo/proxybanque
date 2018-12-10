package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import sn.proxybanque.domaine.Employer;
import sn.proxybanque.utils.MysqlConnection;

public class IDaoEmployerImp implements IDaoEmployer {

	Connection con = MysqlConnection.getInstanceConnection();

	public void create(Employer t) {
		String sql = "INSERT INTO  employe (numeroEmploye, nomEmploye, prenomEmploye, dateDenaissanceEmploye, TelephoneEmploye, EmailEmploye, loginEmploye, passwordEmploye, adresseEmploye, sexeEmploye, typeEmploye, idAgence) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		creaUp(t, sql);
	}

	private void creaUp(Employer x, String sql) {
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getNumeroEmploye());
			ps.setString(2, x.getNom());
			ps.setString(3, x.getPrenom());
			ps.setDate(4, (Date) x.getDateDenaissonce());
			ps.setString(5, x.getTelephone());
			ps.setString(6, x.getEmail());
			ps.setString(7, x.getLoginEmploye());
			ps.setString(8, x.getPasswordEmploye());
			ps.setString(9, x.getAdresse());
			ps.setString(10, x.getSexe());
			ps.setString(11, x.getTypeEmploye());
			ps.setInt(13, x.getIdAgence());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Employer t) {
		String sql="UPDATE employe SET nomEmploye=?,prenomEmploye=?,dateDenaissanceEmploye=?,TelephoneEmploye=?,EmailEmploye=?,loginEmploye=?,passwordEmploye=?,adresseEmploye=?,sexeEmploye=?,typeEmploye=?,idAgence=? WHERE numeroEmploye=?";
		creaUp(t, sql);
	}

	public List<Employer> read() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Employer t) {
		// TODO Auto-generated method stub

	}

	public void display(Employer t) {

	}

	public Employer findByNumberEmployer(String numberEmployer) {
		return null;
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

}
