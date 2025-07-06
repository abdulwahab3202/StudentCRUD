package com.kce.repository;

import com.kce.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    List<Student> findByNameContainingIgnoreCase(String name);
}