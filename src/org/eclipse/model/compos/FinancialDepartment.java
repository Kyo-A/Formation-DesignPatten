package org.eclipse.model.compos;

public class FinancialDepartment implements Department {

	private Integer id;
	private String name;

	public void printDepartmentName() {
		System.out.println(getClass().getSimpleName());
	}

	public FinancialDepartment(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public FinancialDepartment() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FinancialDepartment [id=" + id + ", name=" + name + "]";
	}

	// standard constructor, getters, setters

}