package com.college.controller;

import com.college.entities.College;
import com.college.service.CollegeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    private CollegeService service;
    public CollegeController(CollegeService service) {
        this.service = service;
    }

    @PostMapping
    public College saveCollege(@RequestBody College college){
        return service.saveCollege(college);
    }

    @GetMapping
    public List<College> getAllCollege(){
        return service.getAllCollege();
    }

    @GetMapping("/{id}")
    public College getById(@PathVariable Long id){
        return service.getById(id);
    }
}
