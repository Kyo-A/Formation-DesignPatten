package org.eclipse.model.fab;

//Classe usine qui représente un bâtiment capable de construire des unités.
public class Usine {
	private SimpleFabrique simpleFabrique;// Attribut contenant la fabrique simple.

	// Le constructeur permet de sélectionner la fabrique à utiliser.
	public Usine() {
		this.simpleFabrique = new SimpleFabrique();
	}

	// Méthode qui permet de construire l'ensemble des unités.
	public Unite formerUnite(TypeUnite type) {
		Unite unite = this.simpleFabrique.creerUnite(type);
		unite.consommerRessource();
		unite.equiper();
		return unite;
	}
}
