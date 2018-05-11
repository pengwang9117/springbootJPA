/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class Course {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="major")
    private Major major;
    
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="CS", joinColumns=@JoinColumn(name="course"), inverseJoinColumns=@JoinColumn(name="student"))
    private List<Student> student = new ArrayList<Student>();
    
    @JsonIgnore
    @OneToMany(mappedBy="course")
    private List<Grade> grade = new ArrayList<Grade>();

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

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Grade> getGrade() {
        return grade;
    }

    public void setGrade(List<Grade> grade) {
        this.grade = grade;
    }
    
    
}
