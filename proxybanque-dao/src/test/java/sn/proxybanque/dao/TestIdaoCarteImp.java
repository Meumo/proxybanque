package sn.proxybanque.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.Assert;
import sn.proxybanque.domaine.Carte;

/**
 * Date Janvier 01-2018 # La classe 'TestIdaoCarteImp' est connue pour tester les
 * differentes methodes de la classe 'TestIdaoCarteImp'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestIdaoCarteImp {

	Carte carte = new Carte();
	IDaoCarteImp daoCarte;

	@Before
	public void init() {
		daoCarte = Mockito.mock(IDaoCarteImp.class);
	}

	@Test
	public void testCreate() {
		daoCarte.create(carte);
	}

	@Test
	public void testUpdate() {
		daoCarte.update(carte);
	}

	@Test
	public void testRead() {
		List<Carte> list = new ArrayList<Carte>();
		list = daoCarte.read();
		Assert.assertNotNull(list);
	}

	@Test
	public void testDelete() {
		daoCarte.delete(carte);
	}

	@Ignore
	@Test
	public void testDisplay() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void testDisableCarte() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByNumberCarte() {
		Carte carte = daoCarte.findByNumberCarte("0123 4567 8901 2047");
		Assert.assertNull(carte);
	}

	@Test
	public void testNbreCarte() {
		List<Carte> list = daoCarte.nbreCarte(6);
		Assert.assertNotNull(list);
	}

}
