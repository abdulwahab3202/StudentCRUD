package com.kce.controller;


import com.kce.models.Student;
import com.kce.response.CommonResponce;
import com.kce.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<CommonResponce> addStudent(@RequestBody Student student){
        CommonResponce response = studentService.addStudent(student);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping("/list")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/list/{id}")
    public Optional<Student> getStudentByID(@PathVariable String id){
        return studentService.getStudentByID(id);
    }

    @PutMapping("/update")
    public ResponseEntity<CommonResponce> updateStudent(@RequestBody Student student){
        CommonResponce response = studentService.updateStudent(student);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        studentService.deleteStudentByID(id);
        return "Student Deleted Successfully";
    }
}
