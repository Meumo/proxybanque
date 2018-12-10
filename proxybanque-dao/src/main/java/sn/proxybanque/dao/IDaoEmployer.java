package sn.proxybanque.dao;


import sn.proxybanque.domaine.Employer;

public interface IDaoEmployer extends IDaoGenerique<Employer>{
	public Employer findByNumberEmployer(String numberEmployer);
	public Employer authentification(String login,String password);

}
