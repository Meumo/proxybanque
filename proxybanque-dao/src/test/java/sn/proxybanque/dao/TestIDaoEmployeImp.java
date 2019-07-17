package sn.proxybanque.dao;

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
 * Date Janvier 01-2018 # La classe 'TestIDaoEmployeImp' est connue pour tester les
 * differentes methodes de la classe 'TestIDaoEmployeImp'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestIDaoEmployeImp {

	Employer employe = new Employer();
	IDaoEmployerImp daoEmploye;

	@Before
	public void init() {
		daoEmploye = Mockito.mock(IDaoEmployerImp.class);
	}

	@Test
	public void testCreate() {
		daoEmploye.create(employe);
	}

	@Test
	public void testUpdate() {
		daoEmploye.update(employe);
	}

	@Test
	public void testRead() {
		List<Employer> list = daoEmploye.read();
		assertNotNull(list);
	}

	@Test
	public void testDelete() {
		daoEmploye.delete(employe);
	}

	@Ignore
	@Test
	public void testDisplay() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByNumberEmployer() {
		Employer employer = daoEmploye.findByNumberEmployer("10");
		assertNull(employer);
	}

	@Test
	public void testAuthentification() {
		Employer employer = daoEmploye.authentification("momo", "momo");
		assertNull(employer);
	}

	@Test
	public void testFindByEmploye() {
		Employer employer = daoEmploye.findByEmploye(1);
		assertNull(employer);
	}

}
