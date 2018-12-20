package sn.proxybanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import sn.proxybanque.domaine.Compte;
import sn.proxybanque.utils.MysqlConnection;

public class DaoTransaction {
	Connection con = MysqlConnection.getInstanceConnection();
	Numero numero = new Numero();
	IDaoCompteImp compteImp = new IDaoCompteImp();

	public void verser(Compte compte, double montcred) {
		double ancienSolde = compte.getSoldeCompte();
		double nouvoSolde = ancienSolde + montcred;
		compte.setSoldeCompte(nouvoSolde);

		compteImp.update(compte);
		String sql = "INSERT INTO transaction(numeroTransaction, montantTransaction, dateTransaction, typeTransaction, idCompte, idConseiller) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, numero.generateNumeroTransaction());
			ps.setDouble(2, montcred);
			ps.setString(3, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			ps.setString(4, "Credit");
			ps.setInt(5, compte.getIdCompte());
			ps.setInt(6, 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Operation reussie! Nouveau solde:" + nouvoSolde);
	}

	public boolean retirer(Compte compte, double montdb) {
		boolean result = false;
		if (compte.getSoldeCompte() > montdb) {

			double ancienSolde = compte.getSoldeCompte();
			double nouvoSolde = ancienSolde - montdb;
			compte.setSoldeCompte(nouvoSolde);
			compteImp.update(compte);
			String sql = "INSERT INTO transaction(numeroTransaction, montantTransaction, dateTransaction, typeTransaction, idCompte, idConseiller) VALUES (?,?,?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, numero.generateNumeroTransaction());
				ps.setDouble(2, montdb);
				ps.setString(3, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				ps.setString(4, "Dedit");
				ps.setInt(5, compte.getIdCompte());
				ps.setInt(6, 1);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		String numeroTransaction = numero.generateNumeroTransaction();
		if (isCorrect) {
			compteImp.update(compteDebiteur);
			String sql = "INSERT INTO transaction(numeroTransaction, montantTransaction, dateTransaction, typeTransaction, idCompte, idConseiller) VALUES (?,?,?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, numeroTransaction);
				ps.setDouble(2, -montant);
				ps.setString(3, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				ps.setString(4, "Virement");
				ps.setInt(5, compteDebiteur.getIdCompte());
				ps.setInt(6, 1);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			this.verser(compteCrediteur, montant);
			compteImp.update(compteCrediteur);
			String sql2 = "INSERT INTO transaction(numeroTransaction, montantTransaction, dateTransaction, typeTransaction, idCompte, idConseiller) VALUES (?,?,?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql2);
				ps.setString(1, numeroTransaction);
				ps.setDouble(2, +montant);
				ps.setString(3, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				ps.setString(4, "Virement");
				ps.setInt(5, compteCrediteur.getIdCompte());
				ps.setInt(6, 1);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("Operation de virement reussie!!");
		} else {
			System.out.println("Operation Impossible!!");
		}
	}
}
