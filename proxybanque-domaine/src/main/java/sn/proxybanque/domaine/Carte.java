package sn.proxybanque.domaine;

import java.util.Date;

/**
 * Date Decembre 05-2018 # la classe Carte gere les etats d'une carte dans notre
 * application.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @since 2018
 * @version 1.0-SNAPSHOT
 */
public class Carte {
	/**
	 * Numero carte banquaire
	 */
	private String numeroCarte;
	/**
	 * Type de carte banquaire
	 */
	private String typeCarte;
	/**
	 * Code secret carte banquaire
	 */
	private String codeSecretCarte;
	/**
	 * Date expiration carte banquaire
	 */
	private Date dateExpirationCarte;
	/**
	 * Identifiant d'un client dans la classe carte
	 */
	private int idClient;

	/**
	 * Constructeur sans atgument
	 */
	public Carte() {

	}

	/**
	 * Constructeur avec arguments
	 */
	public Carte(String numeroCarte, String typeCarte, String codeSecretCarte, Date dateExpirationCarte, int idClient) {
		super();
		this.numeroCarte = numeroCarte;
		this.typeCarte = typeCarte;
		this.codeSecretCarte = codeSecretCarte;
		this.dateExpirationCarte = dateExpirationCarte;
		this.idClient = idClient;
	}

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public String getCodeSecretCarte() {
		return codeSecretCarte;
	}

	public Date getDateExpirationCarte() {
		return dateExpirationCarte;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public void setCodeSecretCarte(String codeSecretCarte) {
		this.codeSecretCarte = codeSecretCarte;
	}

	public void setDateExpirationCarte(Date dateExpirationCarte) {
		this.dateExpirationCarte = dateExpirationCarte;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

}
