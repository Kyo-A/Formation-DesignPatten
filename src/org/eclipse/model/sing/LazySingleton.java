package org.eclipse.model.sing;

// Principales caractéristiques :

// Un singleton, c'est un objet construit conformément à sa classe et dont on a la garantie 
// qu'il n'existe qu'une et une seule instance en mémoire à un instant donné.

// En cas d'accès concurrent lors de l'instanciation d'un singleton, il faut veiller à ce que cet aspect 
// soit pris en compte par un mécanisme de verrous.

// En général, on souhaite que le singleton ne s'initialise pas entièrement, mais seulement à son premier 
// appel, afin d'économiser de la mémoire. On appelle cela le mécanisme « lazy ».

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
