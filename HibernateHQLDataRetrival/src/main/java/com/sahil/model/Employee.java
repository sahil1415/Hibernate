package com.sahil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeeinfo")
public class Employee {
	
	@Id
	private int e_id;
	private String e_name;
	private int e_age;
	private String e_city;
	
	public Employee() {
		System.out.println("Default Constructor");
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public int getE_age() {
		return e_age;
	}

	public void setE_age(int e_age) {
		this.e_age = e_age;
	}

	public String getE_city() {
		return e_city;
	}

	public void setE_city(String e_city) {
		this.e_city = e_city;
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", e_name=" + e_name + ", e_age=" + e_age + ", e_city=" + e_city + "]";
	}
	
}
