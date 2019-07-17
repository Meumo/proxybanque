package sn.proxybanque.service;

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
public class TestServiceLog {

	Log log=new Log();
	ServiceLog serviceLog;
	@Before
	public void init() {
		serviceLog = Mockito.mock(ServiceLog.class);
	}
	@Test
	public void testCreer() {
		serviceLog.creer(log);
	}

	@Test
	public void testDelete() {
		serviceLog.delete(log);
	}

}
