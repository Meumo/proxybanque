package sn.proxybanque.dao;

import sn.proxybanque.domaine.Employer;

/**
 * Date Decembre 18-2018 # L'interface 'IDaoEmployer' c'est une interface qui
 * etend notre interface generique IDaoGenerique.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @see IDaoGenerique
 */
public interface IDaoEmployer extends IDaoGenerique<Employer> {
	/**
	 * La methode 'findByNumberEmployer(String NumberEmployer)' a pour but de
	 * chercher un employe et de le retourner
	 * 
	 * @param NumberEmployer
	 *            Parametre de type String
	 * @return Employer parametre de type Employer
	 */
	public Employer findByNumberEmployer(String numberEmployer);

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
	public Employer authentification(String login, String password);

}
