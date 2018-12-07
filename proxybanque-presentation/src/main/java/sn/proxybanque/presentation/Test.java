package sn.proxybanque.presentation;

import sn.proxybanque.service.Numero;

public class Test {

	public static void main(String[] args) {
		Numero numero=new Numero();
		System.out.println(numero.generateNumeroTransaction());
	}
}