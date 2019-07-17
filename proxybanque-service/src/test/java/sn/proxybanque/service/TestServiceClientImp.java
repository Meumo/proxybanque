package sn.proxybanque.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import sn.proxybanque.domaine.Client;

/**
 * Date Janvier 01-2018 # La classe 'TestServiceClientImp' est connue pour
 * tester les differentes methodes de la classe 'TestServiceClientImp'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestServiceClientImp {

	Client client = new Client();
	ServiceClientImp serviceClient;

	@Before
	public void init() {
		serviceClient = Mockito.mock(ServiceClientImp.class);
	}

	@Test
	public void testAjouter() {
		serviceClient.ajouter(client);
	}

	@Test
	public void testMisAJour() {
		serviceClient.misAJour(client);
	}

	@Test
	public void testLister() {
		List<Client> list = serviceClient.lister();
		assertNotNull(list);
	}

	@Test
	public void testSupprimer() {
		serviceClient.supprimer(client);
	}

	@Ignore
	@Test
	public void testConsulter() {
		fail("Not yet implemented");
	}

	@Test
	public void testRechercherParNumeroClient() {
		Client client = serviceClient.rechercherParNumeroClient("20085");
		assertNull(client);
	}

	@Test
	public void testFindByIdClient() {
		Client client = serviceClient.findByIdClient(6);
		assertNull(client);

	}

}
