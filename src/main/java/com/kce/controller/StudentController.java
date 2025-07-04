package com.kce.controller;

import com.kce.enumeration.ResponseStatus;
import com.kce.models.Student;
import com.kce.response.CommonResponce;
import com.kce.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

}
