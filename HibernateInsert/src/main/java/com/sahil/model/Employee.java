package com.sahil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	private int e_id;
	private String e_name;
	private String e_city;
	
	public Employee() {
		System.out.println("Default Constructor");
	}



	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getE_id() {
		return e_id;
	}



	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_name() {
		return e_name;
	}



	public void setE_city(String e_city) {
		this.e_city = e_city;
	}
	public String getE_city() {
		return e_city;
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", e_name=" + e_name + ", e_city=" + e_city + "]";
	}
	
	
}
