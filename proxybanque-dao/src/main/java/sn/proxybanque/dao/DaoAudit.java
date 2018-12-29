package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sn.proxybanque.utils.MysqlConnection;

public class DaoAudit {
	Connection con = MysqlConnection.getInstanceConnection();

	public boolean analyzeCompte(String numeroCompte) {
		boolean ok = true;

		try {
			String sql = "SELECT * FROM log WHERE numeroCompte=? AND typeTransaction=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, numeroCompte);
			ps.setString(2, "Retrait");
			ResultSet rs = ps.executeQuery();
			while (rs.next() && ok == true) {
				double montantRetrait = rs.getDouble("montantTransaction");
				if (montantRetrait < 3000000) {
					ok = true;
				} else {
					ok = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}
