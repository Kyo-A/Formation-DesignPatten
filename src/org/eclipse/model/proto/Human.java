package org.eclipse.model.proto;

public class Human implements Prototype {

	private String name;
	private String lastName;
	private int age;

	public Human() {
		System.out.println(" Human description ");
		System.out.println("---------------------------------");
		System.out.println("Name" + "\t" + "Last Name" + "\t" + "Age");
	}

	public Human(String name, String lastName, int age) {
		this();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		showHuman();
	}

	private void showHuman() {
		System.out.println(name + "\t" + lastName + "\t" + age);
	}

	// getClone() renverra un autre humain avec le même nom, le même nom et le même âge que celui 
	//créé auparavant.
	@Override
	public Prototype getClone() {
		return new Human(name, lastName, age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	
	
	
}
