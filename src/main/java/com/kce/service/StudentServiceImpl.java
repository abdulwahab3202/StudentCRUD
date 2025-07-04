package com.kce.service;

import com.kce.enumeration.ResponseStatus;
import com.kce.models.Student;
import com.kce.repository.StudentRepository;
import com.kce.response.CommonResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public CommonResponce addStudent(Student student) {
        Student addedStudent = studentRepository.save(student);
        try{
            CommonResponce response = new CommonResponce();
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("Student Created Successfully");
            response.setData(addedStudent);
            response.setCode(201);
            return response;
        }
        catch (Exception e){
            CommonResponce response = new CommonResponce();
            response.setStatus(ResponseStatus.FAILURE);
            response.setErrorMessage("Failed to add student : " + e.getMessage());
            response.setCode(500);
            return response;
        }
    }
}
