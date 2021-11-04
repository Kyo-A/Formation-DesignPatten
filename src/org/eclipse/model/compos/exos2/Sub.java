package org.eclipse.model.compos.exos2;

public class Sub implements Employe {

	private int salary;

	public Sub() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sub(int salary) {
		this.salary = salary;
	}

	@Override
	public int getCost() {
		return salary;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Sub [salary=" + salary + "]";
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
