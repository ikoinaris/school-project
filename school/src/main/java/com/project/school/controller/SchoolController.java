package com.project.school.controller;

import com.project.school.dto.FullSchoolResponse;
import com.project.school.entity.School;
import com.project.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school) { schoolService.saveSchool(school); }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() { return ResponseEntity.ok(schoolService.findAllSchools()); }

    @GetMapping("with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findAllStudentsBySchoolId(@PathVariable("schoolId") Integer schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }
}
