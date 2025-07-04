package com.kce.controller;


import com.kce.models.Student;
import com.kce.response.CommonResponce;
import com.kce.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<CommonResponce> addStudent(@RequestBody Student student){
        CommonResponce response=studentService.addStudent(student);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping("/list")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
