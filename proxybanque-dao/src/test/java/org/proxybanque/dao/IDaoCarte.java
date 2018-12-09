package org.proxybanque.dao;

import sn.proxybanque.domaine.Carte;


public interface IDaoCarte extends IDaoGenerique<Carte> {
	public boolean disableCarte(Carte carte);
	public Carte findByNumberCarte(String Numbercarte);

}
