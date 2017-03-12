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
@RequestMapping("/adminPro")
public class AdminController {

	@Autowired
	private IAdminService aS;


	// PartieCategorie 
	//accueil
	@RequestMapping(value = "/accueilAdminPro", method = RequestMethod.GET)
	public String accueilAdminPro(ModelMap model) {

		return "accueilAdminPro";
	}

	@RequestMapping(value = "/listeCategorie", method = RequestMethod.GET)
	public String afficherCategorie(ModelMap model) {

		List<Categorie> listeCat = aS.consulterCategorieAdminService();

		model.addAttribute("catListe", listeCat);
		return "afficherListeCat";
	}

	@RequestMapping(value = "/affichFormAjoutCat", method = RequestMethod.GET)
	public ModelAndView affichFormAjout() {
		return new ModelAndView("ajouterCat", "categorieForm", new Categorie());
	}

	@RequestMapping(value = "/soumettreFormAjoutCat", method = RequestMethod.POST)
	public String soumettreFormAjout(Model model, @Valid @ModelAttribute("categorieForm") Categorie cat, BindingResult bResultat) {

		if(bResultat.hasErrors()){
			return "ajouterCat";
		}else{
		if (cat.getId() == 0) {

			aS.ajouterCategorieAdminService(cat);
	
		} else {

			aS.mofifierCategorieAdminService(cat);
		
		}

		List<Categorie> listeCat = aS.consulterCategorieAdminService();

		model.addAttribute("catListe", listeCat);
		}
		return "afficherListeCat";

	}

	@RequestMapping(value = "/affichFormmodifCat", method = RequestMethod.GET)
	public String affichFormModif(ModelMap model, @RequestParam("id_param") int id_cat) {

		Categorie cat = aS.getCategorieByIdService(id_cat);
		model.addAttribute("categorieForm", cat);

		return "ajouterCat";
	}

	@RequestMapping(value = "/supprimerCategorie", method = RequestMethod.GET)
	public String supprimerCategorie(Model model, @RequestParam("id_param") int id) {

		Categorie cat = aS.getCategorieByIdService(id);
		aS.supprimerCategorieAdminService(cat);

		List<Categorie> listeCat = aS.consulterCategorieAdminService();

		model.addAttribute("catListe", listeCat);

		return "afficherListeCat";

	}

	// Partie Produit

	@RequestMapping(value = "/listeProduit", method = RequestMethod.GET)
	public String afficherProduit(ModelMap model) {

		List<Produit> listeProduit = aS.consulterAdminService();

		model.addAttribute("produitListe", listeProduit);
		return "afficherListeProduit";
	}

	@RequestMapping(value = "/affichFormAjoutProduit", method = RequestMethod.GET)
	public ModelAndView affichFormAjoutProduit() {
		return new ModelAndView("ajouterProduit", "produitForm", new Produit());
	}

	@RequestMapping(value = "/soumettreFormAjoutProduit", method = RequestMethod.POST)
	public String soumettreFormAjoutProd(Model model, @Valid @ModelAttribute("produitForm") Produit prod, BindingResult bResultat) {

		if(bResultat.hasErrors()){
			return "ajouterProduit";
		}else{
		if (prod.getId() == 0) {
			
			aS.ajouterAdminService(prod, prod.getCategorie_associe().getId());

		} else {

			aS.mofifierAdminService(prod);}

			List<Produit> listeProduit = aS.consulterAdminService();

			model.addAttribute("produitListe", listeProduit);}
			return "afficherListeProduit";

		
	
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
		return "afficherListeProduit";

	}

}
