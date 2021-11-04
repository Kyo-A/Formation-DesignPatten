package org.eclipse.model.afab;

public class AnimalFactory implements AbstractFactory<Animal> {

	@Override
	public Animal create(String animalType, String name) {
		if ("Bear".equalsIgnoreCase(animalType)) {
			return new Bear(name);
		} else if ("Duck".equalsIgnoreCase(animalType)) {
			return new Duck(name);
		} else if ("Dog".equalsIgnoreCase(animalType)) {
			return new Dog(name);
		}
		return null;
	}


}
