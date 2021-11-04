package org.eclipse.model.afab;

public class Duck implements Animal {

	private String name;

	public Duck() {
		super();
	}

	public Duck(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAnimal() {
		return "Duck";
	}

	@Override
	public String makeSound() {
		return "Squeks";
	}
}
