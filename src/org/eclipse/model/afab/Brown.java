package org.eclipse.model.afab;

public class Brown implements Color{
	private String name;

	public Brown() {
		super();
	}

	public Brown(String name) {
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
