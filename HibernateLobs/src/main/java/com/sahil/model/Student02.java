package com.sahil.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Student02 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_id;
	private String s_name;
	
	@Lob
	@Column(length = 100000)
	private byte[] imageFile;
	@Lob
	private char[] textFile;
	
	public Student02() {
		System.out.println("Default Constructir");
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

	public byte[] getImageFile() {
		return imageFile;
	}

	public void setImageFile(byte[] imageFile) {
		this.imageFile = imageFile;
	}

	public char[] getTextFile() {
		return textFile;
	}

	public void setTextFile(char[] textFile) {
		this.textFile = textFile;
	}

	@Override
	public String toString() {
		return "Student02 [s_id=" + s_id + ", s_name=" + s_name + ", imageFile=" + Arrays.toString(imageFile)
				+ ", textFile=" + Arrays.toString(textFile) + "]";
	}

	
	
}
