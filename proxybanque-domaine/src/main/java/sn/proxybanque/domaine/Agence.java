package sn.proxybanque.domaine;

import java.util.Date;

public class Agence {
   private String numeroAgence;
   private Date dateDeCreationAgence;
   
   public Agence() {
		
	}

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
