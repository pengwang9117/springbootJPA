/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Major;
import com.example.demo.domain.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MajorRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
public class MajorController {
    @Autowired
    private StudentRepository sr;
    @Autowired
    private MajorRepository mr;
    @Autowired
    private CourseRepository cr;
    
    @RequestMapping("/createmajor")
    public String createmajor(String mname) {
        Major m = new Major();
        m.setName(mname);
        mr.save(m);
        return "success";
    }
    
    @RequestMapping("/findmajorname")
    public Major findmajorname(String mname) {
        return mr.findByName(mname);
    }
    
    @RequestMapping("/findmajorcourse")
    public Major findmajorcourse(String cname) {
        Course c = cr.findByName(cname);
        return mr.findByCourse(c);
    }
    
    @RequestMapping("/findmajorstudent")
    public Major findmajorstudent(String sname) {
        Student s = sr.findByName(sname);
        return mr.findByStudent(s);
    }
}
