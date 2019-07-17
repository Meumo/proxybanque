package sn.proxybanque.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sn.proxybanque.domaine.Log;

/**
 * Date Janvier 01-2018 # La classe 'TestServiceAudit' est connue pour tester
 * les differentes methodes de la classe 'TestServiceAudit'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestServiceAudit {

	ServiceAudit serviceAudit;

	@Before
	public void init() {
		serviceAudit = Mockito.mock(ServiceAudit.class);
	}

	@Test
	public void testAnalyseCompte() {
		boolean ok = serviceAudit.analyseCompte("1098 7654 3210 1036");
		Assert.assertNotNull(ok);
	}

	@Test
	public void testListeTransactionNonRecommandee() {
		List<Log> list = new ArrayList<Log>();
		list = serviceAudit.listeTransactionNonRecommandee();
		Assert.assertNotNull(list);
	}

}
