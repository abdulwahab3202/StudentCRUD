package com.kce.service;

import com.kce.models.Student;
import com.kce.response.CommonResponce;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    public CommonResponce addStudent(Student student);
    public List<Student> getStudents();
}
