package sn.proxybanque.service;

import sn.proxybanque.domaine.Carte;


public interface IServiceCarte extends IServiceGenerique<Carte>{
	public boolean disactiverCarte(Carte carte);
	public Carte rechercherParNumeroCarte (String NumberCarte);
}
