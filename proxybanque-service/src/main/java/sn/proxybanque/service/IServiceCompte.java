package sn.proxybanque.service;

import sn.proxybanque.domaine.Compte;

public interface IServiceCompte extends IServiceGenerique<Compte> {
	public Compte rechercherParNumeroCompte(String NumeroCompte);
	public boolean auditer(Compte compte);

}
