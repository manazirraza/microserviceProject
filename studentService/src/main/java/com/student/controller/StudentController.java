package com.student.controller;

import com.student.entities.Student;
import com.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student save(@RequestBody Student student){
        return service.save(student);
    }

    @GetMapping
    public List<Student> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/college/{id}")
    public List<Student> getByCollegeId(@PathVariable Long id){

        return service.findByCollegeId(id);
    }
}
