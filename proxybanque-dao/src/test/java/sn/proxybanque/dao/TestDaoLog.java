package sn.proxybanque.dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sn.proxybanque.domaine.Log;

/**
 * Date Janvier 01-2018 # La classe 'TestDaoLog' est connue pour tester les
 * differentes methodes de la classe 'TestDaoLog'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestDaoLog {

	Log log=new Log();
	DaoLog daoLog;
	@Before
	public void init() {
		daoLog = Mockito.mock(DaoLog.class);
	}
	@Test
	public void testCreate() {
		daoLog.create(log);
	}
	
	@Test
	public void testDelete() {
		daoLog.delete(log);
	}
}
