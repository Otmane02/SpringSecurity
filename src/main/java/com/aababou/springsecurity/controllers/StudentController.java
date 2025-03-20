package com.aababou.springsecurity.controllers;

import com.aababou.springsecurity.models.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
author otman
    */

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"otmane","1234"),
            new Student(1,"malika","567"),
            new Student(1,"ahmed","abab")

    )
    );

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("student")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
