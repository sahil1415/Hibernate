package com.sahil.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student01 {
	@Id
	private int s_id;
	private String s_name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Courses01> course;


	public Student01() {
		System.out.println("Default Constructor of Student");
	}
	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public Set<Courses01> getCourse() {
		return course;
	}

	public void setCourse(Set<Courses01> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student01 [s_id=" + s_id + ", s_name=" + s_name + ", course=" + course + "]";
	}



}
