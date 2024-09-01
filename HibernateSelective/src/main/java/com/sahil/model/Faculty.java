package com.sahil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Id;

@Entity
@Table(name = "Faculty")
public class Faculty {
	@Id
	private int Id;
	private String Name;
	private String Department;
	@Transient
	private int Level;
	

	public Faculty() {
		System.out.println("Default Constructor");
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}


	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}


	@Override
	public String toString() {
		return "Faculty [Id=" + Id + ", Name=" + Name + ", Department=" + Department + ", Level=" + Level + "]";
	}
	
}
