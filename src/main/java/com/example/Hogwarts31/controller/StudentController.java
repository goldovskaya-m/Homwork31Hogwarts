package com.example.Hogwarts31.controller;

import com.example.Hogwarts31.model.Student;
import com.example.Hogwarts31.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public long add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping("/{id}/update")
    public Student update(@PathVariable("id") Long id,
                          @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}/remove")
    public Student deleteById(@PathVariable("id") Long id) {
        return studentService.deleteById(id);
    }

    @GetMapping("/{id}/get")
    public Student findById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/get/all")
    public Collection<Student> FindAll() {
        return studentService.FindAll();
    }

    @GetMapping("/get/by-age")
    public Collection<Student> FindByAge(@RequestParam("age") int age) {
        return studentService.FindByAge(age);
    }

    // @GetMapping("/get/by-age-between")
    // public List<Student> findByAgeBetween(@RequestParam("min") int min,
    //                                      @RequestParam("max") int max) {
    //   return studentService.findByAgeBetween(min, max);
    //}
}
