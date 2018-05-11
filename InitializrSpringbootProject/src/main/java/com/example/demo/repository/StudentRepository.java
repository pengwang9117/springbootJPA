/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.domain.Course;
import com.example.demo.domain.Grade;
import com.example.demo.domain.Major;
import com.example.demo.domain.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author root
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    Student findByName(String name);
    
    List<Student> findByMajor(Major major);
    List<Student> findByCourse(Course course);
    
    
}
