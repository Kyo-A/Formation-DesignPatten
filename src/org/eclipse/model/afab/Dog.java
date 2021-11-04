package org.eclipse.model.afab;

public class Dog implements Animal {

	private String name;

	public Dog() {
		super();
	}

	public Dog(String name) {
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
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "Woaf";
    }
}
