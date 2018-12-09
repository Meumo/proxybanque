package org.proxybanque.dao;


import sn.proxybanque.domaine.Client;

public interface IDaoClient extends IDaoGenerique<Client>{
	
	public Client findByNumberClient(String numberClient);
}
