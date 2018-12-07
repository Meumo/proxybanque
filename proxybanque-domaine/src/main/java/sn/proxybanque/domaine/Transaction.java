package sn.proxybanque.domaine;

import java.util.Date;

/**
 * Date Decembre 05-2018 # la classe Transaction gere les etats d'une
 * transaction dans notre application.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @since 2018
 * @version 1.0-SNAPSHOT
 */
public class Transaction {

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
	 * Identifiant du compte dans la classe transaction
	 */
	private int idCompte;
	/**
	 * Identifiant du conseiller dans la classe transaction
	 */
	private int idConseiller;

	/**
	 * Constructeur sans argument
	 */
	public Transaction() {

	}

	/**
	 * Constructeur avec argument
	 */
	public Transaction(String numeroTransaction, double montantTransaction, Date dateTransaction,
			String typeTransaction, int idcompte, int idconseiller) {
		super();
		this.numeroTransaction = numeroTransaction;
		this.montantTransaction = montantTransaction;
		this.dateTransaction = dateTransaction;
		this.typeTransaction = typeTransaction;
		this.idCompte = idcompte;
		this.idConseiller = idconseiller;
	}

	public String getNumeroTransaction() {
		return numeroTransaction;
	}

	public double getMontantTransaction() {
		return montantTransaction;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public String getTypeTransaction() {
		return typeTransaction;
	}

	public int getIdcompte() {
		return idCompte;
	}

	public int getIdconseiller() {
		return idConseiller;
	}

	public void setNumeroTransaction(String numeroTransaction) {
		this.numeroTransaction = numeroTransaction;
	}

	public void setMontantTransaction(double montantTransaction) {
		this.montantTransaction = montantTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	public void setIdcompte(int idcompte) {
		this.idCompte = idcompte;
	}

	public void setIdconseiller(int idconseiller) {
		this.idConseiller = idconseiller;
	}

}
