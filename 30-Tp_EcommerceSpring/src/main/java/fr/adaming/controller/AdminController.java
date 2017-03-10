package fr.adaming.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.service.IAdminService;



//declaration du controller
@Controller
@RequestMapping("/employe") // definition de l'adresse pour acceder au methode
public class AdminController {

	@Autowired // instanciation auto
	private IAdminService aS;

	// methode accessible depuis l'accueil avec initialisation du model
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String accueil(ModelMap model) {
		model.addAttribute("nomApp", "APPLICATION DE GESTION DES EMPLOYES");
		model.addAttribute("salutation", "avec spring MVC");
		return "accueil";
	}

	// pour afficher on peut lancer directement la page
	@RequestMapping(value = "/listeEmploye", method = RequestMethod.GET)
	public String afficherEmployes(ModelMap model) {

		List<Categorie> listeEmp = aS.consulterCategorieAdminService();

		model.addAttribute("empListe", listeEmp);
		return "afficherListe";
	}

	// methode pour rediriger les pages depuis l'accueuil
	@RequestMapping(value = "/ajouterEmploye", method = RequestMethod.GET)
	public String formAjout(ModelMap model) {
		// initialisation du model
	//	model.addAttribute("employeForm", new Employe());
		return "ajouter";
	}

	// pour recuperer des donnees il faut une methode post!
	// ajout d'une erreur dans la page en fonction des annotations de la classe
	@RequestMapping(value = "/enregistrerEmploye", method = RequestMethod.POST)
	public String ajouterEmployes(Model model, @Valid @ModelAttribute("employeForm") Employe pEmploye,
			BindingResult validation) {

		if (validation.hasErrors()) {
			return "ajouter";
		} else {

			// Employe e1=new Employe(pEmploye.getNom(), pEmploye.getMail());
			eS.addEmployeService(pEmploye);

			// rafraichir la liste
			List<Employe> listeEmp = eS.getAllEmployeService();

			model.addAttribute("empListe", listeEmp);
			return "accueil";// retour sur l'accueil
		}

	}

	// methode pour recuperer les parametres dans l'adresse url sans passer par
	// le model
	@RequestMapping(value = "/supEmploye", method = RequestMethod.GET)
	public String supE() {
		// direction vers le formulaire de suppression
		return "supprimer";
	}

	// on recuperer les parametres au lieu du model, on specifie le nom du
	// parametre dans le formulaire
	// on soumet les donnes du formulaire
	@RequestMapping(value = "/supprimerEmploye", method = RequestMethod.GET)
	public String supprimerEmployes(Model model, @RequestParam("id_param") int id) {
		// @requestParam recupereration du parametre
		// on est pas obliger de mettre @requestParam mais il faut le meme nom
		// dans la page jsp
		Employe emp = eS.getEmployeByIdService(id);
		eS.deleteService(emp);
		// rafraichir la liste
		List<Employe> listeEmp = eS.getAllEmployeService();

		model.addAttribute("empListe", listeEmp);
		// retour accueil
		return "accueil";

	}

	// methode pour obtenir un employe en passant par le model
	@RequestMapping(value = "/modEmploye", method = RequestMethod.GET)
	public String obE(ModelMap model) {

		model.addAttribute("employeForm", new Employe());
		return "modifier";
	}

	// suite de la methode obtenir l'employé
	@RequestMapping(value = "/modifierEmploye", method = RequestMethod.POST)
	public String modifierEmployes(Model model, @ModelAttribute("employeForm") Employe pEmploye) {

		// mise en relation avec la base de donnée
		eS.updateEmployeService(pEmploye);

		List<Employe> listeEmp = eS.getAllEmployeService();

		// mise de la liste dans le model
		model.addAttribute("empListe", listeEmp);

		return "accueil";

	}

	// obtenir un employe dans une table
	@RequestMapping(value = "/obEmploye", method = RequestMethod.GET)
	public String obEmploye(Model model) {
		model.addAttribute("employeForm", new Employe());
		return "obtenirEmploye";
	}

	@RequestMapping(value = "/obtenirEmploye", method = RequestMethod.POST)
	public String obtenirEmploye(Model model, @ModelAttribute("employeForm") Employe pEmploye) {

		// envoie des donnés par le model pour les afficher dan une table
		Employe e2 = eS.getEmployeByIdService(pEmploye.getId());
		model.addAttribute("resultNom", e2.getNom());
		model.addAttribute("resultId", e2.getId());
		model.addAttribute("resultMail", e2.getMail());

		// retour sur l'employe selectionner
		return "employeSeul";

	}

	// autre solution pour l'ajout
	@RequestMapping(value = "/affichFormAjout", method = RequestMethod.GET)
	public ModelAndView affichFormAjout() {
		return new ModelAndView("ajoutTest", "employeForm", new Employe());
	}

	// suite methode autre sol ajout
	@RequestMapping(value="/soummettreFormAjout", method= RequestMethod.POST)
	public String soumettreFormAjout(Model model, @Valid @ModelAttribute("employeForm") Employe em, BindingResult validation){
		if (validation.hasErrors()) {
			return "ajoutTest";
		} if(em.getId()==0){
			System.out.println("id emp"+em.getId());
			System.out.println("id emp"+em.getNom());
			eS.addEmployeService(em);
		
		}  else {
		

			// Employe e1=new Employe(pEmploye.getNom(), pEmploye.getMail());
			eS.updateEmployeService(em);
			System.out.println("je suis dans l'update"+em.getId());
		}

			//rafraichir la liste
			List<Employe> listeEmp = eS.getAllEmployeService();

			model.addAttribute("empListe", listeEmp);
			return "afficherListe";
	
	
		
		
		
	}

	// autre solution pour modifier
	@RequestMapping(value="/affichFormAjout/{emp_id_param}", method= RequestMethod.GET)
		public String affichFormAModif(Model model, @PathVariable("emp_id_param") int id_emp ){
			
		Employe emp=eS.getEmployeByIdService(id_emp);
		eS.updateEmployeService(emp);
		return "afficherListe";
}
	// Methode pour afficher le formulaire de supprission
			@RequestMapping(value = "/affichFormmodif", method = RequestMethod.GET)
			public String affichFormModif(ModelMap model, @RequestParam("id_param") int id_emp ){
				System.out.println("id employe trouve"+id_emp );

				Employe emp=eS.getEmployeByIdService(id_emp);
				model.addAttribute("employeForm", emp);
				
				return "ajoutTest";
			}
	
	
	
}
	
	
	
	
