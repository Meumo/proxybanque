package sn.proxybanque.domaine;

import java.util.Date;

/**
 * Date Decembre 05-2018 # la classe Compte gere les etats d'un Compte dans
 * notre application.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @since 2018
 * @version 1.0-SNAPSHOT
 */
public class Compte {
	/**
	 * Numero d'un compte
	 */
	private String numeroCompte;
	/**
	 * Solde d'un compte
	 */
	private double soldeCompte;
	/**
	 * Type de compte
	 */
	private String typeDeCompte;
	/**
	 * Date ouverture d'un compte
	 */
	private Date dateOuvertureCompte;
	/**
	 * Identifiant d'un Client dans la classe compte
	 */
	private int idClient;

	/**
	 * Constructeur sans arguments
	 */
	public Compte() {
	}

	/**
	 * Constructeur avec arguments
	 */
	public Compte(String numeroCompte, double soldeCompte, String typeDeCompte, Date dateOuvetureCompte, int idClient) {
		super();
		this.numeroCompte = numeroCompte;
		this.soldeCompte = soldeCompte;
		this.typeDeCompte = typeDeCompte;
		this.dateOuvertureCompte = dateOuvetureCompte;
		this.idClient = idClient;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public double getSoldeCompte() {
		return soldeCompte;
	}

	public String getTypeDeCompte() {
		return typeDeCompte;
	}

	public Date getDateOuvetureCompte() {
		return dateOuvertureCompte;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public void setTypeDeCompte(String typeDeCompte) {
		this.typeDeCompte = typeDeCompte;
	}

	public void setDateOuvetureCompte(Date dateOuvetureCompte) {
		this.dateOuvertureCompte = dateOuvetureCompte;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

}
