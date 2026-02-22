package com.college.service;

import com.college.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "studentService")
public interface StudentClient {

    @GetMapping("/student/college/{id}")
    List<Student> getStudentsOfCollege(@PathVariable Long id);
}
