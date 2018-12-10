package sn.proxybanque.service;

import java.util.List;

import sn.proxybanque.dao.IDaoEmployerImp;
import sn.proxybanque.domaine.Employer;

public class ServiceEmployerImp implements IServiceEmployer {
	IDaoEmployerImp iDaoEmployerImp = new IDaoEmployerImp();

	public void ajouter(Employer t) {
		iDaoEmployerImp.create(t);

	}

	public void misAJour(Employer t) {
		iDaoEmployerImp.update(t);
	}

	public List<Employer> lister() {
		return iDaoEmployerImp.read();
	}

	public void supprimer(Employer t) {
		iDaoEmployerImp.delete(t);
	}

	public void Consulter(Employer t) {
		iDaoEmployerImp.display(t);
	}

	public Employer rechercherParNumeroEmployer(String numeroEmployer) {
		return iDaoEmployerImp.findByNumberEmployer(numeroEmployer);
	}

	public Employer authentification(String login, String password) {
		return iDaoEmployerImp.authentification(login, password);
	}

}
