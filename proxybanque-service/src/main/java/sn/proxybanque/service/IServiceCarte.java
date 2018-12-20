package sn.proxybanque.service;

import java.util.List;

import sn.proxybanque.domaine.Carte;

/**
 * Date Decembre 20-2018 # L'interface 'IServiceCarte' c'est une interface qui
 * etend notre interface generique IServiceGenerique.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @see IServiceGenerique
 */
public interface IServiceCarte extends IServiceGenerique<Carte> {

	/**
	 * La methode 'disactiverCarte(Carte carte)' a pour but de desactiver une carte
	 * bancaire.
	 * 
	 * @param carte
	 *
	 *            Parametre de type Carte
	 * @return boolean true si c'est desactivee ou false dans le cas contraire
	 * 
	 */
	public boolean disactiverCarte(Carte carte);

	/**
	 * La methode 'rechercherParNumeroCarte (String NumberCarte)' a pour but de
	 * chercher une carte bancaire et de la retourner
	 * 
	 * @param Numbercarte
	 *            Parametre de typeCarte
	 * @return Carte une carte bancaire
	 */
	public Carte rechercherParNumeroCarte(String NumberCarte);

	/**
	 * La methode 'nbreCarte(int idClient)' a pour but de retourner le nombre de
	 * carte que possede le client.
	 * 
	 * @param idClient
	 *            identifiant du client
	 * @return List<Carte> la liste de ces cartes.
	 */
	public List<Carte> nbreCarte(int idClient);
}
