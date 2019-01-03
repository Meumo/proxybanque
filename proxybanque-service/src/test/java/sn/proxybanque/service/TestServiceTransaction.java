package sn.proxybanque.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Transaction;

/**
 * Date Janvier 01-2018 # La classe 'TestServiceTransaction' est connue pour
 * tester les differentes methodes de la classe 'TestServiceTransaction'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestServiceTransaction {

	Transaction transaction = new Transaction();
	Compte compte = new Compte();
	Compte compte2 = new Compte();
	double montant = 100000;
	ServiceTransaction serviceTransaction;

	@Before
	public void init() {
		serviceTransaction = Mockito.mock(ServiceTransaction.class);
	}

	@Test
	public void testCreate() {
		serviceTransaction.create(transaction);
	}

	@Test
	public void testVerser() {
		serviceTransaction.verser(compte, montant);
	}

	@Test
	public void testRetirer() {
		Assert.assertNotNull(serviceTransaction.retirer(compte, montant));
	}

	@Test
	public void testVirer() {
		serviceTransaction.virer(compte, compte2, montant);
	}

	@Test
	public void testNbreTransaction() {
		List<Transaction> list = new ArrayList<Transaction>();
		list = serviceTransaction.nbreTransaction(9);
		Assert.assertNotNull(list);
	}

	@Test
	public void testDelete() {
		serviceTransaction.delete(transaction);
	}
}
