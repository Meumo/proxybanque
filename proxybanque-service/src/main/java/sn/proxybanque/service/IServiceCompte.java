package sn.proxybanque.service;

import java.util.List;

import sn.proxybanque.domaine.Compte;

public interface IServiceCompte extends IServiceGenerique<Compte> {
	public Compte rechercherParNumeroCompte(String NumeroCompte);
	public boolean auditer(Compte compte);
	public List<Compte> nbreCompte(int idClient);
}
