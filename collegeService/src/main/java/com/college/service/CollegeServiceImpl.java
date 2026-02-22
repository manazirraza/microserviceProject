package com.college.service;

import com.college.entities.College;
import com.college.repositories.CollegeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeServiceImpl implements CollegeService {

    private CollegeRepository repo;
    private StudentClient studentClient;

    public CollegeServiceImpl(CollegeRepository repo, StudentClient studentClient) {
        this.repo = repo;
        this.studentClient = studentClient;
    }

    @Override
    public College saveCollege(College college) {
        return repo.save(college);
    }

    @Override
    public List<College> getAllCollege() {
        List<College> colleges = repo.findAll();
        List<College> colleges1 = colleges.stream().map(college -> {
            college.setStudent(studentClient.getStudentsOfCollege(college.getId()));
            return college;
        }).collect(Collectors.toList());

        return colleges1;
    }

    @Override
    public College getById(Long id) {
        College college = repo.findById(id).orElseThrow(() -> new RuntimeException("College not found"));
        college.setStudent(studentClient.getStudentsOfCollege(college.getId()));

        return college;

    }
}
