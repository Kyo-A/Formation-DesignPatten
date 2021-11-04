package org.eclipse.model.fab;

import org.eclipse.model.*;

//Classe permettant de fabriquer une unité.
public class SimpleFabrique {
	// La création d'une unité en fonction de son type est encapsulée dans la
	// fabrique.
	public Unite creerUnite(TypeUnite type) {
		Unite unite = null;

		switch (type) {
		case SOLDAT:
			unite = new SoldatHumain();
			break;
		case COMMANDANT:
			unite = new CommandantHumain();
			break;
		}
		return unite;
	}
}
