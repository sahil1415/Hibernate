package com.sahil.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "facultyinfo")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class FacultyInfo {
    @Id
    private int e_id;
    
    
    private String e_name;
    private int e_age;
    private String e_city;
    private String e_email;
    
    // Default constructor
    public FacultyInfo() {
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
