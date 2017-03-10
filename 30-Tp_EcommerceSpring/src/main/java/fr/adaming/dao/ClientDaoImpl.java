package fr.adaming.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;

/**
 * This class implements the methods for the database connection of the actor Client
 * @author POUNCHOU Julien
 *
 */

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sf;
	
	/**
	 * This method get all the categories from the table product
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Categorie> consulterCategorieClientDao() {
		Session s=sf.getCurrentSession();
		Criteria cr=s.createCriteria(Categorie.class);
		List<Categorie> liste3=cr.list();
		return liste3;
	}

	/**
	 * This method get all the product from the table categorie
	 * @param c is an object Categorie (long idCategorie, String nomCategorie, String description)
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterProduitParCategorieDao(int id) {
		Session s=sf.getCurrentSession();
		String req = "SELECT p FROM Produit p WHERE p.categorie_associe.id=:a ";

		Query query = s.createQuery(req);
		query.setParameter("a", id);
		List<Produit> listeProduit = query.list();
	
		return listeProduit;
	}

	/**
	 * This method get all the products selected by the client
	 * @param void
	 * @return List<Produit> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterProduitSelectionnerDao() {
		Session s=sf.getCurrentSession();
		String req = "SELECT p FROM Produit p WHERE p.selectionne='true' ";

		Query query = s.createQuery(req);

		List<Produit> listeProduit = query.list();
		return listeProduit;
	}

	/**
	 * This method allows the user to look for a product with key words research 
	 * @param cle : type String, the key word
	 * @return List<Produit> 
	 */
	@Override
	public List<Produit> consulterProduitParMotCleDao(String cle) {
		Session s=sf.getCurrentSession();
		String req = "SELECT p FROM Produit p WHERE p.designation like:a or p.description like:a ";

		Query query = s.createQuery(req);
		query.setParameter("a", "%" + cle + "%");
		List<Produit> listeProduit = query.list();
		return listeProduit;
	}

	/**
	 * This method add the product to the table command
	 * 
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public LigneCommande ajouterProduitPanierDao(Produit p, int quantite) {
		Session s=sf.getCurrentSession();
		Produit p1=(Produit) s.get(Produit.class, p.getId());

		
		LigneCommande lignecommande = new LigneCommande();
		lignecommande.setQuantite(quantite);
		lignecommande.setPrix(p1.getPrix());
		lignecommande.setProduit_associe(p1);
		s.save(lignecommande);
		
		List<LigneCommande> listeLignecommande=new ArrayList<>();
		listeLignecommande.add(lignecommande);
		p1.setSelectionne("true");
	     p1.setListeLigneCommande(listeLignecommande);
		s.update(p1); 
return lignecommande;
		
	}

	/**
	 * This method delete the product from the table command
	 * @param p is an object Produit (long idProduit, String designation, String description,float prix, int quantite, boolean selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void supprimerProduitPanierDao(Produit p) {
		Session s=sf.getCurrentSession();
		LigneCommande ligneCommande=(LigneCommande) s.get(LigneCommande.class, p.getId());
		s.delete(ligneCommande); 
	

	}

	/**
	 * This method saves the current commands in Panier 
	 * @param p is an object Panier, c is an object Commande
	 * @return void 
	 */
	@Override
	public Commande enregisterCommandeDao(Commande com, Client c) {
		Session s=sf.getCurrentSession();
	s.save(c);
		com.setClient_associe(c);
		s.save(com);
     
		LigneCommande ligneCommande=(LigneCommande) s.get(LigneCommande.class, com.getId());
	List<LigneCommande> listeLigneCommande= new ArrayList<>();
	listeLigneCommande.add(ligneCommande);
	
		com.setListeLigneCommande(listeLigneCommande);
		
		
	
		s.update(com);

		return com;
	}

}
