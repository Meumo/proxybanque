package sn.proxybanque.domaine;

import java.util.Date;

/**
 * Date Decembre 05-2018 # la classe Client gere les etats d'un client dans
 * notre application.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 * @since 2018
 * @version 1.0-SNAPSHOT
 */
public class Client extends Personne {
	/**
	 * Le numero d'un client
	 */
	private String numeroClient;
	/**
	 * Le code postal d'un client
	 */
	private String codePostalClient;
	/**
	 * la ville d'un client
	 */
	private String villeClient;
	/**
	 * La proffession d'un client
	 */
	private String proffessionClient;
	/**
	 * Le conseiller d'un client
	 */
	private int idConseillerClientel;

	/**
	 * Constructeur sans arguments
	 */
	public Client() {
		super();
	}

	/**
	 * Constructeur avec arguments
	 */

	public Client(int id,String nom, String prenom, String adresse, String telephone, Date dateDenaissonce, String email,
			String sexe, String numeroClient, String codePostalClient, String vileClient, String professionClient,
			int idConseillerClientel) {
		super();
		this.numeroClient = numeroClient;
		this.codePostalClient = codePostalClient;
		this.villeClient = vileClient;
		this.proffessionClient = professionClient;
		this.idConseillerClientel = idConseillerClientel;
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

	public int getIdConseillerClientel() {
		return idConseillerClientel;
	}

	public void setIdConseillerClientel(int idConseillerClientel) {
		this.idConseillerClientel = idConseillerClientel;
	}

	
}
