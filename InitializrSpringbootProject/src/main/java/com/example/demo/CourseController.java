/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Grade;
import com.example.demo.domain.Major;
import com.example.demo.domain.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.GradeRepository;
import com.example.demo.repository.MajorRepository;
import com.example.demo.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
public class CourseController {
    @Autowired
    private StudentRepository sr;
    @Autowired
    private CourseRepository cr;
    @Autowired
    private MajorRepository mr;
    @Autowired
    private GradeRepository gr;
    
    @RequestMapping("/createcourse")
    public String createcourse(String cname) {
        Course c = new Course();
        c.setName(cname);
        cr.save(c);
        return "success";
    }
    
    @RequestMapping("/setcoursemajor")
    public String setcoursemajor(String cname, String mname) {
        Course c = cr.findByName(cname);
        Major m = mr.findByName(mname);
        c.setMajor(m);
        cr.save(c);
        return "success";
    }
    
    
    @RequestMapping("/findcoursename")
    public Course findcoursename(String cname) {
        return cr.findByName(cname);
    }
    
    @RequestMapping("/findcoursemajor")
    public List<Course> findcoursemajor(String mname) {
        Major m = mr.findByName(mname);
        return cr.findByMajor(m);
    }
    
    @RequestMapping("/findcoursestudent")
    public List<Course> findcoursestudent(String sname) {
        Student s = sr.findByName(sname);
        return cr.findByStudent(s);
    }
    
    @RequestMapping("/findgradecourse")
    public List<Grade> findgradecourse(String cname) {
        Course c = cr.findByName(cname);
        return gr.findByCourse(c);
    }
    
}
