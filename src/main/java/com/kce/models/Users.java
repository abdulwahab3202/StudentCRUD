package com.kce.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user")
public class Users {
    @Id
    private String id;
    private String username;
    private String password;
    private String role;
}