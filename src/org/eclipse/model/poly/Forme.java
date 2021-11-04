package org.eclipse.model.poly;

public interface Forme {

	boolean contient(Point p);
	void deplace(int deltaX, int deltaY);
	boolean disjoint(Forme f);
	boolean contenuDans(Rectangle r);

}
