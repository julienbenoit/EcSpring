package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	//===================Attributs propres==============================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_client")
	private int id;
	private long idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;
	
	
	//===================Attributs associés==============================
	@OneToMany(mappedBy = "client_associe" )
	List<Commande> listeCommande; 
	
	
	
	//===================Constructeurs==============================
	public Client() {
		super();
	}
	
	public Client(long idClient, String nomClient, String adresse,
			String email, String tel) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	
	public Client(int id, long idClient, String nomClient, String adresse,
			String email, String tel) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	
	//===================Accesseurs==============================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	//===================Redefine ToString==============================
	@Override
	public String toString() {
		return "Client [id=" + id + ", idClient=" + idClient + ", nomClient="
				+ nomClient + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + "]";
	}
	
	
}
