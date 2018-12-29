package sn.proxybanque.service;

import sn.proxybanque.dao.DaoAudit;

public class ServiceAudit {

	DaoAudit audit = new DaoAudit();

	public boolean analyseCompte(String numeroCompte) {
		return audit.analyzeCompte(numeroCompte);
	}
}
