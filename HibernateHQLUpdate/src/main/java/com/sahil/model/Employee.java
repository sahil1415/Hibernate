
package com.sahil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeeinfo")
public class Employee {
	
	@Id
	@Column(name = "e_id")
	private int id;
	@Column(name = "e_name")
	private String name;
	@Column(name = "e_age")
	private int age;
	@Column(name = "e_city")
	private String city;
	
	public Employee() {
		System.out.println("Default Constructor");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}


	
}
