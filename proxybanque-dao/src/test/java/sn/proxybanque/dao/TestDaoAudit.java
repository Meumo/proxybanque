package sn.proxybanque.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sn.proxybanque.domaine.Transaction;

/**
 * Date Janvier 01-2018 # La classe 'TestDaoAudit' est connue pour tester les
 * differentes methodes de la classe 'TestDaoAudit'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestDaoAudit {

	DaoAudit daoAudit;

	@Before
	public void init() {
		daoAudit = Mockito.mock(DaoAudit.class);
	}

	@Test
	public void testAnalyzeCompte() {
		boolean ok = daoAudit.analyzeCompte("1098 7654 3210 1036");
		Assert.assertNotNull(ok);
	}

	@Test
	public void testListeTransactionNonRecommandee() {
		List<Transaction> list = new ArrayList<Transaction>();
		list = daoAudit.listeTransactionNonRecommandee();
		Assert.assertNotNull(list);
	}

}
