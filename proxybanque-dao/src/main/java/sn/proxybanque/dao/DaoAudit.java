package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.proxybanque.domaine.Log;
import sn.proxybanque.domaine.Transaction;
import sn.proxybanque.utils.MysqlConnection;

/**
 * Date Decembre 20-2018 # La classe 'DaoAudit' c'est une classe qui nous permet
 * danalyser et lister les transactions non recommandees.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 */
public class DaoAudit {
	Connection con = MysqlConnection.getInstanceConnection();

	/**
	 * La methode 'analyzeCompte(String numeroCompte)' recoit le numero d'un compte
	 * et analyse le compte associe a cet numero.
	 * 
	 * @param numeroCompte
	 *            numero d'n compte
	 * @return boolean true or false
	 */
	public boolean analyzeCompte(String numeroCompte) {
		boolean ok = true;

		try {
			String sql = "SELECT * FROM log WHERE montantTransaction >? and typeTransaction LIKE ?";
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

	/**
	 * La methode 'listeTransactionNonRecommandee()' retourne la liste des
	 * transactions non recommandees dans notre systeme.
	 * 
	 * @return liste de transaction
	 */
public List<Log> listeTransactionNonRecommandee() { 
	List<Log> listTransaction = new ArrayList<Log>();
		try {
			String sql = "SELECT * FROM log WHERE montantTransaction > ? and typeTransaction LIKE ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, 3000000);
			ps.setString(2, "Retrait");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Log transaction = new Log();
				transaction.setNumeroTransaction(rs.getString("numeroTransaction"));
				transaction.setMontantTransaction(rs.getDouble("montantTransaction"));
				transaction.setDateTransaction(rs.getDate("dateTransaction"));
				transaction.setTypeTransaction(rs.getString("typeTransaction"));
				transaction.setNumeroCompte(rs.getString("numeroCompte"));
				transaction.setIdConseiller(rs.getShort("idConseiller"));
				listTransaction.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTransaction;
	}
}
