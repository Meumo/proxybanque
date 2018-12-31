package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.proxybanque.domaine.Transaction;
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

	public List<Transaction> listeTransactionNonRecommandee() {
		List<Transaction> listTransaction = new ArrayList<Transaction>();
		try {
			String sql = "SELECT * FROM transaction WHERE montantTransaction>? AND typeTransaction=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, 3000000);
			ps.setString(2, "Retrait");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction();

				transaction.setNumeroTransaction(rs.getString("numeroTransaction"));
				transaction.setMontantTransaction(rs.getDouble("montantTransaction"));
				transaction.setDateTransaction(rs.getDate("dateTransaction"));
				transaction.setTypeTransaction(rs.getString("typeTransaction"));
				transaction.setIdcompte(rs.getInt("idCompte"));
				transaction.setIdconseiller(rs.getShort("idConseiller"));
				listTransaction.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTransaction;
	}
}
