package fr.adaming.dao;

import java.util.List;



import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;


public interface IAdminDao {
	
	/**
	 * This test method add an admin to the table admins
	 * @param Admin
	 * @return void
	 */
	public void ajouterAdminDao(Admin a);
public List<Produit> consulterAdminDao();
	
	/**
	 * This method add a product to the table product
	 * @param Produit, Int (foreign key of a categorie)
	 */
	public void ajouterAdminDao(Produit p,int fk_categorie);
	/**
	 * This method delete the product from the table product
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	public void supprimerAdminDao(Produit p);
	
	/**
	 * This method update the product from the table product
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
 	 * @return void : this method is an action doesn't return anything
	 */
	public void mofifierAdminDao(Produit p);
	
	/**
	 * This method display all of the categories
	 * @param void
	 * @return List<Categorie> 
	 */
	public List<Categorie> consulterCategorieAdminDao();
	
	/**
	 * This method add a new categorie to the table categorie
	 * @param Categorie
	 * @return void
	 */
	public void ajouterCategorieAdminDao(Categorie c);
	
	/**
	 * This method delete a categorie of the table categorie
	 * @param Categorie
	 * @return void
	 */
	public void supprimerCategorieAdminDao(Categorie c);
	
	/**
	 * This method update an existing categorie from the table categorie
	 * @param Categorie
	 * @return void
	 */
	public void mofifierCategorieAdminDao(Categorie c);

	
	/**
	 * This method find the existence of an admin to allow the connection
	 * @param Admin
	 * @return Admin
	 */
	public Admin isExist(Admin a);



}
