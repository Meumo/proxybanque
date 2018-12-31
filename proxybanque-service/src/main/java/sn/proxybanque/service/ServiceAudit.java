package sn.proxybanque.service;

import java.util.List;

import sn.proxybanque.dao.DaoAudit;
import sn.proxybanque.domaine.Transaction;

public class ServiceAudit {

	DaoAudit audit = new DaoAudit();

	public boolean analyseCompte(String numeroCompte) {
		return audit.analyzeCompte(numeroCompte);
	}
	public List<Transaction> listeTransactionNonRecommandee(){
		return audit.listeTransactionNonRecommandee();
	}
}
