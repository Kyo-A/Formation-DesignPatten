package org.eclipse.model.fab;

import org.eclipse.model.*;

//Classe permettant de fabriquer une unit�.
public class SimpleFabrique {
	// La cr�ation d'une unit� en fonction de son type est encapsul�e dans la
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
