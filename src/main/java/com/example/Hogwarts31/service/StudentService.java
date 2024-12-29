package com.example.Hogwarts31.service;

import com.example.Hogwarts31.model.Student;

import org.springframework.stereotype.Service;

import java.util.Collection;

public interface StudentService {

    long add(Student student);

    Student update(Long id, Student faculty);

    Student deleteById(Long id);

    Student findById(Long id);

    Collection<Student> FindAll();

    Collection<Student> FindByAge(int age);

}