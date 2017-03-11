package fr.adaming.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

/**
 * This class contains the methods for the database relation of the actor Admin
 * 
 * @author POUNCHOU Julien
 *
 */
@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sf;

	/**
	 * This test method add an admin to the table admins
	 * 
	 * @param Admin
	 * @return void
	 */
	@Override
	public void ajouterAdminDao(Admin a) {
		Session s = sf.getCurrentSession();
		s.save(a);

	}

	/**
	 * This method get all the products from the table product
	 * 
	 * @param void
	 * @return List<Categorie> : return the list of all categories objects
	 */
	@Override
	public List<Produit> consulterAdminDao() {
		Session s = sf.getCurrentSession();
		Criteria cr = s.createCriteria(Produit.class);
		List<Produit> liste3 = cr.list();
		return liste3;
	}

	/**
	 * This method add a product to the table product
	 * 
	 * @param Produit,
	 *            Int (foreign key of a categorie)
	 */
	@Override
	public void ajouterAdminDao(Produit p, int fk_categorie) {
		Session s = sf.getCurrentSession();
		Categorie c1 = (Categorie) s.get(Categorie.class, fk_categorie);
		p.setCategorie_associe(c1);
		s.save(p);

	}

	/**
	 * This method delete the product from the table product
	 * 
	 * @param p
	 *            is an object Produit (long idProduit, String designation,
	 *            String description,float prix, int quantite, boolean
	 *            selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void supprimerAdminDao(Produit p) {
		Session s = sf.getCurrentSession();
		Produit p1 = (Produit) s.get(Produit.class, p.getId());
		s.delete(p1);

	}

	/**
	 * This method update the product from the table product
	 * 
	 * @param p
	 *            is an object Produit (long idProduit, String designation,
	 *            String description,float prix, int quantite, boolean
	 *            selectionne)
	 * @return void : this method is an action doesn't return anything
	 */
	@Override
	public void mofifierAdminDao(Produit p) {
		Session s = sf.getCurrentSession();

		s.update(p);

	}

	/**
	 * This method display all of the categories
	 * 
	 * @param void
	 * @return List<Categorie>
	 */
	@Override
	public List<Categorie> consulterCategorieAdminDao() {
		Session s = sf.getCurrentSession();
		Criteria cr = s.createCriteria(Categorie.class);
		List<Categorie> liste3 = cr.list();
		return liste3;
	}

	/**
	 * This method add a new categorie to the table categorie
	 * 
	 * @param Categorie
	 * @return void
	 */
	@Override
	public void ajouterCategorieAdminDao(Categorie c) {
		Session s = sf.getCurrentSession();
		s.save(c);
	}

	/**
	 * This method delete a categorie of the table categorie
	 * 
	 * @param Categorie
	 * @return void
	 */
	@Override
	public void supprimerCategorieAdminDao(Categorie c) {
		Session s = sf.getCurrentSession();
		Categorie c1 = (Categorie) s.get(Categorie.class, c.getId());
		s.delete(c1);

	}

	/**
	 * This method update an existing categorie from the table categorie
	 * 
	 * @param Categorie
	 * @return void
	 */
	@Override
	public void mofifierCategorieAdminDao(Categorie c) {
		Session s = sf.getCurrentSession();

		s.update(c);

	}
	
	@Override
	public Categorie getCategorieById(int id) {
		Session s=sf.getCurrentSession();
		Categorie c1=(Categorie) s.get(Categorie.class, id);
		
		return c1;
	}

	@Override
	public Produit getProduitById(int id) {
		Session s=sf.getCurrentSession();
		Produit p1=(Produit) s.get(Produit.class, id);
		
		return p1;
	}

	@Override
	public Admin isExist(Admin a) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
