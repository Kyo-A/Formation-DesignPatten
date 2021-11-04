package org.eclipse.model.poly;

import java.util.ArrayList;
import java.util.Iterator;

public class Plan {

	private ArrayList<Forme> formes; // liste des formes positionnees sur le plan

	private Rectangle contour; // Rectangle definissant les contours du plan

	public Plan(int largeur, int hauteur) {

		formes = new ArrayList<Forme>();
	}

	/**
	 * Ajout d'une forme f au plan precondition : f est entierement contenue dans
	 * this
	 * 
	 * @param f la forme a ajouter a this
	 */
	public void ajoute(Forme f) {
		formes.add(f);

	}

	/**
	 * Suppression de la forme f du plan precondition : f est une forme contenue
	 * dans this
	 * 
	 * @param f la forme a supprimer de this
	 */
	public void supprime(Forme f) {
		formes.remove(f);
	}

	/**
	 * Recherche d'une forme f contenant le point p
	 * 
	 * @param p le point
	 * @return null si aucune forme de this ne contient p ; une forme f contenant p
	 *         sinon
	 */
	public Forme cherche(Point p) {
		for (Forme f : formes) {
			if (f.contient(p))
				return f;
		}
		return null;
	}

	/**
	 * @param f une forme
	 * @return true si la forme f est entierement contenue dans this
	 */
	public boolean contient(Forme f) {
		return f.contenuDans(contour);
	}

	/**
	 * @return la largeur de this
	 */
	public int getLargeur() {
		return contour.getLargeur();
	}

	/**
	 * @return la hauteur de this
	 */
	public int getHauteur() {
		return contour.getHauteur();
	}

	/**
	 * @return un iterateur sur les formes contenues dans this
	 */
	public Iterator<Forme> getIterateurFormes() {
		return formes.iterator();
	}

	/**
	 * Determine si toutes les formes du plan sont disjointes de f1
	 * 
	 * @param f1 une forme
	 * @return false si this contient une forme f2 differente de f1 telle que f1 et
	 *         f2 ne sont pas disjointes
	 */
	public boolean tousDisjoints(Forme f1) {
		for (Forme f2 : formes) {
			if ((f2 != f1) && (!f2.disjoint(f1)))
				return false;
		}
		return true;
	}

	/**
	 * Re-initialise le plan : supprime les formes du plan courant et met a jour la
	 * largeur et la hauteur
	 * 
	 * @param largeur la largeur du contour de this
	 * @param hauteur la hauteur du contour de this
	 */
	public void reset(int largeur, int hauteur) {
		Iterator<Forme> it = formes.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}

		PointFactory.initPointFactory(largeur, hauteur);
		contour = new Rectangle(PointFactory.creePoint(0, 0), largeur, hauteur);
	}

}
