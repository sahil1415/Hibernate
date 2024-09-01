
package com.sahil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name = "facultyinfo1")
public class FacultyInfo1 {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "my_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "my_seq", sequenceName = "MyOwnSequence", initialValue = 100, allocationSize = 1)
    private int e_id;
    
    
    private String e_name;
    private int e_age;
    private String e_city;
    private String e_email;
    
    // Default constructor
    public FacultyInfo1() {
        System.out.println("Default Constructor");
    }

    // Getters and Setters
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

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
    }

    @Override
    public String toString() {
        return "FacultyInfo [e_id=" + e_id + ", e_name=" + e_name + ", e_age=" + e_age + ", e_city=" + e_city
                + ", e_email=" + e_email + "]";
    }
}
