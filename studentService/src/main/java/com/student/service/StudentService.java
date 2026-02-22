package com.student.service;

import com.student.entities.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    Student getById(Long id);

    List<Student> getAll();

    List<Student> findByCollegeId(Long id);
}
