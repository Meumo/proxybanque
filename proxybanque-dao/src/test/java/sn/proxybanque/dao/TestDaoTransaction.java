package sn.proxybanque.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sn.proxybanque.domaine.Compte;
import sn.proxybanque.domaine.Transaction;


/**
 * Date Janvier 01-2018 # La classe 'TestDaoTransaction' est connue pour tester les
 * differentes methodes de la classe 'TestDaoTransaction'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestDaoTransaction {
	Transaction transaction = new Transaction();
	Compte compte = new Compte();
	Compte compte2 = new Compte();
	double montant = 100000;
	DaoTransaction daoTransaction;

	@Before
	public void init() {
		daoTransaction = Mockito.mock(DaoTransaction.class);
	}

	@Test
	public void testCreate() {
		daoTransaction.create(transaction);
	}

	@Test
	public void testVerser() {
		daoTransaction.verser(compte, montant);
	}

	@Test
	public void testRetirer() {
		Assert.assertNotNull(daoTransaction.retirer(compte, montant));
	}

	@Test
	public void testVirer() {
		daoTransaction.virer(compte, compte2, montant);
	}

	@Test
	public void testNbreTransaction() {
		List<Transaction> list = new ArrayList<Transaction>();
		list = daoTransaction.nbreTransaction(9);
		Assert.assertNotNull(list);
	}

	@Test
	public void testDelete() {
		daoTransaction.delete(transaction);
	}

}
