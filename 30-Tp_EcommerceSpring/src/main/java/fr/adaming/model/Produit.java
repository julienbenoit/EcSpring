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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="produits")
public class Produit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//===================Attributs propres==============================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produit")
	private int id;
	private long idProduit;
	private String designation;
	private String description;
	private float prix;
	private int quantite;
	private String selectionne;
	
	
	//===================Attributs associés==============================
	@ManyToOne 
	@JoinColumn(name= "fk_categorie")
	private Categorie categorie_associe;
	
	@OneToMany(mappedBy ="produit_associe")
	private List<LigneCommande> listeLigneCommande;
	
	
	
	//====================Constructeurs==================================
	public Produit() {
		super();
	}
	public Produit(long idProduit, String designation, String description,
			float prix, int quantite, String selectionne) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
	}
	public Produit(int id, long idProduit, String designation,
			String description, float prix, int quantite, String selectionne,
			String photo) {
		super();
		this.id = id;
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
	}
	
	
	public Produit(long idProduit, String designation, String description, float prix, int quantite,
			String selectionne, Categorie categorie_associe) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.categorie_associe = categorie_associe;
	}
	public Produit(int id, long idProduit, String designation, String description, float prix, int quantite,
			String selectionne, Categorie categorie_associe) {
		super();
		this.id = id;
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.categorie_associe = categorie_associe;
	}
	
	
	//====================Accesseurs==================================
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String isSelectionne() {
		return selectionne;
	}
	public void setSelectionne(String selectionne) {
		this.selectionne = selectionne;
	}
	public Categorie getCategorie_associe() {
		return categorie_associe;
	}
	public void setCategorie_associe(Categorie categorie_associe) {
		this.categorie_associe = categorie_associe;
	}
	
	
	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommande;
	}
	public void setListeLigneCommande(List<LigneCommande> listeLigneCommande) {
		this.listeLigneCommande = listeLigneCommande;
	}
	//====================Redefine ToString==============================
	@Override
	public String toString() {
		return "Produit [id=" + id + ", idProduit=" + idProduit
				+ ", designation=" + designation + ", description="
				+ description + ", prix=" + prix + ", quantite=" + quantite
				+ ", selectionne=" + selectionne+"]";
	}
	
	
	
}
