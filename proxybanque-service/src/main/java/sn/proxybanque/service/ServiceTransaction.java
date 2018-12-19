package sn.proxybanque.service;

import sn.proxybanque.dao.DaoTransaction;
import sn.proxybanque.domaine.Compte;

public class ServiceTransaction {
	DaoTransaction daoTransaction = new DaoTransaction();

	public void verser(Compte compte, float montcred) {
		daoTransaction.verser(compte, montcred);
	}

	public boolean retirer(Compte compte, float montdb) {
		return daoTransaction.retirer(compte, montdb);
	}

	public void virer(Compte compteDebiteur, Compte compteCrediteur, float montant) {
		daoTransaction.virer(compteDebiteur, compteCrediteur, montant);
	}
}
