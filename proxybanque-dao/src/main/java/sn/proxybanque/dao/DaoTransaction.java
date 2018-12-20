package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Transaction;
import sn.proxybanque.utils.MysqlConnection;

public class DaoTransaction {
	Connection con = MysqlConnection.getInstanceConnection();
	IDaoCompteImp compteImp = new IDaoCompteImp();

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

	public void verser(Compte compte, double montcred) {
		double ancienSolde = compte.getSoldeCompte();
		double nouvoSolde = ancienSolde + montcred;
		compte.setSoldeCompte(nouvoSolde);

		compteImp.update(compte);
		System.out.println("Operation reussie! Nouveau solde:" + nouvoSolde);
	}

	public boolean retirer(Compte compte, double montdb) {
		boolean result = false;
		if (compte.getSoldeCompte() > montdb) {
			double ancienSolde = compte.getSoldeCompte();
			double nouvoSolde = ancienSolde - montdb;
			compte.setSoldeCompte(nouvoSolde);

			compteImp.update(compte);
			System.out.println("Operation reussie! Nouveau solde:" + nouvoSolde);
			result = true;
			System.out.println("-----------------");
		} else {
			System.out.println("impossible!! Montant a debiter supperieur au solde");
		}
		return result;
	}

	public void virer(Compte compteDebiteur, Compte compteCrediteur, double montant) {
		boolean isCorrect = this.retirer(compteDebiteur, montant);
		if (isCorrect) {
			compteImp.update(compteDebiteur);

			this.verser(compteCrediteur, montant);

			compteImp.update(compteCrediteur);

			System.out.println("Operation de virement reussie!!");
		} else {
			System.out.println("Operation Impossible!!");
		}
	}
}
