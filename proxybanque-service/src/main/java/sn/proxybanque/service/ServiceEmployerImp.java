package sn.proxybanque.service;

import java.util.List;


import sn.proxybanque.dao.IDaoEmployerImp;
import sn.proxybanque.domaine.Employer;

public class ServiceEmployerImp implements IServiceEmployer {
    IDaoEmployerImp iDaoEmployerImp=new IDaoEmployerImp();
    		
    		
    		
	public void ajouter(Employer t) {
		// TODO Auto-generated method stub
		
	}

	public void misAJour(Employer t) {
		// TODO Auto-generated method stub
		
	}

	public List<Employer> lister() {
		// TODO Auto-generated method stub
		return null;
	}

	public void supprimer(Employer t) {
		// TODO Auto-generated method stub
		
	}

	public void Consulter(Employer t) {
		// TODO Auto-generated method stub
		
	}

	public Employer rechercherParNumeroEmployer(String numeroEmployer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employer authentification(String login, String password) {
		return iDaoEmployerImp.authentification(login, password);
	}

}
