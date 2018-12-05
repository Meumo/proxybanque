package sn.proxybanque.domaine;

 

import java.util.Date;

public class Client extends Personne{
	private String numeroClient;
	private String codePostalClient;
	private String villeClient;
	private String proffessionClient;
	private Employer conseillerClientel;
	
	
	
	public Client() {
		super();
	}



	public Client(String nom, String prenom, String adresse, String telephone, Date dateDenaissonce, String email,
			char sexe, String numeroClient, String codePostalClient, String vileClient, String professionClient,
			Employer conseillerClientel) {
		super(nom, prenom, adresse, telephone, dateDenaissonce, email, sexe);
		this.numeroClient = numeroClient;
		this.codePostalClient = codePostalClient;
		this.villeClient = vileClient;
		this.proffessionClient = professionClient;
		this.conseillerClientel = conseillerClientel;
	}



	public String getNumeroClient() {
		return numeroClient;
	}



	public String getCodePostalClient() {
		return codePostalClient;
	}



	public String getVileClient() {
		return villeClient;
	}



	public String getProfessionClient() {
		return proffessionClient;
	}



	public Employer getConseillerClientel() {
		return conseillerClientel;
	}



	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}



	public void setCodePostalClient(String codePostalClient) {
		this.codePostalClient = codePostalClient;
	}



	public void setVileClient(String vileClient) {
		this.villeClient = vileClient;
	}



	public void setProfessionClient(String professionClient) {
		this.proffessionClient = professionClient;
	}



	public void setConseillerClientel(Employer conseillerClientel) {
		this.conseillerClientel = conseillerClientel;
	}
	
	
	
	

}
