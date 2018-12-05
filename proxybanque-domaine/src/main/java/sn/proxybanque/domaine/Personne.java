package sn.proxybanque.domaine;

import java.util.Date;

public class Personne {
  
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String telephone;
	protected Date dateDenaissonce;
	protected String email;
	protected char sexe;
	public Personne() {	
	}
	public Personne(String nom, String prenom, String adresse, String telephone, Date dateDenaissonce,String email ,char sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateDenaissonce = dateDenaissonce;
		this.email=email;
		this.sexe = sexe;
	}
	
	
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	
	public String getEmail() {
		return email;
	}
	public Date getDateDenaissonce() {
		return dateDenaissonce;
	}
	public char getSexe() {
		return sexe;
	}
	
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setDateDenaissonce(Date dateDenaissonce) {
		this.dateDenaissonce = dateDenaissonce;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
