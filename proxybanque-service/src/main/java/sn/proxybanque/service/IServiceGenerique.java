package sn.proxybanque.service;

import java.util.List;

public interface IServiceGenerique <T>{
	public void ajouter(T t);
	public void misAJour(T t);
	public List<T> lister();
	public void supprimer(T t);
	public void Consulter(T t);

}
