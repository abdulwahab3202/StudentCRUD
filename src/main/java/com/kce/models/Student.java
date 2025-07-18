package com.kce.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "student")
public class Student {
    @Id
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;
    private String city;
}
