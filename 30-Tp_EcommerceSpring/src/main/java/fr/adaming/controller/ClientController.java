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
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService cS;

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String accueil(ModelMap model) {

		return "accueilClient";
	}

	@RequestMapping(value = "/listeCategorieClient", method = RequestMethod.GET)
	public String afficherCategorie(ModelMap model) {

		List<Categorie> listeCat = cS.consulterCategorieClientService();

		model.addAttribute("catListe", listeCat);
		return "afficherListeCatPourClient";
	}

	@RequestMapping(value = "/listeProduitParMotCle", method = RequestMethod.GET)
	public String redListeMotCle() {
		
		return "produitParMotCle";
	}
	@RequestMapping(value = "/afficherListeProduitMC", method = RequestMethod.GET)
	public String listeProduitMC(Model model, @RequestParam("param") String cle) {
		
		List<Produit> liste=cS.consulterProduitParMotCleService(cle);
		

		model.addAttribute("pListe", liste);
	
		return "afficherListeProduitPourClient";

	}
	@RequestMapping(value = "/supprimerProduitDansPanier", method = RequestMethod.GET)
	public ModelAndView affichFormSupp() {
		return new ModelAndView("supprimerProduitDansPanier", "produitForm", new Produit());
	}
	@RequestMapping(value = "/supprimerPanier", method = RequestMethod.POST)
	public String suppressionPanier(Model model, @Valid Produit prod, BindingResult bResultat) {
		if(bResultat.hasErrors()){
			return "supprimerProduitDansPanier";
		}else{
			
		cS.supprimerProduitPanierService(prod);
		}
	
		return "supprimerProduitDansPanier";

	}
	
	@RequestMapping(value = "/ajouterProduitDansPanier", method = RequestMethod.GET)
	public ModelAndView affichFormAjout() {
		return new ModelAndView("ajouterProduitDansPanier", "produitForm", new Produit());
	}
	@RequestMapping(value = "/ajouterPanier", method = RequestMethod.POST)
	public String ajouterPanier(Model model, @Valid Produit prod, BindingResult bResultat) {
		
		if(bResultat.hasErrors()){
			return "ajouterProduitDansPanier";
		}else{
		
		cS.ajouterProduitPanierService(prod, prod.getQuantite());}
	
		return "ajouterProduitDansPanier";

	}
	
	@RequestMapping(value = "/listeProduitParCategorie", method = RequestMethod.GET)
	public String redListePParC() {
		
		return "produitParCat";
	}
	@RequestMapping(value = "/afficherListeProduitParC", method = RequestMethod.GET)
	public String listeProduitParCategorie(Model model, @RequestParam("param") int id_c) {
		
		List<Produit> liste=cS.consulterProduitParCategorieService(id_c);
		

		model.addAttribute("pListe", liste);
	
		return "afficherListeProduitPourClient";

	}

	
	@RequestMapping(value = "/afficherListeProduitParSelection", method = RequestMethod.GET)
	public String listeProduitSelection(Model model) {
		
		List<Produit> liste=cS.consulterProduitSelectionnerService();
		

		model.addAttribute("pListe", liste);
	
		return "afficherListeProduitPourClient";

	}
	@RequestMapping(value = "/enregistrerCommande", method = RequestMethod.GET)
	public ModelAndView affichFormEng() {
		return new ModelAndView("enregistrerCommande", "commandeForm", new Commande());
	}
	@RequestMapping(value = "/enregistrerCommandeSoum", method = RequestMethod.GET)
	public String enregistrerCom(Model model, @ModelAttribute("commandeForm") Commande com) {
		
		cS.enregistrerCommandeService(com, com.getClient_associe());
	
		return "enregistrerCommande";

	}
	
}