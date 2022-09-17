package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private UUID id;

    private final Integer age;
    private final String firstName;
    private final String lastName;
    private final String course;

    public Student(
        @JsonProperty("id") UUID id, 
        @JsonProperty("age") Integer age,
        @JsonProperty("firstName")String firstName,
        @JsonProperty("secondName")String lastName,
        @JsonProperty("course") String course) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    
}
