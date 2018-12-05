package sn.proxybanque.domaine;

import java.util.Date;


public class Compte {
   private String numeroCompte;
   private double soldeCompte;
   private String typeDeCompte;
   private Date dateOuvertureCompte;
   private int idClient;
   
   public Compte() {
	}
   
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
