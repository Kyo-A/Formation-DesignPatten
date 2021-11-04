package org.eclipse.model.afab;

public interface AbstractFactory<T> {
	
    T create(String animalType, String name) ;
}