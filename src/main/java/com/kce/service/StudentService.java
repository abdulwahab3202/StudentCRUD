package com.kce.service;

import com.kce.models.Student;
import com.kce.response.CommonResponce;

public interface StudentService {
    public CommonResponce addStudent(Student student);
    public CommonResponce getStudents();
    public CommonResponce getStudentByID(String id);
    public CommonResponce updateStudent(Student student);
    public CommonResponce deleteStudentByID(String id);
    public CommonResponce searchStudentsByName(String name);
}