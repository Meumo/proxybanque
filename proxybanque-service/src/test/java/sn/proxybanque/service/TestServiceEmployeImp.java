package sn.proxybanque.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import sn.proxybanque.domaine.Employer;

/**
 * Date Janvier 01-2018 # La classe 'TestServiceEmployeImp' est connue pour
 * tester les differentes methodes de la classe 'TestServiceEmployeImp'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestServiceEmployeImp {

	Employer employe = new Employer();
	ServiceEmployerImp serviceEmploye;

	@Before
	public void init() {
		serviceEmploye = Mockito.mock(ServiceEmployerImp.class);
	}

	@Test
	public void testAjouter() {
		serviceEmploye.ajouter(employe);
	}

	@Test
	public void testMisAJour() {
		serviceEmploye.misAJour(employe);
	}

	@Test
	public void testLister() {
		List<Employer> list = serviceEmploye.lister();
		assertNotNull(list);
	}

	@Test
	public void testSupprimer() {
		serviceEmploye.supprimer(employe);
	}

	@Ignore
	@Test
	public void testConsulter() {
		fail("Not yet implemented");
	}

	@Test
	public void testRechercherParNumeroEmployer() {
		Employer employer = serviceEmploye.rechercherParNumeroEmployer("10");
		assertNull(employer);
	}

	@Test
	public void testAuthentification() {
		Employer employer = serviceEmploye.authentification("momo", "momo");
		assertNull(employer);
	}

	@Test
	public void testFindByEmploye() {
		Employer employer = serviceEmploye.findByEmploye(1);
		assertNull(employer);
	}

}
