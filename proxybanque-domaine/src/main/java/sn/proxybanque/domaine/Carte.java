package sn.proxybanque.domaine;

import java.util.Date;

public class Carte {
    private String numeroCarte;
    private String typeCarte;
    private String codeSecretCarte;
    private Date  dateExpirationCarte;
    private int idClient;
    
    public Carte() {
		 
	}
    
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
