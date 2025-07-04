package com.kce.service;

import com.kce.models.Student;
import com.kce.response.CommonResponce;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public CommonResponce addStudent(Student student);
    public List<Student> getStudents();
    public Optional<Student> getStudentByID(String id);
}