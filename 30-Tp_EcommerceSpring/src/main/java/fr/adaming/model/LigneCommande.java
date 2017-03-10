package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ligneCommandes")
public class LigneCommande implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	
	//===================Attributs propres==============================
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	@Column(name= "id_ligneCommande")
	private int id;
	private int quantite;
	private float prix;

	
	//===================Attributs associés==============================
	@ManyToOne
	@JoinColumn(name = "fk_ligneCommande")
	private Produit produit_associe;
	
	@ManyToOne
	@JoinColumn(name = "fk_ligneCommande2")
	private Commande commande_associe;
	
	
	
	//====================Constructeurs==================================
	public LigneCommande() {
		super();
	}
	
	
	public LigneCommande(int quantite, float prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	public LigneCommande(int id, int quantite, float prix) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prix = prix;
	}


	//====================Accesseurs==================================
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Produit getProduit_associe() {
		return produit_associe;
	}
	public void setProduit_associe(Produit produit_associe) {
		this.produit_associe = produit_associe;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commande getCommande_associe() {
		return commande_associe;
	}

	public void setCommande_associe(Commande commande_associe) {
		this.commande_associe = commande_associe;
	}


	//====================Redefine ToString==============================
	@Override
	public String toString() {
		return "LigneCommande [quantite=" + quantite + ", prix=" + prix + "]";
	}
	
}
