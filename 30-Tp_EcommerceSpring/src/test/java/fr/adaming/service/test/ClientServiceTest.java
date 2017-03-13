package fr.adaming.service.test;

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
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ClientServiceTest {

	@Autowired
	IClientService clientService;

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	@Autowired
	IAdminService adminService;

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	@Test
	@Transactional
	public void consulterCategorieClientServiceTest() {
		
		Session s = sf.getCurrentSession();

		List<Categorie> listCat = clientService.consulterCategorieClientService();

		assertFalse(listCat.isEmpty());
	}

	@Test
	@Transactional
	public void consulterProduitParCategorieServiceTest() {

		Session s = sf.getCurrentSession();

		List<Produit> listProd = adminService.consulterAdminService();

		Produit p = listProd.get(0);

		System.out.println(p);

		List<Produit> listProd2 = clientService.consulterProduitParCategorieService(1);

		assertTrue(listProd2.contains(p));

	}

	@Test
	@Transactional
	public void consulterProduitSelectionnerServiceTest() {

		Session s = sf.getCurrentSession();

		List<Produit> listProd = clientService.consulterProduitSelectionnerService();

		assertFalse(listProd.isEmpty());
	}

	@Test
	@Transactional
	public void consulterProduitParMotCleService() {

		List<Produit> listProd = adminService.consulterAdminService();

		Produit p = listProd.get(0);

		String nomProduit = p.getDesignation();

		List<Produit> listProd2 = clientService.consulterProduitParMotCleService(nomProduit);

		assertFalse(listProd2.isEmpty());
	}

	// @Test
	// @Transactional
	// @Rollback(true)
	// public void ajouterProduitPanierService() {
	//
	// Session s = sf.getCurrentSession();
	//
	// Produit ptest = new Produit(2, "test", "test", (float) 120.0, 1, "false",
	// (Categorie) s.get(Categorie.class, 1));
	//
	// LigneCommande lc=clientService.ajouterProduitPanierService(ptest, 1);
	//
	// System.out.println(lc);
	//
	// List<LigneCommande> listProd=new ArrayList<>();
	//
	// listProd.add(lc);
	//
	// assertFalse(listProd.isEmpty());
	// }
	//
	// @Override
	// public void supprimerProduitPanierService(Produit p) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	@Test
	@Transactional
	@Rollback(true)
	public void enregisterCommandeServiceTest() {

		Session s = sf.getCurrentSession();
		Commande c = new Commande();
		Client clt = new Client();

		Commande ctest = clientService.enregistrerCommandeService(c, clt);

		assertTrue(ctest.getClient_associe() == clt);
	}

}
