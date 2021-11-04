package org.eclipse.model.afab;

public class Bear implements Animal {

	private String name;

	public Bear() {
		super();
	}

	public Bear(String name) {
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
		return name;
	}

	@Override
	public String makeSound() {
		return "RRRRRRRR";
	}

}
