package sn.proxybanque.dao;

import java.util.List;

public interface IDaoGenerique <T> {
	public void create(T t);
	public void update(T t);
	public List<T> read();
	public void delete(T t);
	public void display(T t);

}
