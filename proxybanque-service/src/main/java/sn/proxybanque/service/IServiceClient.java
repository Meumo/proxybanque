package sn.proxybanque.service;

import sn.proxybanque.domaine.Client;

/**
 * Date Decembre 18-2018 # L'interface 'IServiceClient' c'est une interface qui
 * etend notre interface generique IServiceGenerique.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @see IServiceGenerique.
 */
public interface IServiceClient extends IServiceGenerique<Client> {
	/**
	 * La methode 'rechercherParNumeroClient(String numeroClient)' a pour but de
	 * chercher un client a partir de son numero et de le retourner.
	 * 
	 * @param numeroClient
	 *            Parametre de String
	 * @return Client
	 */
	public Client rechercherParNumeroClient(String numeroClient);
}
