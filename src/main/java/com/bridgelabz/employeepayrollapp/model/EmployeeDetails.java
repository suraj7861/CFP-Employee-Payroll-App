package com.bridgelabz.employeepayrollapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_payroll")
public class EmployeeDetails {
	@Id
	private long id;
	private String name;
	private long salary;
	
	public EmployeeDetails() {
		id = 0;
		name = "";
		salary = 0;
	}
	
	public EmployeeDetails(long id, String name, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
