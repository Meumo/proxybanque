package sn.proxybanque.dao;

import java.util.List;

import sn.proxybanque.domaine.Compte;

/**
 * Date Decembre 18-2018 # L'interface 'IDaoCompte' c'est une interface qui
 * etend notre interface generique IDaoGenerique.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @see IDaoGenerique
 */
public interface IDaoCompte extends IDaoGenerique<Compte> {
	/**
	 * La methode 'findByNumberCompte(String NumberCompte)' a pour but de chercher
	 * un compte bancaire et de le retourner
	 * 
	 * @param NumberCompte
	 *            Parametre de type String
	 * @return Compte
	 */

	public Compte findByNumberCompte(String NumberCompte);

	/**
	 * La methode 'audit(Compte compte)' a pour but d'auditer un compte et de
	 * retourner un boolean (true=compte ok ou false=compte=non ok)
	 * 
	 * @param compte
	 *            parametrede type compte
	 * @return boolean true or false
	 */
	public boolean audit(Compte compte);
	/**
	 * La methode 'nbreCompte(int idClient)' a pour but de retourner le nombre de
	 * compte que possede le client.
	 * 
	 * @param idClient
	 *            identifiant du client
	 * @return List<Carte> la liste de ces comptes.
	 */
	public List<Compte> nbreCompte(int idClient);

}
