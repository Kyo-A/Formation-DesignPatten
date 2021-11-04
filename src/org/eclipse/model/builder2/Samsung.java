package org.eclipse.model.builder2;

public class Samsung extends Company {
	@Override
	public int price() {
		return 15;
	}

	@Override
	public String pack() {
		return "Samsung CD";
	}
}
