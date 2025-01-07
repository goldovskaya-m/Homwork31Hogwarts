package com.example.Hogwarts31.repository;

import com.example.Hogwarts31.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findByColor(String color);
    //List<Faculty> findByName(String name);

}
