package sn.proxybanque.service;

import java.util.List;

import sn.proxybanque.dao.DaoTransaction;
import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Transaction;

/**
 * Date Decembre 20-2018 # La classe 'ServiceTransaction' c'est une classe qui
 * nous permet d'effectuer les operations (debiter et crediter) et inserer une
 * transaction dans notre base de donnees.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 */
public class ServiceTransaction {
	DaoTransaction daoTransaction = new DaoTransaction();

	public void create(Transaction t) {
		daoTransaction.create(t);
	}

	public void verser(Compte compte, double montcred) {
		daoTransaction.verser(compte, montcred);
	}

	public boolean retirer(Compte compte, double montdb) {
		return daoTransaction.retirer(compte, montdb);
	}

	public void virer(Compte compteDebiteur, Compte compteCrediteur, double montant) {
		daoTransaction.virer(compteDebiteur, compteCrediteur, montant);
	}

	public List<Transaction> nbreTransaction(int idCompte) {
		return daoTransaction.nbreTransaction(idCompte);
	}
	
	public void delete(Transaction transaction) {
		daoTransaction.delete(transaction);
	}
	
	public double simulateur(double montantEmprunt, double tauxAnnuel, double dureeEmpruntMois) {
		return daoTransaction.simulateur(montantEmprunt, tauxAnnuel, dureeEmpruntMois);
	}
}
