package org.eclipse.model.afab;

public class White implements Color {
	private String name;

	public White() {
		super();
	}

	public White(String name) {
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
	public String getColor() {
		// TODO Auto-generated method stub
		return name;
	}

}
