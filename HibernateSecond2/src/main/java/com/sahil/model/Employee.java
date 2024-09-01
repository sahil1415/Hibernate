
package com.sahil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_information")
public class Employee {
    
    @Id
    @Column(name = "Student_Id")
    private int sid;

    @Column(name = "sname")
    private String sname;

    @Column(name = "scity")
    private String scity;

    public Employee() {
        System.out.println("Default Constructor");
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public void setScity(String scity) {
        this.scity = scity;
    }
    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getScity() {
        return scity;
    }

    @Override
    public String toString() {
        return "Student [sid=" + sid + ", sname=" + sname + ", scity=" + scity + "]";
    }
}
