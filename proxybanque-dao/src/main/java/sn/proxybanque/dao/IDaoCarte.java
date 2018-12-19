package sn.proxybanque.dao;

import java.util.List;

import sn.proxybanque.domaine.Carte;

/**
 * Date Decembre 18-2018 # L'interface 'IDaoCarte' c'est une interface qui etend
 * notre interface generique IDaoGenerique.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @see IDaoGenerique
 */
public interface IDaoCarte extends IDaoGenerique<Carte> {
	/**
	 * La methode 'disableCarte()' a pour but de desactiver une carte bancaire.
	 * 
	 * @param carte
	 *
	 *            Parametre de type Carte
	 * @return boolean true si c'est desactivee ou false dans le cas contraire
	 * 
	 */
	public boolean disableCarte(Carte carte);

	/**
	 * La methode 'findByNumberCarte(String Numbercarte)' a pour but de chercher une
	 * carte bancaire et de la retourner
	 * 
	 * @param Numbercarte
	 *            Parametre de typeCarte
	 * @return Carte une carte bancaire
	 */
	public Carte findByNumberCarte(String Numbercarte);

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
