/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.domain.Course;
import com.example.demo.domain.Major;
import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author root
 */
public interface MajorRepository extends JpaRepository<Major, Integer>{
    Major findByName(String name);
    
    Major findByCourse(Course course);
    Major findByStudent(Student student);
}
