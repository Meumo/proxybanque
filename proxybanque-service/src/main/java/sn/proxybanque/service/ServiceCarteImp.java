package sn.proxybanque.service;

import java.util.List;

import sn.proxybanque.dao.IDaoCarteImp;
import sn.proxybanque.domaine.Carte;

public class ServiceCarteImp implements IServiceCarte {
	IDaoCarteImp carteImp = new IDaoCarteImp();

	public void ajouter(Carte t) {
		carteImp.create(t);
	}

	public void misAJour(Carte t) {
		carteImp.update(t);
	}

	public List<Carte> lister() {
		return carteImp.read();
	}

	public void supprimer(Carte t) {
		carteImp.delete(t);
	}

	public void Consulter(Carte t) {
		carteImp.display(t);
	}

	public boolean disactiverCarte(Carte carte) {
		return carteImp.disableCarte(carte);
	}

	public Carte rechercherParNumeroCarte(String numberCarte) {
		return carteImp.findByNumberCarte(numberCarte);
	}

	public List<Carte> nbreCarte(int idClient) {
		return carteImp.nbreCarte(idClient);
	}

}
