package fr.adaming.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminProduitController {

	@Autowired
	private IAdminService aS;

	// Partie Produit

	@RequestMapping(value = "/accueilAdmin", method = RequestMethod.GET)
	public String accueilAdminPro(ModelMap model) {

		return "accueilAdmin";
	}
	@RequestMapping(value = "/listeProduit", method = RequestMethod.GET)
	public String afficherProduit(ModelMap model) {

		List<Produit> listeProduit = aS.consulterAdminService();

		model.addAttribute("produitListe", listeProduit);
		return "afficherListeProduitAd";
	}

	@RequestMapping(value = "/affichFormAjoutProduit", method = RequestMethod.GET)
	public ModelAndView affichFormAjoutProduit() {
		return new ModelAndView("ajouterProduit", "produitForm", new Produit());
	}

	@RequestMapping(value = "/soumettreFormAjoutProduit", method = RequestMethod.POST)
	public String soumettreFormAjoutProd(Model model, @ModelAttribute("ProduitForm") Produit prod) {

		if (prod.getId() == 0) {
			
			aS.ajouterAdminService(prod, prod.getCategorie_associe().getId());

		} else {

			aS.mofifierAdminService(prod);}

			List<Produit> listeProduit = aS.consulterAdminService();

			model.addAttribute("produitListe", listeProduit);
			return "afficherListeProduitAd";

		
	
	}

	@RequestMapping(value = "/affichFormmodifProduit", method = RequestMethod.GET)
	public String affichFormModifProd(ModelMap model, @RequestParam("id_param") int id_prod) {

		Produit prod = aS.getProduitByIdService(id_prod);
		model.addAttribute("produitForm", prod);

		return "ajouterProduit";
	}

	@RequestMapping(value = "/supprimerProduit", method = RequestMethod.GET)
	public String supprimerEmployes(Model model, @RequestParam("id_param") int id) {

		Produit prod = aS.getProduitByIdService(id);
		aS.supprimerAdminService(prod);

		List<Produit> listeProduit = aS.consulterAdminService();

		model.addAttribute("produitListe", listeProduit);
		return "afficherListeProduitAd";

	}

}
