package fr.adaming.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IAdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class AdminServiceTest {


	@Autowired
	IAdminService adminService;
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	

	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	@Test
	@Transactional
	public void getAllProductAdminServiceTest() {

		Session s = sf.getCurrentSession();

		List<Produit> listProd = adminService.consulterAdminService();

		assertFalse(listProd.isEmpty());
	}

	@Test
	@Transactional
	public void getProduitByIdTest() {

		Session s = sf.getCurrentSession();

		List<Produit> listProd = adminService.consulterAdminService();

		String nomFirstProduit = listProd.get(0).getDesignation();

		System.out.println(nomFirstProduit);

		String nomExpected = adminService.getProduitByIdService(1).getDesignation();

		System.out.println(nomExpected);

		assertTrue(nomFirstProduit == nomExpected);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void ajouterAdminServiceTest() {

		Session s = sf.getCurrentSession();

		Produit ptest = new Produit(2, "test", "test", (float) 120.0, 1, "false",
				(Categorie) s.get(Categorie.class, 1));

		System.out.println("========= Produit test: \n" + ptest);

		adminService.ajouterAdminService(ptest, 1);

		List<Produit> listProd = adminService.consulterAdminService();

		for (Produit e : listProd) {
			System.out.println("========= Liste Produit: \n" + e);
		}

		Produit lastProduit = adminService.getProduitByIdService(ptest.getId());

		System.out.println("========= Produit ajouté: \n" + lastProduit);

		assertEquals(lastProduit, ptest);

	}

	@Test
	@Transactional
	@Rollback(true)
	public void supprimerAdminServiceTest() {

		int ref1 = adminService.consulterAdminService().size();

		int maxListe = ref1 - 1;

		Produit p = new Produit();

		p = adminService.consulterAdminService().get(maxListe);

		adminService.supprimerAdminService(p);

		int ref2 = adminService.consulterAdminService().size();

		assertTrue(maxListe == ref2);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void mofifierAdminServiceTest() {

		Session s = sf.getCurrentSession();

		Produit ptest = new Produit(2, "test", "test", (float) 120.0, 1, "false",
				(Categorie) s.get(Categorie.class, 1));

		// ajouter le produit à la liste
		adminService.ajouterAdminService(ptest, 1);

		// vérifier que le produit est bien dans la liste
		List<Produit> listProd = adminService.consulterAdminService();

		for (Produit e : listProd) {
			System.out.println("========= Liste Produit: \n" + e);
		}
		// recupérer le produit dans la liste
		Produit lastProduit = adminService.getProduitByIdService(ptest.getId());

		System.out.println("========= Produit ajouté: \n" + lastProduit);

		// modifier et ajouter le produit à la liste

		ptest.setDesignation("modif");
		adminService.mofifierAdminService(ptest);

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

		List<Categorie> listCat = adminService.consulterCategorieAdminService();

		assertFalse(listCat.isEmpty());

	}

	@Test
	@Transactional
	public void consulterCategorieAdminServiceTest() {

		Session s = sf.getCurrentSession();

		List<Categorie> listCat = adminService.consulterCategorieAdminService();

		String nomFirstCat = listCat.get(0).getNomCategorie();

		System.out.println(nomFirstCat);

		String nomExpected = adminService.getCategorieByIdService(1).getNomCategorie();

		System.out.println(nomExpected);

		assertTrue(nomFirstCat == nomExpected);

	}

	@Test
	@Transactional
	@Rollback(true)
	public void ajouterCategorieAdminService() {

		Session s = sf.getCurrentSession();

		Categorie catest = new Categorie(1, "nomTest", "descripTest");

		System.out.println("========= Categorie test: \n" + catest);

		adminService.ajouterCategorieAdminService(catest);

		List<Categorie> listCat = adminService.consulterCategorieAdminService();

		for (Categorie e : listCat) {
			System.out.println("========= Liste Categorie: \n" + e);
		}

		Categorie lastCat = adminService.getCategorieByIdService(catest.getId());

		System.out.println("========= Categorie ajouté: \n" + lastCat);

		assertEquals(lastCat, catest);

	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void mofifierCategorieAdminServiceTest() {
		
		Session s = sf.getCurrentSession();

		Categorie catest = new Categorie(1, "nomTest", "descripTest");

		System.out.println("========= Categorie test: \n" + catest);

		adminService.ajouterCategorieAdminService(catest);

		List<Categorie> listCat = adminService.consulterCategorieAdminService();

		Categorie lastCat = adminService.getCategorieByIdService(catest.getId());

		System.out.println("========= Categorie ajouté: \n" + lastCat);
		
		catest.setNomCategorie("nomModif");
		
		adminService.mofifierCategorieAdminService(catest);

		// verifier que le rpoduit ajouter est bien celui qui a été modfié
		for (Categorie e : listCat) {
			System.out.println("========= Liste Categorie: \n" + e);
		}

		assertTrue(catest.getNomCategorie() == "nomModif");
	}
}
