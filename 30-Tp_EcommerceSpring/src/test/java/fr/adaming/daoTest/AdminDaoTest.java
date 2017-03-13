package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;

import fr.adaming.model.Produit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class AdminDaoTest {

	@Autowired
	IAdminDao adminDao;

	public SessionFactory getSf() {
		return sf;
	}

	@Autowired
	private SessionFactory sf;

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Test
	@Transactional
	public void getAllProductAdminDaoTest() {

		Session s = sf.getCurrentSession();

		List<Produit> listProd = adminDao.consulterAdminDao();

		assertFalse(listProd.isEmpty());
	}

	@Test
	@Transactional
	public void getProduitByIdTest() {

		Session s = sf.getCurrentSession();

		List<Produit> listProd = adminDao.consulterAdminDao();

		String nomFirstProduit = listProd.get(0).getDesignation();

		System.out.println(nomFirstProduit);

		String nomExpected = adminDao.getProduitById(1).getDesignation();

		System.out.println(nomExpected);

		assertTrue(nomFirstProduit == nomExpected);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void ajouterAdminDaoTest() {

		Session s = sf.getCurrentSession();

		Produit ptest = new Produit(2, "test", "test", (float) 120.0, 1, "false",
				(Categorie) s.get(Categorie.class, 1));

		System.out.println("========= Produit test: \n" + ptest);

		adminDao.ajouterAdminDao(ptest, 1);

		List<Produit> listProd = adminDao.consulterAdminDao();

		for (Produit e : listProd) {
			System.out.println("========= Liste Produit: \n" + e);
		}

		Produit lastProduit = adminDao.getProduitById(ptest.getId());

		System.out.println("========= Produit ajouté: \n" + lastProduit);

		assertEquals(lastProduit, ptest);

	}

	@Test
	@Transactional
	@Rollback(true)
	public void supprimerAdminDaoTest() {

		int ref1 = adminDao.consulterAdminDao().size();

		int maxListe = ref1 - 1;

		Produit p = new Produit();

		p = adminDao.consulterAdminDao().get(maxListe);

		adminDao.supprimerAdminDao(p);

		int ref2 = adminDao.consulterAdminDao().size();

		assertTrue(maxListe == ref2);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void mofifierAdminDaoTest() {

		Session s = sf.getCurrentSession();

		Produit ptest = new Produit(2, "test", "test", (float) 120.0, 1, "false",
				(Categorie) s.get(Categorie.class, 1));

		// ajouter le produit à la liste
		adminDao.ajouterAdminDao(ptest, 1);

		// vérifier que le produit est bien dans la liste
		List<Produit> listProd = adminDao.consulterAdminDao();

		for (Produit e : listProd) {
			System.out.println("========= Liste Produit: \n" + e);
		}
		// recupérer le produit dans la liste
		Produit lastProduit = adminDao.getProduitById(ptest.getId());

		System.out.println("========= Produit ajouté: \n" + lastProduit);

		// modifier et ajouter le produit à la liste

		ptest.setDesignation("modif");
		adminDao.mofifierAdminDao(ptest);

		// verifier que le rpoduit ajouter est bien celui qui a été modfié
		for (Produit e : listProd) {
			System.out.println("========= Liste Produit: \n" + e);
		}

		assertTrue(ptest.getDesignation() == "modif");
	}

	@Test
	@Transactional
	public void getCategorieByIdTest() {

	
		Session s = sf.getCurrentSession();

		List<Categorie> listCat = adminDao.consulterCategorieAdminDao();

		String nomFirstCat = listCat.get(0).getNomCategorie();

		System.out.println(nomFirstCat);

		String nomExpected = adminDao.getCategorieById(1).getNomCategorie();

		System.out.println(nomExpected);

		assertTrue(nomFirstCat == nomExpected);
	}

	@Test
	@Transactional
	public void consulterCategorieAdminDaoTest() {

		Session s = sf.getCurrentSession();

		List<Categorie> listCat = adminDao.consulterCategorieAdminDao();

		assertFalse(listCat.isEmpty());

	}

	@Test
	@Transactional
	@Rollback(true)
	public void ajouterCategorieAdminDao() {

		Session s = sf.getCurrentSession();

		Categorie catest = new Categorie(1, "nomTest", "descripTest");

		System.out.println("========= Categorie test: \n" + catest);

		adminDao.ajouterCategorieAdminDao(catest);

		List<Categorie> listCat = adminDao.consulterCategorieAdminDao();

		for (Categorie e : listCat) {
			System.out.println("========= Liste Categorie: \n" + e);
		}

		Categorie lastCat = adminDao.getCategorieById(catest.getId());

		System.out.println("========= Categorie ajouté: \n" + lastCat);

		assertEquals(lastCat, catest);

	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void mofifierCategorieAdminDaoTest() {
		
		Session s = sf.getCurrentSession();

		Categorie catest = new Categorie(1, "nomTest", "descripTest");

		System.out.println("========= Categorie test: \n" + catest);

		adminDao.ajouterCategorieAdminDao(catest);

		List<Categorie> listCat = adminDao.consulterCategorieAdminDao();

		Categorie lastCat = adminDao.getCategorieById(catest.getId());

		System.out.println("========= Categorie ajouté: \n" + lastCat);
		
		catest.setNomCategorie("nomModif");
		
		adminDao.mofifierCategorieAdminDao(catest);

		// verifier que le rpoduit ajouter est bien celui qui a été modfié
		for (Categorie e : listCat) {
			System.out.println("========= Liste Categorie: \n" + e);
		}

		assertTrue(catest.getNomCategorie() == "nomModif");
	}
	

}
