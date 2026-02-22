package com.student.service;

import com.student.entities.Student;
import com.student.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }


    @Override
    public Student save(Student student) {
        return repo.save(student);
    }

    @Override
    public Student getById(Long id) {
        return repo.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAll() {
        return repo.findAll();

    }

    @Override
    public List<Student> findByCollegeId(Long id) {
        List<Student> byCollegeId = repo.findByCollegeId(id);
        return byCollegeId;
    }
}
