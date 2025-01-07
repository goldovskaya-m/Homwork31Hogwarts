package com.example.Hogwarts31.service.impl;

import com.example.Hogwarts31.model.Faculty;
import com.example.Hogwarts31.model.exception.FacultyNotFoundException;
import com.example.Hogwarts31.repository.FacultyRepository;
import com.example.Hogwarts31.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public long add(Faculty faculty) {
        if (facultyRepository.existsById(faculty.getId()))
            throw new RuntimeException("Студент уже существует");
        return facultyRepository.save(faculty).getId();

    }

    @Override
    public Faculty update(Long id, Faculty faculty) {
        checkFacultyExist(id);
        faculty.setId(id);
        return facultyRepository.save(faculty);
    }


    @Override
    public void deleteById(Long id) {
        checkFacultyExist(id);
         facultyRepository.deleteById(id);
    }

    @Override
    public Faculty findById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException(id));
    }

    @Override
    public Collection<Faculty> findAll() {
               return  (facultyRepository.findAll());
    }

    @Override
    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findByColor(color);
    }

   // @Override
   // public Collection<Faculty> findByName(String name) {
    //    return facultyRepository.findByName(name);
    //}


    @Override
    public List<Faculty> findByColorOrName(String color, String name) {
        return List.of();
    }

    private void checkFacultyExist(Long id) {
        if (!facultyRepository.existsById(id)) {
            throw new FacultyNotFoundException(id);
        }
    }
}
