package sn.proxybanque.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.Assert;
import sn.proxybanque.domaine.Carte;

/**
 * Date Janvier 01-2018 # La classe 'TestServiceCarteImp' est connue pour tester
 * les differentes methodes de la classe 'TestServiceCarteImp'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestServiceCarteImp {

	Carte carte = new Carte();
	ServiceCarteImp serviceCarte;

	@Before
	public void init() {
		serviceCarte = Mockito.mock(ServiceCarteImp.class);
	}

	@Test
	public void testAjouter() {
		serviceCarte.ajouter(carte);
	}

	@Test
	public void testMisAJour() {
		serviceCarte.misAJour(carte);
	}

	@Test
	public void testLister() {
		List<Carte> list = serviceCarte.lister();
		assertNotNull(list);
	}

	@Test
	public void testSupprimer() {
		serviceCarte.supprimer(carte);
	}

	@Ignore
	@Test
	public void testConsulter() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDisactiverCarte() {
		fail("Not yet implemented");
	}

	@Test
	public void testRechercherParNumeroCarte() {
		Carte carte = serviceCarte.rechercherParNumeroCarte("0123 4567 8901 2047");
		assertNull(carte);
	}

	@Test
	public void testNbreCarte() {
		List<Carte> list = serviceCarte.nbreCarte(6);
		Assert.assertNotNull(list);
	}

}
