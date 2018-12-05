package sn.proxybanque.domaine;

import java.util.Date;

/**
 * Date Decembre 05-2018 # la classe Personne gere les etats d'une Personne dans
 * notre application.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @since 2018
 * @version 1.0-SNAPSHOT
 */
public class Personne {

	/**
	 * Nom
	 */
	protected String nom;
	/**
	 * Prenom
	 */
	protected String prenom;
	/**
	 * Adresse
	 */
	protected String adresse;
	/**
	 * Telephone
	 */
	protected String telephone;
	/**
	 * Date de naissance
	 */
	protected Date dateDenaissance;
	/**
	 * Adresse email
	 */
	protected String email;
	/**
	 * Sexe
	 */
	protected char sexe;

	/**
	 * Constructeur sans argument
	 */
	public Personne() {
	}

	/**
	 * Contructeur avec arguments
	 */
	public Personne(String nom, String prenom, String adresse, String telephone, Date dateDenaissonce, String email,
			char sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateDenaissance = dateDenaissonce;
		this.email = email;
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
		return dateDenaissance;
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
		this.dateDenaissance = dateDenaissonce;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
