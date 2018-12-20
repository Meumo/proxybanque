package sn.proxybanque.service;

import sn.proxybanque.dao.DaoTransaction;
import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Transaction;

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
}
