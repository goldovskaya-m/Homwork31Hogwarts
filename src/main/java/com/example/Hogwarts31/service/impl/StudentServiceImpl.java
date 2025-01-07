package com.example.Hogwarts31.service.impl;

import com.example.Hogwarts31.model.Student;
import com.example.Hogwarts31.model.exception.StudentNotFoundException;
import com.example.Hogwarts31.repository.StudentRepository;
import com.example.Hogwarts31.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    //private final Map<Long, Student> repository = new HashMap<>();
    //private long counter = 0;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public long add(Student student) {
        // student.setId(++counter);
        // repository.put(counter, student);
        //return counter;
        if (studentRepository.existsById(student.getId()))
            throw new RuntimeException(("Факультет уже существует"));
        return studentRepository.save(student).getId();
    }

    @Override
    public Student update(Long id, Student student) {
        checkStudentExist(id);
        student.setId(id);
        //Student studentForUpdate = repository.get(id);
        //return repository.put(id, student);
        return studentRepository.save(student);
    }


    @Override
    public Student deleteById(Long id) {
        checkStudentExist(id);
       // return repository.remove(id);
        studentRepository.deleteById(id);
        return null;

    }

    @Override
    public Student findById(Long id) {
       // return repository.get(id);
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public Collection<Student> FindAll() {
        return (studentRepository.findAll());
        //return Collections.unmodifiableCollection
         //       (repository.values());
    }

    @Override
    public Collection<Student> FindByAge(int age) {
        //return repository.values().stream()

               // .filter(st -> st.getAge() == age)
              //  .toList();

        return studentRepository.findAll().stream()
                .filter(student -> student.getAge() == age).toList()
                ; //studentRepository.findByAge();
    }

    @Override
    public Collection<Student> findByAgeBetween(int min, int max) {
        return  studentRepository.findByAgeBetween( min, max);
    }

    private void checkStudentExist(Long id) {
        //if (!repository.containsKey(id)) {
        //if (!studentRepository(id)) {
            throw new StudentNotFoundException(id);
        }
    }

