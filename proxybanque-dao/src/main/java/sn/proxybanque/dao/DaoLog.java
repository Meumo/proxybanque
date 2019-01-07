package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sn.proxybanque.domaine.Log;
import sn.proxybanque.utils.MysqlConnection;

/**
 * Date Decembre 26-2018 # La classe 'DaoLog' c'est une classe qui nous permet
 * d'effectuer les log des transactions dans notre base de donnees.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 */
public class DaoLog {
	Connection con = MysqlConnection.getInstanceConnection();
	IDaoCompteImp compteImp = new IDaoCompteImp();

	/**
	 * La methode 'create(Log log)' recoit un log et l'insere dans la base de
	 * donnees.
	 * 
	 * @param log
	 *            De la methode de type 'Log'
	 */
	public void create(Log log) {
		String sql = "INSERT INTO log(numeroTransaction, montantTransaction, dateTransaction, typeTransaction, numeroCompte, idConseiller) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, log.getNumeroTransaction());
			ps.setDouble(2, log.getMontantTransaction());
			java.sql.Date date_sql = new java.sql.Date(log.getDateTransaction().getTime());
			ps.setDate(3, date_sql);
			ps.setString(4, log.getTypeTransaction());
			ps.setString(5, log.getNumeroCompte());
			ps.setInt(6, log.getIdConseiller());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/***La methode 'delete(Log log)' supprime un log.
	 * @param log dy type Log
	 */
	public void delete(Log log) {
		try {
			String sql = "DELETE FROM log WHERE numeroTransaction=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, log.getNumeroTransaction());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
