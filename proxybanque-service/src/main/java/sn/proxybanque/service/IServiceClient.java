package sn.proxybanque.service;

import sn.proxybanque.domaine.Client;

public interface IServiceClient extends IServiceGenerique<Client>{
	public Client rechercherParNumeroClient(String numeroClient);
}
