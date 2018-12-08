package org.proxybanque.dao;


import sn.proxybanque.domaine.Employer;

public interface IDaoEmployer extends IDaoGenerique<Employer>{
	public Employer findByNumberEmployer(String numberEmployer);

}
