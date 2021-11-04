package org.eclipse.model.compos.exos2;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employe {

	private int salary;
	private List<Sub> subs;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int salary) {
		this.salary = salary;
		this.subs = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
	}

	public List<Sub> getSubs() {
		return subs;
	}

	public void setSubs(List<Sub> subs) {
		this.subs = subs;
	}

	@Override
	public int getCost() {
		Integer count = this.subs.stream().map(Sub::getSalary).reduce(0, (a, b) -> a + b);
		return salary + count;
	}


	public void addSub(Sub sub) {
		subs.add(sub);
	}

}
