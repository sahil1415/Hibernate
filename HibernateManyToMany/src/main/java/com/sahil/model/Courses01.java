package com.sahil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Courses01 {
	
	@Id
	private int c_id;
	private String c_name;
	private int c_price;
	
	public Courses01() {
		System.out.println("Default constructor of courses");
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_price() {
		return c_price;
	}

	public void setC_price(int c_price) {
		this.c_price = c_price;
	}

	@Override
	public String toString() {
		return "Courses01 [c_id=" + c_id + ", c_name=" + c_name + ", c_price=" + c_price + "]";
	}
	
	
}
