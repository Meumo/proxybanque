package sn.proxybanque.domaine;

import java.util.Date;

public class Agence {
   private String numeroAgence;
   private Date ateDeCreationAgence;
   
   public Agence() {
		
	}

public Agence(String numeroAgence, Date ateDeCreationAgence) {
	super();
	this.numeroAgence = numeroAgence;
	this.ateDeCreationAgence = ateDeCreationAgence;
}


public String getNumeroAgence() {
	return numeroAgence;
}

public Date getAteDeCreationAgence() {
	return ateDeCreationAgence;
}

public void setNumeroAgence(String numeroAgence) {
	this.numeroAgence = numeroAgence;
}

public void setAteDeCreationAgence(Date ateDeCreationAgence) {
	this.ateDeCreationAgence = ateDeCreationAgence;
}
   

}
