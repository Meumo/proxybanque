package sn.proxybanque.service;

import sn.proxybanque.dao.DaoLog;
import sn.proxybanque.domaine.Log;

/**
 * Date Decembre 26-2018 # La classe 'ServiceLog' c'est une classe qui nous
 * permet d'effectuer les log des transactions dans notre base de donnees.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 */
public class ServiceLog {
	DaoLog daoLog = new DaoLog();

	public void creer(Log log) {
		daoLog.create(log);
	}

	public void delete(Log log) {
		daoLog.delete(log);
	}
}
