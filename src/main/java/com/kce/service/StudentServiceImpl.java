package com.kce.service;

import com.kce.enumeration.ResponseStatus;
import com.kce.models.Student;
import com.kce.repository.StudentRepository;
import com.kce.response.CommonResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<Student> getStudentByID(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteStudentByID(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public CommonResponce updateStudent(Student student) {
        CommonResponce response = new CommonResponce();
        try{
            Optional<Student> existingStudent = studentRepository.findById(student.getId());
            if(existingStudent.isPresent()){
                Student updateStudent = existingStudent.get();
                updateStudent.setName(student.getName());
                updateStudent.setAge(student.getAge());
                updateStudent.setEmail(student.getEmail());

                Student updatedStudent = studentRepository.save(updateStudent);
                response.setStatus(ResponseStatus.SUCCESS);
                response.setSuccessMessage("Student Updated Successfully");
                response.setData(updatedStudent);
                response.setCode(200);
                return response;
            }
            else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setErrorMessage("Student not found");
                response.setCode(404);
                return response;
            }
        }
        catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setErrorMessage("Failed to update student : " +  e.getMessage());
            response.setCode(500);
            return response;
        }
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

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
