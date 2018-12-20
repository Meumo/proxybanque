package sn.proxybanque.service;

import java.util.List;

import sn.proxybanque.dao.IDaoCompteImp;
import sn.proxybanque.domaine.Compte;

/**
 * Date Decembre 20-2018 # La classe 'ServiceCompteImp' c'est une classe qui
 * etend notre interface 'IServiceCompte'.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @see IServiceCompte
 */
public class ServiceCompteImp implements IServiceCompte {
	IDaoCompteImp compteImp = new IDaoCompteImp();

	public void ajouter(Compte t) {
		compteImp.create(t);
	}

	public void misAJour(Compte t) {
		compteImp.update(t);
	}

	public List<Compte> lister() {

		return compteImp.read();
	}

	public void supprimer(Compte t) {
		compteImp.delete(t);
	}

	public void Consulter(Compte t) {
		compteImp.display(t);
	}

	public Compte rechercherParNumeroCompte(String numeroCompte) {
		return compteImp.findByNumberCompte(numeroCompte);
	}

	public boolean auditer(Compte compte) {
		return compteImp.audit(compte);
	}

	public List<Compte> nbreCompte(int idClient) {
		return compteImp.nbreCompte(idClient);
	}

}
