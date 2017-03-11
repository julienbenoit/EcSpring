package fr.adaming.service;

import java.util.List;


import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

/**
 * This interface implements the methods for the handling rules of the actor Client
 * @author POUNCHOU Julien
 *
 */
public interface IClientService {
	/**
	 * This method add the product to the table command
	 * 
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	public LigneCommande ajouterProduitPanierService(Produit p, int quantite);
	
	/**
	 * This method delete the product from the table command
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	public void supprimerProduitPanierService(Produit p);
	


	/**
	 * This method get all the categories from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	public List<Categorie> consulterCategorieClientService();
	
	/**
	 * This method get all the product from the table categorie
	 * @param c is an object Categorie (long idCategorie, String nomCategorie, String description)
	 * @return List<Categorie> : return the list of all categories objects
	 */
	public List<Produit> consulterProduitParCategorieService(int id_c);
	
	/**
	 * This method get all the products selected by the client
	 * @param void
	 * @return List<Produit> : return the list of all categories objects
	 */
	public List<Produit> consulterProduitSelectionnerService();
	
	
	/**
	 * This method saves the current commands in Panier 
	 * @param p is an object Panier, c is an object Commande
	 * @return void 
	 */
	public Commande enregistrerCommandeService(Commande com, Client c);
	
	/**
	 * This method allows the user to look for a product with key words research 
	 * @param cle : type String, the key word
	 * @return List<Produit> 
	 */
	public List<Produit> consulterProduitParMotCleService(String cle);
}
