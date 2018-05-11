/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.domain.Major;
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
    
    
}
