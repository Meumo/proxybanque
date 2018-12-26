package sn.proxybanque.domaine;

import java.util.Date;

/**
 * Date Decembre 05-2018 # la classe Log gere les etats d'une log dans notre
 * application.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @since 2018
 * @version 1.0-SNAPSHOT
 */
public class Log {
	/**
	 * Numero de la transaction
	 */
	private String numeroTransaction;
	/**
	 * Montant de la transaction
	 */
	private double montantTransaction;
	/**
	 * Date de la transaction
	 */
	private Date dateTransaction;
	/**
	 * Type de la transaction
	 */
	private String typeTransaction;
	/**
	 * Numero du compte
	 */
	private String numeroCompte;
	/**
	 * Identifiant du conseiller
	 */
	private int idConseiller;

	private Log() {
		super();
	}

	/**
	 * Constructeur avec arguments
	 * 
	 * @param numeroTransaction
	 *            Numero transaction
	 * @param montantTransaction
	 *            Montant transaction
	 * @param dateTransaction
	 *            Date transaction
	 * @param typeTransaction
	 *            Type transaction
	 * @param numeroCompte
	 *            Numero compte
	 * @param idConseiller
	 *            Identifiant conseiller
	 */
	private Log(String numeroTransaction, double montantTransaction, Date dateTransaction, String typeTransaction,
			String numeroCompte, int idConseiller) {
		super();
		this.numeroTransaction = numeroTransaction;
		this.montantTransaction = montantTransaction;
		this.dateTransaction = dateTransaction;
		this.typeTransaction = typeTransaction;
		this.numeroCompte = numeroCompte;
		this.idConseiller = idConseiller;
	}

	public String getNumeroTransaction() {
		return numeroTransaction;
	}

	public void setNumeroTransaction(String numeroTransaction) {
		this.numeroTransaction = numeroTransaction;
	}

	public double getMontantTransaction() {
		return montantTransaction;
	}

	public void setMontantTransaction(double montantTransaction) {
		this.montantTransaction = montantTransaction;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public String getTypeTransaction() {
		return typeTransaction;
	}

	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

}
