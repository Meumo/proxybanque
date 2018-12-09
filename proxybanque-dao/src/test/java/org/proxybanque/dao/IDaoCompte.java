package org.proxybanque.dao;

import sn.proxybanque.domaine.Compte;


public interface IDaoCompte extends IDaoGenerique<Compte> {
	public Compte findByNumberCompte(String NumberCompte);
	public boolean audit(Compte compte);

}
