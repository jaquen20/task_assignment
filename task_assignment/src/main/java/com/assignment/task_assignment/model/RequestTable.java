package com.assignment.task_assignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data @Entity
public class RequestTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int age;
    String address;
    String mobile_no;
    String role;
    String cv;
}
