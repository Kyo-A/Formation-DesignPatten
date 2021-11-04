package org.eclipse.model.fab;

import java.util.ArrayList;

//Classe abstraite dont toutes les unités du jeu hériteront.
public abstract class Unite {
	protected String nom;// Nom de l'unité.
	protected int coutConstruction;// Coût de construction de l'unité.
	protected int precisionAttaque;// Précision de l'attaque de l'unité.
	protected int esquiveDefense;// Faculté d'esquiver une attaque de l'unité.
	protected ArrayList equipements;// Tableau des équipements de l'unité.

	// Méthode qui consomme les ressources pour créer une unité.
	public void consommerRessource() {
		System.out.println("Consomme " + this.coutConstruction + " ressources pour la création de l'unité.");
	}

	// Méthode abstraite qui permet d'équiper l'unité.
	public abstract void equiper();

	// Méthode générique pour l'affichage de l'unité.
	public String toString() {
		String str = "Nom : " + this.nom + "\n";
		str += "Coût de construction : " + this.coutConstruction + "\n";
		str += "Précision d'attaque : " + this.precisionAttaque + "\n";
		str += "Esquive en défense : " + this.esquiveDefense + "\n";
		str += "Equipements : ";
		for (int i = 0; i < this.equipements.size(); i++) {
			str += this.equipements.get(i) + " ";
		}
		return str;
	}
}
