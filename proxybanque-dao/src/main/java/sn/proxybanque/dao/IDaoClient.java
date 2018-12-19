package sn.proxybanque.dao;

import sn.proxybanque.domaine.Client;

/**
 * Date Decembre 18-2018 # L'interface 'IDaoClient' c'est une interface qui
 * etend notre interface generique IDaoGenerique.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @see IDaoGenerique
 */
public interface IDaoClient extends IDaoGenerique<Client> {

	/**
	 * La methode 'findByNumberClient(String numberClient)' a pour but de chercher
	 * un client a partir de son numero et de le retourner.
	 * 
	 * @param numberClient
	 *            Parametre de String
	 * @return Client
	 */
	public Client findByNumberClient(String numberClient);
}
