package sn.proxybanque.service;

import sn.proxybanque.domaine.Employer;

/**
 * Date Decembre 20-2018 # L'interface 'IServiceEmployer' c'est une interface qui
 * etend notre interface generique IServiceGenerique.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @see IServiceGenerique
 */
public interface IServiceEmployer extends IServiceGenerique<Employer> {
	/**
	 * La methode 'rechercherParNumeroEmployer(String numeroEmployer)' a pour but de
	 * chercher un employe et de le retourner
	 * 
	 * @param numeroEmployer
	 *            Parametre de type String
	 * @return Employer parametre de type Employer
	 */
	public Employer rechercherParNumeroEmployer(String numeroEmployer);
	/**
	 * la methode 'authentification(Strinng login,String password)' a pour but
	 * d'authentifier les employes qui se connectent dans notre application.
	 * 
	 * @param login
	 *            parametre de type String
	 * @param password
	 *            parametre de type String
	 * @return Employe
	 */
	public Employer authentification(String login,String password);
}
