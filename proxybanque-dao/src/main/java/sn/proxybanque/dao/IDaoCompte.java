package sn.proxybanque.dao;

import java.util.List;

import sn.proxybanque.domaine.Compte;


public interface IDaoCompte extends IDaoGenerique<Compte> {
	public Compte findByNumberCompte(String NumberCompte);
	public boolean audit(Compte compte);
	public List<Compte> nbreCompte(int idClient);

}
