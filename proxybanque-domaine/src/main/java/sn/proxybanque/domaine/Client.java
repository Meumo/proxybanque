package sn.proxybanque.domaine;

 

import java.util.Date;
import java.util.List;

public class Client extends Personne{
	private String numeroClient;
	private String codePostalClient;
	private String vileClient;
	private String professionClient;
	private List<Employer>conseillerClientel;
	
	
	
	public Client() {
		super();
	}



	public Client(String nom, String prenom, String adresse, String telephone, Date dateDenaissonce, String email,
			char sexe, String numeroClient, String codePostalClient, String vileClient, String professionClient,
			List<Employer> conseillerClientel) {
		super(nom, prenom, adresse, telephone, dateDenaissonce, email, sexe);
		this.numeroClient = numeroClient;
		this.codePostalClient = codePostalClient;
		this.vileClient = vileClient;
		this.professionClient = professionClient;
		this.conseillerClientel = conseillerClientel;
	}



	public String getNumeroClient() {
		return numeroClient;
	}



	public String getCodePostalClient() {
		return codePostalClient;
	}



	public String getVileClient() {
		return vileClient;
	}



	public String getProfessionClient() {
		return professionClient;
	}



	public List<Employer> getConseillerClientel() {
		return conseillerClientel;
	}



	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}



	public void setCodePostalClient(String codePostalClient) {
		this.codePostalClient = codePostalClient;
	}



	public void setVileClient(String vileClient) {
		this.vileClient = vileClient;
	}



	public void setProfessionClient(String professionClient) {
		this.professionClient = professionClient;
	}



	public void setConseillerClientel(List<Employer> conseillerClientel) {
		this.conseillerClientel = conseillerClientel;
	}
	
	
	
	

}
