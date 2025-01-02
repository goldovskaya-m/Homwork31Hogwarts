package com.example.Hogwarts31.controller;

import com.example.Hogwarts31.model.Faculty;
import com.example.Hogwarts31.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RestController
@RequestMapping("/faculty")

public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/add")
    public long add(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }

    @PutMapping("/{id}/update")
    public Faculty update(@PathVariable("id") Long id,
                          @RequestBody Faculty faculty) {
        return facultyService.update(id, faculty);
    }

    @DeleteMapping("/{id}/remove")
    public Faculty deleteById(@PathVariable("id") Long id) {
        return facultyService.deleteById(id);
    }

    @GetMapping("/{id}/get")
    public Faculty findById(@PathVariable("id") Long id) {
        return facultyService.findById(id);
    }

    @GetMapping("/get/all")
    public Collection<Faculty> FindAll() {
        return facultyService.findAll();
    }


    @GetMapping("/get/by-color")
    public Collection<Faculty> findByColor(@RequestParam("color") String color) {
        return facultyService.findByColor(color);
    }

}
