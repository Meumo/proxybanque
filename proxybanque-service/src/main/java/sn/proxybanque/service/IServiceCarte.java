package sn.proxybanque.service;

import java.util.List;

import sn.proxybanque.domaine.Carte;


public interface IServiceCarte extends IServiceGenerique<Carte>{
	public boolean disactiverCarte(Carte carte);
	public Carte rechercherParNumeroCarte (String NumberCarte);
	public List<Carte> nbreCarte(int idClient);
}
