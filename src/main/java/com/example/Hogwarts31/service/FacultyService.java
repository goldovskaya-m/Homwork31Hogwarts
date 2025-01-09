package com.example.Hogwarts31.service;


import com.example.Hogwarts31.model.Faculty;
import com.example.Hogwarts31.model.Student;

import java.util.Collection;
import java.util.List;

public interface FacultyService {
    long add(Faculty faculty);

    Faculty update(Long id, Faculty faculty);

    void deleteById(Long id);

    Faculty findById(Long id);

    Collection<Faculty> findAll();

    Collection<Faculty> findByColor(String color);

    List<Faculty> findByColorOrName(String color, String name);

    Collection<Student> findByAgeBetween(Long id);

}
