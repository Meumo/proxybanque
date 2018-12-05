package sn.proxybanque.domaine;

import java.util.Date;

public class Employer extends Personne{
	private String numeroEmploye;
	private String typeEmploye;
	private String loginEmploye;
	private String passwordEmploye;
	private int idAgence;
	
	

	public Employer(String nom, String prenom, String adresse, String telephone, Date dateDenaissonce, String email,
			char sexe, String numeroEmploye, String typeEmploye, String loginEmploye, String passwordEmploye,
			int idAgence) {
		super(nom, prenom, adresse, telephone, dateDenaissonce, email, sexe);
		this.numeroEmploye = numeroEmploye;
		this.typeEmploye = typeEmploye;
		this.loginEmploye = loginEmploye;
		this.passwordEmploye = passwordEmploye;
		this.idAgence = idAgence;
	}
	

	public Employer() {
		super();
	}


	public String getNumeroEmploye() {
		return numeroEmploye;
	}

	public String getTypeEmploye() {
		return typeEmploye;
	}

	public String getLoginEmploye() {
		return loginEmploye;
	}

	public String getPasswordEmploye() {
		return passwordEmploye;
	}

	public int getIdAgence() {
		return idAgence;
	}

	public void setNumeroEmploye(String numeroEmploye) {
		this.numeroEmploye = numeroEmploye;
	}

	public void setTypeEmploye(String typeEmploye) {
		this.typeEmploye = typeEmploye;
	}

	public void setLoginEmploye(String loginEmploye) {
		this.loginEmploye = loginEmploye;
	}

	public void setPasswordEmploye(String passwordEmploye) {
		this.passwordEmploye = passwordEmploye;
	}

	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}
	
	
	
	
	

}
