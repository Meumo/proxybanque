package sn.proxybanque.service;

import java.util.List;

import sn.proxybanque.dao.DaoAudit;
import sn.proxybanque.domaine.Transaction;

/**
 * Date Decembre 20-2018 # La classe 'ServiceAudit' c'est une classe qui nous permet
 * danalyser et lister les transactions non recommandees.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 */
public class ServiceAudit {

	DaoAudit audit = new DaoAudit();

	public boolean analyseCompte(String numeroCompte) {
		return audit.analyzeCompte(numeroCompte);
	}
	public List<Transaction> listeTransactionNonRecommandee(){
		return audit.listeTransactionNonRecommandee();
	}
}
