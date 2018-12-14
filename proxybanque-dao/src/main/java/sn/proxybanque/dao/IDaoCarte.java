package sn.proxybanque.dao;

import java.util.List;

import sn.proxybanque.domaine.Carte;


public interface IDaoCarte extends IDaoGenerique<Carte> {
	public boolean disableCarte(Carte carte);
	public Carte findByNumberCarte(String Numbercarte);
	public List<Carte> nbreCarte(int idClient);
}
