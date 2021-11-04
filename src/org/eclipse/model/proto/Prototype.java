package org.eclipse.model.proto;

public interface Prototype {

	// La m�thode getClone() sera impl�ment�e dans la classe qui impl�mentera le prototype 
	// pour retourner un nouvel objet de la m�me classe.
    public Prototype getClone();

}
