package sn.proxybanque.dao;

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
 * Date Janvier 01-2018 # La classe 'TestDaoClientImp' est connue pour tester
 * les differentes methodes de la classe 'TestDaoClientImp'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestDaoClientImp {

	Client client = new Client();
	IDaoClientImp daoClient;

	@Before
	public void init() {
		daoClient = Mockito.mock(IDaoClientImp.class);
	}

	@Test
	public void testCreate() {
		daoClient.create(client);
	}

	@Test
	public void testUpdate() {
		daoClient.update(client);
	}

	@Test
	public void testRead() {
		List<Client> list = daoClient.read();
		assertNotNull(list);
	}

	@Test
	public void testDelete() {
		daoClient.delete(client);
	}

	@Ignore
	@Test
	public void testDisplay() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByNumberClient() {
		Client client = daoClient.findByNumberClient("20085");
		assertNull(client);
	}

	@Test
	public void testFindByIdClient() {
		Client client = daoClient.findByIdClient(6);
		assertNull(client);

	}

}
