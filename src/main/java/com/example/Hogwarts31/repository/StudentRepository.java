package com.example.Hogwarts31.repository;

import com.example.Hogwarts31.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAgeBetween(int min, int max);

    //идентичны
    //@Query(value = "SELECT * FROM STUDENT WHERE AGE BETWEEN :min and:max",
      //    nativeQuery = true)
     //List<Student> findByAgeBetween(int min, int max);
}
