package sn.proxybanque.domaine;

import java.util.Date;

/**
 * Date Decembre 05-2018 # la classe Employer gere les etats d'un Employer dans
 * notre application.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @since 2018
 * @version 1.0-SNAPSHOT
 */
public class Employer extends Personne {
	/**
	 * Numero de l'employe
	 */
	private String numeroEmploye;
	/**
	 * Type de l'employe
	 */
	private String typeEmploye;
	/**
	 * Login de l'employe
	 */
	private String loginEmploye;
	/**
	 * Mot de passe de l'employe
	 */
	private String passwordEmploye;
	/**
	 * Identfiant de l'agence dans la classe l'Employe
	 */
	private int idAgence;

	/**
	 * Constructeur avec arguments
	 */
	public Employer(int id,String nom, String prenom, String adresse, String telephone, Date dateDenaissonce, String email,
			String sexe, String numeroEmploye, String typeEmploye, String loginEmploye, String passwordEmploye,
			int idAgence) {
		super(id,nom, prenom, adresse, telephone, dateDenaissonce, email, sexe);
		this.numeroEmploye = numeroEmploye;
		this.typeEmploye = typeEmploye;
		this.loginEmploye = loginEmploye;
		this.passwordEmploye = passwordEmploye;
		this.idAgence = idAgence;
	}
	
	public Employer(String nom, String prenom, String adresse, String telephone, Date dateDenaissonce, String email,
			String sexe, String numeroEmploye, String typeEmploye, String loginEmploye, String passwordEmploye,
			int idAgence) {
		super(nom, prenom, adresse, telephone, dateDenaissonce, email, sexe);
		this.numeroEmploye = numeroEmploye;
		this.typeEmploye = typeEmploye;
		this.loginEmploye = loginEmploye;
		this.passwordEmploye = passwordEmploye;
		this.idAgence = idAgence;
	}
	

	public Employer(String nom, String prenom, String typeEmploye,int id) {
		super(id,nom, prenom);
		this.typeEmploye = typeEmploye;
	}



	/**
	 * Constructeurs sans argument
	 */
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
