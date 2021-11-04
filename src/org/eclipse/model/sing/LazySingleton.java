package org.eclipse.model.sing;

// Principales caract�ristiques :

// Un singleton, c'est un objet construit conform�ment � sa classe et dont on a la garantie 
// qu'il n'existe qu'une et une seule instance en m�moire � un instant donn�.

// En cas d'acc�s concurrent lors de l'instanciation d'un singleton, il faut veiller � ce que cet aspect 
// soit pris en compte par un m�canisme de verrous.

// En g�n�ral, on souhaite que le singleton ne s'initialise pas enti�rement, mais seulement � son premier 
// appel, afin d'�conomiser de la m�moire. On appelle cela le m�canisme � lazy �.

public class LazySingleton {

	private static final LazySingleton instance = new LazySingleton();

	private LazySingleton() {
		System.out.println("Construction du Singleton au premier appel");
	}

	public static final LazySingleton getInstance() {
		return instance;
	}
	
	public static final String getMessage() {
		return "INSTANCE";
	}

	@Override
	public String toString() {
		return String.format("Je suis le LazySingleton : %s", LazySingleton.getMessage());
	}
}
