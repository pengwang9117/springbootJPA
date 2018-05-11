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
public class StudentController {
    @Autowired
    private StudentRepository sr;
    @Autowired
    private MajorRepository mr;
    @Autowired
    private CourseRepository cr;
    @Autowired
    private GradeRepository gr;
    
    @RequestMapping("/createstudent")
    public String createstudent(String sname) {
        Student s = new Student();
        s.setName(sname);
        sr.save(s);
        return "success";
    }
    
    @RequestMapping("/setstudentmajor")
    public String setstudentmajor(String sname, String mname) {
        Student s = sr.findByName(sname);
        Major m = mr.findByName(mname);
        s.setMajor(m);
        sr.save(s);
        return "success";
    }
    
    @RequestMapping("/setstudentcourse")
    public String setstudentcourse(String sname, String cname) {
        Student s = sr.findByName(sname);
        Course c = cr.findByName(cname);
        List<Student> cs = c.getStudent();
        cs.add(s);
        c.setStudent(cs);
        cr.save(c);
        return "success";
    }
    
    @RequestMapping("/setstudentgrade")
    public String setstudentgrade(String sname, String cname, String grade) {
        Student s = sr.findByName(sname);
        Course c = cr.findByName(cname);
        Grade g = new Grade();
        g.setStudent(s);
        g.setCourse(c);
        g.setG(grade);
        gr.save(g);
        return "success";
    }
    
    
    @RequestMapping("/findstudentname")
    public Student findstudentname(String sname) {
        return sr.findByName(sname);
    }
    
    @RequestMapping("/findstudentmajor")
    public List<Student> findstudentmajor(String mname) {
        Major m = mr.findByName(mname);
        return sr.findByMajor(m);
    }
    
    @RequestMapping("/findstudentcourse")
    public List<Student> findstudentcourse(String cname) {
        Course c = cr.findByName(cname);
        return sr.findByCourse(c);
    }
    
    @RequestMapping("/findgradestudent")
    public List<Grade> findgradestudent(String sname) {
        Student s = sr.findByName(sname);
        return gr.findByStudent(s);
    }
    
    @RequestMapping("/pullstudentcourse")
    public List<Course> pullstudentcourse(String sname){
        Student s = sr.findByName(sname);
        return s.getCourse();
    }
}
