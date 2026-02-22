package com.college.service;

import com.college.entities.College;

import java.util.List;

public interface CollegeService {

    College saveCollege(College college);

    List<College> getAllCollege();

    College getById(Long id);
}
