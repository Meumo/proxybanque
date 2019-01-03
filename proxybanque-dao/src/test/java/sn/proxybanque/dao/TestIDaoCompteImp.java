package sn.proxybanque.dao;

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
 * Date Janvier 01-2018 # La classe 'TestIDaoCompteImp' est connue pour tester les
 * differentes methodes de la classe 'TestIDaoCompteImp'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestIDaoCompteImp {

	Compte compte = new Compte();
	IDaoCompteImp daoCompte;

	@Before
	public void init() {
		daoCompte = Mockito.mock(IDaoCompteImp.class);
	}

	@Test
	public void testCreate() {
		daoCompte.create(compte);
	}

	@Test
	public void testUpdate() {
		daoCompte.update(compte);
	}

	@Test
	public void testRead() {
		List<Compte> list = daoCompte.read();
		assertNotNull(list);
	}

	@Test
	public void testDelete() {
		daoCompte.delete(compte);
	}

	@Ignore
	@Test
	public void testDisplay() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByNumberCompte() {
		Compte compte = daoCompte.findByNumberCompte("1098 7654 3210 1036");
		assertNull(compte);
	}

	@Ignore
	@Test
	public void testAudit() {
		fail("Not yet implemented");
	}

	@Test
	public void testNbreCompte() {
		List<Compte> list = daoCompte.nbreCompte(6);
		assertNotNull(list);
	}

}
