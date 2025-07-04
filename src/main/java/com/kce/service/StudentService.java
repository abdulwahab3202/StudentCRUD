package com.kce.service;

import com.kce.models.Student;
import com.kce.response.CommonResponce;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    public CommonResponce addStudent(Student student);
}
