package com.project.school.service;

import com.project.school.entity.School;
import com.project.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school) { schoolRepository.save(school); }

    public List<School> findAllSchools() { return schoolRepository.findAll(); }
}
