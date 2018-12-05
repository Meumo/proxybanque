package sn.proxybanque.domaine;

import java.util.Date;


public class Transaction {

	private String numeroTransaction;
	private double montantTransaction;
	private Date dateTransaction;
	private String typeTransaction;
	private int  idcompte;
	private int idconseiller;
	
	public Transaction() {
		
	}
	
	public Transaction(String numeroTransaction, double montantTransaction, Date dateTransaction,
			String typeTransaction, int idcompte, int idconseiller) {
		super();
		this.numeroTransaction = numeroTransaction;
		this.montantTransaction = montantTransaction;
		this.dateTransaction = dateTransaction;
		this.typeTransaction = typeTransaction;
		this.idcompte = idcompte;
		this.idconseiller = idconseiller;
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
		return idcompte;
	}
	public int getIdconseiller() {
		return idconseiller;
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
		this.idcompte = idcompte;
	}
	public void setIdconseiller(int idconseiller) {
		this.idconseiller = idconseiller;
	}
	
	
}
