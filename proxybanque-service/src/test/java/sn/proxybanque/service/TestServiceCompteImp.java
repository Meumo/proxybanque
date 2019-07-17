package sn.proxybanque.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import sn.proxybanque.domaine.Compte;

/**
 * Date Janvier 01-2018 # La classe 'TestServiceCompteImp' est connue pour
 * tester les differentes methodes de la classe 'TestServiceCompteImp'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestServiceCompteImp {

	Compte compte = new Compte();
	ServiceCompteImp serviceCompte;

	@Before
	public void init() {
		serviceCompte = Mockito.mock(ServiceCompteImp.class);
	}

	@Test
	public void testAjouter() {
		serviceCompte.ajouter(compte);
	}

	@Test
	public void testMisAJour() {
		serviceCompte.misAJour(compte);
	}

	@Test
	public void testLister() {
		List<Compte> list = serviceCompte.lister();
		assertNotNull(list);
	}

	@Test
	public void testSupprimer() {
		serviceCompte.supprimer(compte);
	}

	@Ignore
	@Test
	public void testConsulter() {
		fail("Not yet implemented");
	}

	@Test
	public void testRechercherParNumeroCompte() {
		Compte compte = serviceCompte.rechercherParNumeroCompte("1098 7654 3210 1036");
		assertNull(compte);
	}

	@Ignore
	@Test
	public void testAuditer() {
		fail("Not yet implemented");
	}

	@Test
	public void testNbreCompte() {
		List<Compte> list = serviceCompte.nbreCompte(6);
		assertNotNull(list);
	}

}
