package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

public class Panier implements Serializable{
	
	private List<Commande> listeCommande;

	public Panier() {
		super();
	}

	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}
	
}
