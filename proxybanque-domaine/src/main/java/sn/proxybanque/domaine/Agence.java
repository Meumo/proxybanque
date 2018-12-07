package sn.proxybanque.domaine;

import java.util.Date;

/**
 * Date Decembre 05-2018 # la classe Agence gere les etats d'une agence dans
 * notre application.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @since 2018
 * @version 1.0-SNAPSHOT
 */
public class Agence {

	/**
	 * Numero agence
	 */
	private String numeroAgence;
	/**
	 * Date de creation d'une agence
	 */
	private Date dateDeCreationAgence;

	/**
	 * Constructeur sans argument
	 */
	public Agence() {

	}

	/**
	 * Constructeur avec arguments
	 */

	public Agence(String numeroAgence, Date ateDeCreationAgence) {
		super();
		this.numeroAgence = numeroAgence;
		this.dateDeCreationAgence = ateDeCreationAgence;
	}

	public String getNumeroAgence() {
		return numeroAgence;
	}

	public Date getAteDeCreationAgence() {
		return dateDeCreationAgence;
	}

	public void setNumeroAgence(String numeroAgence) {
		this.numeroAgence = numeroAgence;
	}

	public void setAteDeCreationAgence(Date ateDeCreationAgence) {
		this.dateDeCreationAgence = ateDeCreationAgence;
	}

}
