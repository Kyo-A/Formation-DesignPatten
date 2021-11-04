package org.eclipse.model.proto;

public interface Prototype {

	// La méthode getClone() sera implémentée dans la classe qui implémentera le prototype 
	// pour retourner un nouvel objet de la même classe.
    public Prototype getClone();

}
