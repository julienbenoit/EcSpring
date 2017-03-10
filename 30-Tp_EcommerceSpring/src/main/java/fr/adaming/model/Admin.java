package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//===================Attributs propres==============================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String identifiant;
	private String password;
	private String nom;
	
	
	//===================Constructeurs==============================
	public Admin() {
		super();
	}
	 
	public Admin(String identifiant, String password, String nom) {
		super();
		this.identifiant = identifiant;
		this.password = password;
		this.nom = nom;
	}
	
	public Admin(int id, String identifiant, String password, String nom) {
		super();
		this.id = id;
		this.identifiant = identifiant;
		this.password = password;
		this.nom = nom;
	}

	//===================Accesseurs==============================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	//===================Redefine ToString==============================
	@Override
	public String toString() {
		return "Admin [id=" + id + ", identifiant=" + identifiant
				+ ", password=" + password + ", nom=" + nom + "]";
	}
	
	
}
