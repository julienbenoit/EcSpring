package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

/**
 * This class implements the methods for the handling rules of the actor Client
 * @author POUNCHOU Julien
 *
 */
@Service(value="clientService")
@Transactional
public class ClientServiceImpl implements IClientService{


	@Autowired
	IClientDao clientDao;
	
	/**
	 * This method add the product to the table command
	 * 
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public LigneCommande ajouterProduitPanierService(Produit p, int quantite) {
		return clientDao.ajouterProduitPanierDao(p, quantite);
		
	}
	
	/**
	 * This method delete the product from the table command
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void supprimerProduitPanierService(Produit p) {
		clientDao.supprimerProduitPanierDao(p);
	}

	/**
	 * This method get all the categories from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Categorie> consulterCategorieClientService() {
	List<Categorie> listeCategorie=clientDao.consulterCategorieClientDao();
		return listeCategorie;
	}

	/**
	 * This method get all the product from the table categorie
	 * @param c is an object Categorie (long idCategorie, String nomCategorie, String description)
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterProduitParCategorieService(int id_c) {
		List<Produit> listeProduit=clientDao.consulterProduitParCategorieDao(id_c);
		return listeProduit;
	}

	/**
	 * This method get all the products selected by the client
	 * @param void
	 * @return List<Produit> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterProduitSelectionnerService() {
		List<Produit> listeProduit=clientDao.consulterProduitSelectionnerDao();
		return listeProduit;
	}

	/**
	 * This method saves the current commands in Panier 
	 * @param p is an object Panier, c is an object Commande
	 * @return void 
	 */
	@Override
	public Commande enregistrerCommandeService(Commande com, Client c) {
		Commande commande=clientDao.enregisterCommandeDao(com, c);
		return commande;
	}

	/**
	 * This method allows the user to look for a product with key words research 
	 * @param cle : type String, the key word
	 * @return List<Produit> 
	 */
	@Override
	public List<Produit> consulterProduitParMotCleService(String cle) {
		List<Produit> listeProduit=clientDao.consulterProduitParMotCleDao(cle);
		return listeProduit;
	}

}
