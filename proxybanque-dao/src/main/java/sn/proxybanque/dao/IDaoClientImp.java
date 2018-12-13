package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.proxybanque.domaine.Client;
import sn.proxybanque.utils.MysqlConnection;

public class IDaoClientImp implements IDaoClient {
	Connection con = MysqlConnection.getInstanceConnection();

	public void create(Client t) {
		String sql = "INSERT INTO client (numeroClient, nomClient, prenomClient, adresseClient, sexeClient, emailClient, telephoneClient, codePostalClient, professionClient, villeClient, dateDenaissanceClient, idConseiller) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNumeroClient());
			ps.setString(2, t.getNom());
			ps.setString(3, t.getPrenom());
			ps.setString(4, t.getAdresse());
			ps.setString(5, t.getSexe());
			ps.setString(6, t.getEmail());
			ps.setString(7, t.getTelephone());
			ps.setString(8, t.getCodePostalClient());
			ps.setString(9, t.getProfessionClient());
			ps.setString(10, t.getVileClient());
			java.sql.Date date_sql = new java.sql.Date(t.getDateDenaissance().getTime());

			ps.setDate(11, date_sql);
			//ps.setDate(11, (Date) t.getDateDenaissance());
			ps.setDate(11,date_sql);
			ps.setInt(12, t.getIdConseillerClientel());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Client t) {
		String sql = "UPDATE client SET nomClient=?,prenomClient=?,adresseClient=?,sexeClient=?,emailClient=?,telephoneClient=?,codePostalClient=?,professionClient=?,villeClient=?,dateDenaissanceClient=?,idConseiller=? WHERE numeroClient=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getNom());
			ps.setString(2, t.getPrenom());
			ps.setString(3, t.getAdresse());
			ps.setString(4, t.getSexe());
			ps.setString(5, t.getEmail());
			ps.setString(6, t.getTelephone());
			ps.setString(7, t.getCodePostalClient());
			ps.setString(8, t.getProfessionClient());
			ps.setString(9, t.getVileClient());
			java.sql.Date date_sql = new java.sql.Date(t.getDateDenaissance().getTime());
			ps.setDate(10, date_sql);
			ps.setInt(11, t.getIdConseillerClientel());
			ps.setString(12, t.getNumeroClient());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Client> read() {
		List<Client> listClient = new ArrayList<Client>();
		try {
			String sql = "SELECT * FROM client";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Client client = new Client();

				client.setId(rs.getInt("idClient"));
				client.setNumeroClient("numeroClient");
				client.setNom(rs.getString("nomClient"));
				client.setPrenom(rs.getString("prenomClient"));
				client.setAdresse(rs.getString("adresseClient"));
				client.setSexe(rs.getString("sexeClient"));
				client.setEmail(rs.getString("emailClient"));
				client.setTelephone(rs.getString("telephoneClient"));
				client.setCodePostalClient(rs.getString("codePostalClient"));
				client.setProfessionClient(rs.getString("professionClient"));
				client.setVileClient(rs.getString("villeClient"));
				client.setDateDenaissance(rs.getDate("dateDenaissanceClient"));
				client.setIdConseillerClientel(rs.getInt("idConseiller"));

				listClient.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}

	public void delete(Client t) {
		try {
			String sql = "DELETE FROM client WHERE numeroClient=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNumeroClient());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void display(Client t) {
		// TODO Auto-generated method stub

	}

	public Client findByNumberClient(String numberClient) {
		Client clientRecup = null;
		try {
			String sql = "SELECT * FROM client WHERE numeroClient=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, numberClient);
			ResultSet rs = ps.executeQuery();
			
				while (rs.next()) {
					clientRecup = new Client(rs.getInt("idClient"), rs.getString("nomClient"), rs.getString("prenomClient"),
							rs.getString("adresseClient"), rs.getString("telephoneClient"),
							rs.getDate("dateDenaissanceClient"), rs.getString("emailClient"), rs.getString("sexeClient"),
							rs.getString("numeroClient"), rs.getString("codePostalClient"), rs.getString("villeClient"),
							rs.getString("professionClient"), rs.getInt("idConseiller"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		                      
			return clientRecup;
		}
		
}

