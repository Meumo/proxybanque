package sn.proxybanque.presentation;

import sn.proxybanque.dao.DaoTransaction;

public class Test {

	public static void main(String[] args) {
		DaoTransaction daoTransaction=new DaoTransaction();
		System.out.println(daoTransaction.simulateur(500000, 10));
	}
}