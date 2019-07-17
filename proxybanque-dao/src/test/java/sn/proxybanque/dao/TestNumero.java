package sn.proxybanque.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Date Janvier 01-2018 # La classe 'TestNumero' est connue pour tester les
 * differentes methodes de la classe 'TestNumero'
 * 
 * @author DIOUF Mamadou & Diack Mamadou
 *
 */
public class TestNumero {
	Numero numero = new Numero();

	@Test
	public void testGenerateNumeroCarte() {
		assertNotNull(numero.generateNumeroCarte());
	}

	@Test
	public void testGenerateNumeroCompte() {
		assertNotNull(numero.generateNumeroCompte());
	}

	@Test
	public void testGenerateNumeroAgence() {
		assertNotNull(numero.generateNumeroAgence());
	}

	@Test
	public void testGenerateNumeroClient() {
		assertNotNull(numero.generateNumeroClient());
	}

	@Test
	public void testGenerateNumeroEmploye() {
		assertNotNull(numero.generateNumeroEmploye());
	}

	@Test
	public void testGenerateNumeroTransaction() {
		assertNotNull(numero.generateNumeroTransaction());
	}

}
