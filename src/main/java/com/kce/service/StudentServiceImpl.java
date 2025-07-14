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
    public CommonResponce getStudentByID(String id) {
        CommonResponce response = new CommonResponce();
        try{
            Optional<Student> student =  studentRepository.findById(id);
            if(student.isPresent()){
                response.setStatus(ResponseStatus.SUCCESS);
                response.setSuccessMessage("Student retrieved successfully");
                response.setData(student);
                response.setCode(200);
                return response;
            }
            else{
                response.setStatus(ResponseStatus.FAILURE);
                response.setErrorMessage("Student Not Found");
                response.setCode(500);
                return response;
            }
        }
        catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setErrorMessage("Failed to retrieve student");
            response.setCode(500);
            return response;
        }
    }

    @Override
    public CommonResponce deleteStudentByID(String id) {
        CommonResponce response = new CommonResponce();
        try{
            Optional<Student> existingStudent = studentRepository.findById(id);
            if(existingStudent.isPresent()){
                studentRepository.deleteById(id);
                response.setStatus(ResponseStatus.SUCCESS);
                response.setSuccessMessage("Student Deleted Successfully");
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
            response.setErrorMessage("Failed to delete student : " +  e.getMessage());
            response.setCode(500);
            return response;
        }
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
                updateStudent.setCourse(student.getCourse());
                updateStudent.setCity(student.getCity());

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
    public CommonResponce getStudents() {
        CommonResponce response = new CommonResponce();
        try{
            List<Student> students = studentRepository.findAll();
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("Students retrieved successfully");
            response.setData(students);
            response.setCode(200);
            return response;
        }
        catch (Exception e){
            response.setStatus(ResponseStatus.SUCCESS);
            response.setErrorMessage("Failed to retrieve students");
            response.setCode(500);
            return response;
        }
    }

    @Override
    public CommonResponce addStudent(Student student) {
        CommonResponce response = new CommonResponce();
        try{
            Student addedStudent = studentRepository.save(student);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("Student Created Successfully");
            response.setData(addedStudent);
            response.setCode(201);
            return response;
        }
        catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setErrorMessage("Failed to add student : " + e.getMessage());
            response.setCode(500);
            return response;
        }
    }

    @Override
    public CommonResponce searchStudentsByName(String name) {
        CommonResponce response = new CommonResponce();
        try{
            List<Student> students = studentRepository.findByNameContainingIgnoreCase(name);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("Student Searched Successfully");
            response.setData(students);
            response.setCode(201);
            return response;
        }
        catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setErrorMessage("Failed to search student : " + e.getMessage());
            response.setCode(500);
            return response;
        }
    }
}
