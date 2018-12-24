package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Transaction;
import sn.proxybanque.utils.MysqlConnection;

/**
 * Date Decembre 20-2018 # La classe 'DaoTransaction' c'est une classe qui nous
 * permet d'effectuer les operations (debiter et crediter) et inserer une
 * transaction dans notre base de donnees.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 */
public class DaoTransaction {
	Connection con = MysqlConnection.getInstanceConnection();
	IDaoCompteImp compteImp = new IDaoCompteImp();

	/**
	 * La methode 'create(Transaction t)' recoit une transaction et l'insere dans la
	 * base de donnees.
	 * 
	 * @param t
	 *            De la methode de type 'Transaction'
	 */
	public void create(Transaction t) {
		String sql = "INSERT INTO transaction(numeroTransaction, montantTransaction, dateTransaction, typeTransaction, idCompte, idConseiller) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getNumeroTransaction());
			ps.setDouble(2, t.getMontantTransaction());
			java.sql.Date date_sql = new java.sql.Date(t.getDateTransaction().getTime());
			ps.setDate(3, date_sql);
			ps.setString(4, t.getTypeTransaction());
			ps.setInt(5, t.getIdcompte());
			ps.setInt(6, t.getIdconseiller());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * La methode 'verser(Compte compte, double montcred)' qui permet d'effectuer un
	 * versement d'un montant dans un compte.
	 * 
	 * @param compte
	 *            de type 'Compte'
	 * @param montcred
	 *            de type 'double'
	 */
	public void verser(Compte compte, double montcred) {

		if (compte.getTypeDeCompte().equals("Epargne")) {
			double interet = montcred * 0.03;
			double ancienSolde = compte.getSoldeCompte();
			double nouvoSolde = ancienSolde + montcred + interet;
			compte.setSoldeCompte(nouvoSolde);
			compteImp.update(compte);
		} else {
			double ancienSolde = compte.getSoldeCompte();
			double nouvoSolde = ancienSolde + montcred;
			compte.setSoldeCompte(nouvoSolde);
			compteImp.update(compte);
		}

	}

	/**
	 * La methode 'retirer(Compte compte, double montdb)' qui permet d'effectuer un
	 * retrait d'un montant d'un compte.'
	 * 
	 * @param compte
	 *            de type 'Compte'
	 * @param montdb
	 *            de type 'double'
	 * @return true si l'operation a reussi et false daans le cas contraire
	 */
	public boolean retirer(Compte compte, double montdb) {
		boolean result = false;
		if (compte.getTypeDeCompte().equals("Courant")) {
			if (compte.getSoldeCompte() + compte.getCaracteristique() != 0
					&& compte.getSoldeCompte() + compte.getCaracteristique() > 0) {
				double ancienSolde = compte.getSoldeCompte();
				double nouvoSolde = ancienSolde - montdb;
				compte.setSoldeCompte(nouvoSolde);

				compteImp.update(compte);
				result = true;
				System.out.println("-----------------");
			} else {
			}
		} else {
			if (compte.getSoldeCompte() > montdb) {

				double ancienSolde = compte.getSoldeCompte();
				double nouvoSolde = ancienSolde - montdb;
				compte.setSoldeCompte(nouvoSolde);
				result = true;
				System.out.println("-----------------");
			} else {
			}
		}
		return result;
	}

	/**
	 * La methode 'virer(Compte compteDebiteur, Compte compteCrediteur, double
	 * montant)' qui permet d'effectuer un virement d'un compte vers un autre.
	 * 
	 * @param compteDebiteur
	 *            de type 'double'
	 * @param compteCrediteur
	 *            de type 'double'
	 * @param montant
	 *            de type 'double'
	 */
	public void virer(Compte compteDebiteur, Compte compteCrediteur, double montant) {
		boolean isCorrect = this.retirer(compteDebiteur, montant);
		if (isCorrect) {
			compteImp.update(compteDebiteur);

			this.verser(compteCrediteur, montant);

			compteImp.update(compteCrediteur);
		} else {
			System.out.println("Operation Impossible!!");
		}
	}

	/**
	 * Cette methode recoit l'identifiant d'un compte et renvoie la liste des
	 * transactions effectuees sur ce compte.
	 * 
	 * @param idCompte
	 *            Idenfiant d'un compte
	 * @return La liste des transactions
	 */
	public List<Transaction> nbreTransaction(int idCompte) {
		List<Transaction> listTransaction = new ArrayList<Transaction>();
		try {
			String sql = "SELECT * FROM transaction WHERE idCompte=idCompte";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Transaction transaction = new Transaction();

				transaction.setNumeroTransaction(rs.getString("numeroTransaction"));
				transaction.setMontantTransaction(rs.getDouble("montantTransaction"));
				transaction.setDateTransaction(rs.getDate("dateTransaction"));
				transaction.setTypeTransaction(rs.getString("typeTransactin"));
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
