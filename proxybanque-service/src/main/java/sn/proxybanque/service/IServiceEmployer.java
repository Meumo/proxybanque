package sn.proxybanque.service;

import sn.proxybanque.domaine.Employer;

public interface IServiceEmployer extends IServiceGenerique<Employer> {
	public Employer rechercherParNumeroEmployer(String numeroEmployer);
}
