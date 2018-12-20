package sn.proxybanque.service;

import java.util.List;

import sn.proxybanque.dao.IDaoClientImp;
import sn.proxybanque.domaine.Client;
/**
 * Date Decembre 20-2018 # La classe 'ServiceClientImp' c'est une classe qui etend
 * notre classe IServiceClient.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @see IServiceClient
 */
public class ServiceClientImp implements IServiceClient{
IDaoClientImp clientImp=new IDaoClientImp();
	public void ajouter(Client t) {
		clientImp.create(t);		
	}

	public void misAJour(Client t) {
		clientImp.update(t);		
	}

	public List<Client> lister() {
		return clientImp.read();
	}

	public void supprimer(Client t) {
		clientImp.delete(t);		
	}

	public void Consulter(Client t) {
		clientImp.display(t);		
	}

	public Client rechercherParNumeroClient(String numeroClient) {
		return clientImp.findByNumberClient(numeroClient);
	}

}
